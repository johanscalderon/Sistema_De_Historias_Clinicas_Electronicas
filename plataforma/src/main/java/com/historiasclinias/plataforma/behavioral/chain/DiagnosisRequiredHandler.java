package com.historiasclinias.plataforma.behavioral.chain;

import com.historiasclinias.plataforma.composite.ClinicalHistoryRequest;

public class DiagnosisRequiredHandler extends HistoryValidationHandler {

    @Override
    protected void check(ClinicalHistoryRequest request) {
        if (request.getDiagnoses() == null || request.getDiagnoses().isBlank()) {
            throw new IllegalArgumentException("La historia clinica debe incluir un diagnostico.");
        }
    }
}
