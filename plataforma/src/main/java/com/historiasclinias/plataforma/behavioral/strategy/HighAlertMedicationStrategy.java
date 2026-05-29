package com.historiasclinias.plataforma.behavioral.strategy;

import com.historiasclinias.plataforma.model.Prescription;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
public class HighAlertMedicationStrategy implements PrescriptionRiskStrategy {

    private static final Set<String> HIGH_ALERT_WORDS = Set.of("insulina", "warfarina", "heparina", "morfina");

    @Override
    public boolean supports(Prescription prescription) {
        String medication = safe(prescription.getMedicationName()).toLowerCase();
        return HIGH_ALERT_WORDS.stream().anyMatch(medication::contains);
    }

    @Override
    public PrescriptionRiskResult analyze(Prescription prescription) {
        return new PrescriptionRiskResult(
                "ALTO",
                "Medicamento de alto riesgo; requiere doble verificacion y seguimiento cercano."
        );
    }

    private String safe(String value) {
        return value == null ? "" : value;
    }
}
