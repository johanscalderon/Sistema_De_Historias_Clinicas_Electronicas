package com.historiasclinias.plataforma.behavioral.strategy;

import com.historiasclinias.plataforma.model.Prescription;
import org.springframework.stereotype.Component;

import java.time.temporal.ChronoUnit;

@Component
public class LongTreatmentStrategy implements PrescriptionRiskStrategy {

    @Override
    public boolean supports(Prescription prescription) {
        if (prescription.getStartDate() == null || prescription.getEndDate() == null) {
            return false;
        }
        return ChronoUnit.DAYS.between(prescription.getStartDate(), prescription.getEndDate()) > 60;
    }

    @Override
    public PrescriptionRiskResult analyze(Prescription prescription) {
        return new PrescriptionRiskResult(
                "MEDIO",
                "Tratamiento prolongado; se recomienda control clinico y revision de adherencia."
        );
    }
}
