package com.historiasclinias.plataforma.pattern;

import com.historiasclinias.plataforma.decorator.SeverityAlertNotifierDecorator;
import com.historiasclinias.plataforma.decorator.TimestampAlertNotifierDecorator;
import com.historiasclinias.plataforma.factory.AlertFactory;
import com.historiasclinias.plataforma.factory.AlertNotifier;
import com.historiasclinias.plataforma.model.Interaction;
import com.historiasclinias.plataforma.model.Prescription;
import org.springframework.stereotype.Service;

import jakarta.annotation.PostConstruct;
import java.util.Map;
import java.util.Optional;

@Service
public class AlertEngine {

    private final Map<String, AlertFactory> factories;

    public AlertEngine(Map<String, AlertFactory> factories) {
        this.factories = factories;
    }

    @PostConstruct
    public void init() {
        System.out.println("-----AlertEngine instanciado UNA SOLA VEZ------");
        System.out.println("Fábricas registradas: " + factories.keySet());
    }

    public Optional<Interaction> checkAndPersistInteraction(Prescription p) {
        return checkAndPersistInteraction(p, "clinicalAlertFactory");
    }

    public Optional<Interaction> checkAndPersistInteraction(Prescription p, String factoryBeanName) {
        AlertFactory factory = factories.get(factoryBeanName);
        if (factory == null) {
            if (!factories.isEmpty()) {
                factory = factories.values().iterator().next();
            } else {
                return Optional.empty();
            }
        }

        Optional<Interaction> maybe = factory.getAlertCreator().createAndPersist(p);

        if (maybe.isPresent()) {
            AlertNotifier decoratedNotifier = decorateNotifier(factory.getAlertNotifier());
            decoratedNotifier.notify(maybe.get());
        }

        return maybe;
    }

    private AlertNotifier decorateNotifier(AlertNotifier notifier) {
        return new SeverityAlertNotifierDecorator(
                new TimestampAlertNotifierDecorator(notifier)
        );
    }
}