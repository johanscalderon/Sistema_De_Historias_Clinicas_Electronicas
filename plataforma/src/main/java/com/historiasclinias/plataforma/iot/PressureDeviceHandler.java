package com.historiasclinias.plataforma.iot;

import com.historiasclinias.plataforma.model.Observation;
import com.historiasclinias.plataforma.repository.ObservationRepository;

public class PressureDeviceHandler implements DeviceHandler {

    private static final double SYSTOLIC_THRESHOLD = 140.0;

    @Override
    public Observation handle(Observation obs, ObservationRepository repo) {
        // Normalización mínima
        String metric = obs.getMetric();
        if (metric == null) {
            obs.setMetric("blood_pressure");
        }
        if (obs.getUnit() == null) {
            obs.setUnit("mmHg");
        }

        Observation saved = repo.save(obs);

        // Determinar valor de referencia: asumimos que 'value' es sistólica si metric contiene "sys" o "blood"
        Double val = obs.getValue();
        if (val != null) {
            boolean isSystolic = metric != null &&
                    (metric.toLowerCase().contains("systolic") || metric.toLowerCase().contains("sys") || metric.toLowerCase().contains("blood"));
            if (isSystolic && val > SYSTOLIC_THRESHOLD) {
                System.out.println("ALERTA IoT (PressureDeviceHandler): presión sistólica alta detectada: "
                        + val + " " + obs.getUnit() + " (patient=" + (obs.getPatient() != null ? obs.getPatient().getId() : "unknown") + ")");
            }
        }

        return saved;
    }
}
