package com.historiasclinias.plataforma.adapter;

import com.historiasclinias.plataforma.model.Observation;
import com.historiasclinias.plataforma.model.Patient;

import java.time.ZonedDateTime;

public class HeartRateObservationAdapter implements ObservationAdapter {

    private final HeartRateDevicePayload payload;

    public HeartRateObservationAdapter(HeartRateDevicePayload payload) {
        this.payload = payload;
    }

    @Override
    public Observation adapt() {
        Observation observation = new Observation();
        observation.setDeviceId(payload.getDeviceId());
        observation.setMetric("heart_rate");
        observation.setValue(payload.getBpm() != null ? payload.getBpm().doubleValue() : null);
        observation.setUnit("bpm");
        observation.setRecordedAt(ZonedDateTime.parse(payload.getRecordedAt()));

        Patient patient = new Patient();
        patient.setId(payload.getPatientId());
        observation.setPatient(patient);

        return observation;
    }
}