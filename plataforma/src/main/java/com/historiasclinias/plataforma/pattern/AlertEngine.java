package com.historiasclinias.plataforma.pattern;

import com.historiasclinias.plataforma.factory.AlertFactory;
import com.historiasclinias.plataforma.model.Interaction;
import com.historiasclinias.plataforma.model.Prescription;
import org.springframework.stereotype.Service;

import jakarta.annotation.PostConstruct;
import java.util.Map;
import java.util.Optional;

@Service
public class AlertEngine {

    private final Map<String, AlertFactory> factories;

    // Spring inyectará todas las AlertFactory registradas (beanName -> bean)
    public AlertEngine(Map<String, AlertFactory> factories) {
        this.factories = factories;
    }

    @PostConstruct
    public void init() {
        System.out.println("-----AlertEngine instanciado UNA SOLA VEZ------");
        System.out.println("Fábricas registradas: " + factories.keySet());
    }

    /**
     * Variante por defecto: usa la fábrica clínica
     */
    public Optional<Interaction> checkAndPersistInteraction(Prescription p) {
        return checkAndPersistInteraction(p, "clinicalAlertFactory");
    }

    /**
     * Variante que permite elegir la fábrica (ej: "iotAlertFactory")
     */
    public Optional<Interaction> checkAndPersistInteraction(Prescription p, String factoryBeanName) {
        AlertFactory factory = factories.get(factoryBeanName);
        if (factory == null) {
            // fallback: tomar la primera fábrica disponible para no fallar
            if (!factories.isEmpty()) {
                factory = factories.values().iterator().next();
            } else {
                return Optional.empty();
            }
        }

        Optional<Interaction> maybe = factory.getAlertCreator().createAndPersist(p);
        maybe.ifPresent(factory.getAlertNotifier()::notify);
        return maybe;
    }
}