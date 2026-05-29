package com.historiasclinias.plataforma.behavioral.chain;

import com.historiasclinias.plataforma.composite.ClinicalHistoryRequest;

public class TreatmentRequiredHandler extends HistoryValidationHandler {

    @Override
    protected void check(ClinicalHistoryRequest request) {
        if (request.getTreatments() == null || request.getTreatments().isBlank()) {
            throw new IllegalArgumentException("La historia clinica debe incluir al menos un tratamiento.");
        }
    }
}
