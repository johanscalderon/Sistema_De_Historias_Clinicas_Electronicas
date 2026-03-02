package com.historiasclinias.plataforma.service;

import com.historiasclinias.plataforma.iot.DeviceHandler;
import com.historiasclinias.plataforma.iot.DeviceHandlerFactory;
import com.historiasclinias.plataforma.model.Observation;
import com.historiasclinias.plataforma.repository.ObservationRepository;
import org.springframework.stereotype.Service;

@Service
public class IoTService {
    private final ObservationRepository repo;

    public IoTService(ObservationRepository repo) { this.repo = repo; }

    public Observation processObservation(String deviceType, Observation obs) {
        DeviceHandler handler = DeviceHandlerFactory.create(deviceType);
        return handler.handle(obs, repo);
    }
}