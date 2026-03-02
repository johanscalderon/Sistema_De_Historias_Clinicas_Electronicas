package com.historiasclinias.plataforma.iot;

import com.historiasclinias.plataforma.model.Observation;
import com.historiasclinias.plataforma.repository.ObservationRepository;

public interface DeviceHandler {
    /**
     * Procesa la observación: validar, transformar y persistir.
     */
    Observation handle(Observation obs, ObservationRepository repo);
}
