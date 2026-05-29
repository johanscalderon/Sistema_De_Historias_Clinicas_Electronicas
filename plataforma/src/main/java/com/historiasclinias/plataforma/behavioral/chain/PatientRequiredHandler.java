package com.historiasclinias.plataforma.behavioral.chain;

import com.historiasclinias.plataforma.composite.ClinicalHistoryRequest;

public class PatientRequiredHandler extends HistoryValidationHandler {

    @Override
    protected void check(ClinicalHistoryRequest request) {
        if (request.getPatientId() == null) {
            throw new IllegalArgumentException("La historia clinica debe tener un paciente.");
        }
    }
}
