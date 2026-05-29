package com.historiasclinias.plataforma.behavioral.strategy;

import com.historiasclinias.plataforma.model.Prescription;

public interface PrescriptionRiskStrategy {
    boolean supports(Prescription prescription);
    PrescriptionRiskResult analyze(Prescription prescription);
}
