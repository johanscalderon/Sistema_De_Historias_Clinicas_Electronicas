package com.historiasclinias.plataforma.adapter;

import com.historiasclinias.plataforma.model.Observation;
import com.historiasclinias.plataforma.model.Patient;

import java.time.ZonedDateTime;

public class TemperatureObservationAdapter implements ObservationAdapter {

    private final TemperatureDevicePayload payload;

    public TemperatureObservationAdapter(TemperatureDevicePayload payload) {
        this.payload = payload;
    }

    @Override
    public Observation adapt() {
        Observation observation = new Observation();
        observation.setDeviceId(payload.getDeviceId());
        observation.setMetric("temperature");
        observation.setValue(payload.getTemp());
        observation.setUnit("°C");
        observation.setRecordedAt(ZonedDateTime.parse(payload.getRecordedAt()));

        Patient patient = new Patient();
        patient.setId(payload.getPatientId());
        observation.setPatient(patient);

        return observation;
    }
}