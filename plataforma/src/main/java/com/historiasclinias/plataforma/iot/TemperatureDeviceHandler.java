package com.historiasclinias.plataforma.iot;

import com.historiasclinias.plataforma.model.Observation;
import com.historiasclinias.plataforma.repository.ObservationRepository;

public class TemperatureDeviceHandler implements DeviceHandler {

    private static final double FEVER_THRESHOLD = 38.0;

    @Override
    public Observation handle(Observation obs, ObservationRepository repo) {
        if (obs.getMetric() == null) {
            obs.setMetric("temperature");
        }
        if (obs.getUnit() == null) {
            obs.setUnit("°C");
        }

        // Normalizar: si vienen en Kelvin o Fahrenheit deberías convertir aquí (no implementado)
        Observation saved = repo.save(obs);

        // Regla simple de ejemplo
        if (obs.getValue() != null && obs.getValue() > FEVER_THRESHOLD) {
            // Para demo: log en consola. En producción -> persistir alerta / notificar
            System.out.println("ALERTA IoT (TemperatureDeviceHandler): posible fiebre detectada. value="
                    + obs.getValue() + " " + obs.getUnit() + " (patient=" + (obs.getPatient() != null ? obs.getPatient().getId() : "unknown") + ")");
        }

        return saved;
    }
}
