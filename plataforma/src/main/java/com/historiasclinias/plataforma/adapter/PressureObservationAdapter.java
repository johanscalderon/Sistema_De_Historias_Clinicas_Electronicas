package com.historiasclinias.plataforma.adapter;

import com.historiasclinias.plataforma.model.Observation;
import com.historiasclinias.plataforma.model.Patient;

import java.time.ZonedDateTime;

public class PressureObservationAdapter implements ObservationAdapter {

    private final PressureDevicePayload payload;

    public PressureObservationAdapter(PressureDevicePayload payload) {
        this.payload = payload;
    }

    @Override
    public Observation adapt() {
        Observation observation = new Observation();
        observation.setDeviceId(payload.getDeviceId());
        observation.setMetric("systolic");
        observation.setValue(payload.getSystolic() != null ? payload.getSystolic().doubleValue() : null);
        observation.setUnit("mmHg");
        observation.setRecordedAt(ZonedDateTime.parse(payload.getRecordedAt()));

        Patient patient = new Patient();
        patient.setId(payload.getPatientId());
        observation.setPatient(patient);

        return observation;
    }
}