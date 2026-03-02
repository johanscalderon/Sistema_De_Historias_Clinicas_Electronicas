package com.historiasclinias.plataforma.iot;

import com.historiasclinias.plataforma.model.Observation;
import com.historiasclinias.plataforma.repository.ObservationRepository;

public class HeartRateDeviceHandler implements DeviceHandler {

    @Override
    public Observation handle(Observation obs, ObservationRepository repo) {
        // validación mínima
        if (obs.getMetric() == null) {
            obs.setMetric("heart_rate");
        }
        if (obs.getUnit() == null) {
            obs.setUnit("bpm");
        }
        // persistir
        return repo.save(obs);
    }
}