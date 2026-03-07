package com.historiasclinias.plataforma.factory;

import com.historiasclinias.plataforma.model.Interaction;
import com.historiasclinias.plataforma.model.Prescription;
import com.historiasclinias.plataforma.repository.InteractionRepository;
import org.springframework.stereotype.Component;

import java.time.ZonedDateTime;
import java.util.Optional;

/**
 * Creador de alertas para eventos IoT.
 * (Aquí usamos la misma entidad Interaction para simplicidad; en un proyecto real podría ser otra tabla).
 */
@Component
public class IoTAlertCreator implements AlertCreator {

    private final InteractionRepository interactionRepository;

    public IoTAlertCreator(InteractionRepository interactionRepository) {
        this.interactionRepository = interactionRepository;
    }

    @Override
    public Optional<Interaction> createAndPersist(Prescription p) {
        // Regla de ejemplo alternativa (ej.: si el nombre contiene "sensor" lo tratamos como IoT)
        if (p.getMedicationName() != null && p.getMedicationName().toLowerCase().contains("sensor")) {
            Interaction it = new Interaction();
            it.setPrescription(p);
            it.setSeverity("low");
            it.setDescription("Alerta IoT: regla de ejemplo detectada en prescription (sensor).");
            it.setRuleId("rule_factory_iot_sensor");
            it.setDetectedAt(ZonedDateTime.now());
            return Optional.of(interactionRepository.save(it));
        }
        return Optional.empty();
    }
}