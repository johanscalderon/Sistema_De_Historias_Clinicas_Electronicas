package com.historiasclinias.plataforma.factory;

import com.historiasclinias.plataforma.model.Interaction;
import com.historiasclinias.plataforma.model.Prescription;
import com.historiasclinias.plataforma.repository.InteractionRepository;
import org.springframework.stereotype.Component;

import java.time.ZonedDateTime;
import java.util.Optional;

/**
 * Crea y persiste una Interaction en la tabla interactions (clínico).
 */
@Component
public class ClinicalAlertCreator implements AlertCreator {

    private final InteractionRepository interactionRepository;

    public ClinicalAlertCreator(InteractionRepository interactionRepository) {
        this.interactionRepository = interactionRepository;
    }

    @Override
    public Optional<Interaction> createAndPersist(Prescription p) {
        // Lógica de ejemplo: si tiene 'aspirin' o 'x' crea Interaction (puedes reutilizar la lógica previa)
        if (p.getMedicationName() != null && p.getMedicationName().toLowerCase().contains("aspirin")) {
            Interaction it = new Interaction();
            it.setPrescription(p);
            it.setSeverity("moderate");
            it.setDescription("Posible interacción con aspirina (factory clínico).");
            it.setRuleId("rule_factory_clinical_aspirin");
            it.setDetectedAt(ZonedDateTime.now());
            return Optional.of(interactionRepository.save(it));
        }

        if (p.getMedicationName() != null && p.getMedicationName().toLowerCase().contains("x")) {
            Interaction it = new Interaction();
            it.setPrescription(p);
            it.setSeverity("high");
            it.setDescription("Interacción crítica detectada (factory clínico, 'x' en nombre).");
            it.setRuleId("rule_factory_clinical_x");
            it.setDetectedAt(ZonedDateTime.now());
            return Optional.of(interactionRepository.save(it));
        }

        return Optional.empty();
    }
}