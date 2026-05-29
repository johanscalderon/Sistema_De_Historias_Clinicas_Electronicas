package com.historiasclinias.plataforma.behavioral.strategy;

import com.historiasclinias.plataforma.model.Prescription;
import org.springframework.stereotype.Component;

@Component
public class DefaultPrescriptionRiskStrategy implements PrescriptionRiskStrategy {

    @Override
    public boolean supports(Prescription prescription) {
        return true;
    }

    @Override
    public PrescriptionRiskResult analyze(Prescription prescription) {
        return new PrescriptionRiskResult("BAJO", "No se detectaron condiciones especiales de riesgo.");
    }
}
