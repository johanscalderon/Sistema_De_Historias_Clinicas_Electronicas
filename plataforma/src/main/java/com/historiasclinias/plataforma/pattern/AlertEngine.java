package com.historiasclinias.plataforma.pattern;

import com.historiasclinias.plataforma.model.Interaction;
import com.historiasclinias.plataforma.model.Prescription;
import com.historiasclinias.plataforma.repository.InteractionRepository;

import jakarta.annotation.PostConstruct;

import org.springframework.stereotype.Service;

import java.time.ZonedDateTime;
import java.util.Optional;

@Service // Spring lo crea como singleton por defecto
public class AlertEngine {

    private final InteractionRepository interactionRepository;

    // Spring inyecta el repo en el constructor
    public AlertEngine(InteractionRepository interactionRepository) {
        this.interactionRepository = interactionRepository;
    }

    @PostConstruct
    public void init() {
        System.out.println("-----AlertEngine instanciado UNA SOLA VEZ------");
    }

    public Optional<Interaction> checkAndPersistInteraction(Prescription p) {
        if (p.getMedicationName() != null && p.getMedicationName().toLowerCase().contains("aspirin")) {
            Interaction it = new Interaction();
            it.setPrescription(p);
            it.setSeverity("moderate");
            it.setDescription("Posible interacción con aspirina detectada por regla simple.");
            it.setRuleId("rule_simple_aspirin_check");
            it.setDetectedAt(ZonedDateTime.now());
            Interaction saved = interactionRepository.save(it);
            return Optional.of(saved);
        }

        if (p.getMedicationName() != null && p.getMedicationName().toLowerCase().contains("x")) {
            Interaction it = new Interaction();
            it.setPrescription(p);
            it.setSeverity("high");
            it.setDescription("Interacción crítica detectada (nombre contiene 'x').");
            it.setRuleId("rule_name_contains_x");
            it.setDetectedAt(ZonedDateTime.now());
            Interaction saved = interactionRepository.save(it);
            return Optional.of(saved);
        }
        return Optional.empty();
    }
}