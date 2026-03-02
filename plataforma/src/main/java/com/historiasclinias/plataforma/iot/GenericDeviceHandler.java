package com.historiasclinias.plataforma.iot;

import com.historiasclinias.plataforma.model.Observation;
import com.historiasclinias.plataforma.repository.ObservationRepository;

public class GenericDeviceHandler implements DeviceHandler {

    @Override
    public Observation handle(Observation obs, ObservationRepository repo) {
        // persistir sin transformaciones complejas
        return repo.save(obs);
    }
}
