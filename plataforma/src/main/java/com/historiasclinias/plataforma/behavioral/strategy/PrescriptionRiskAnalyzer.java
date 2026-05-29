package com.historiasclinias.plataforma.behavioral.strategy;

import com.historiasclinias.plataforma.model.Prescription;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PrescriptionRiskAnalyzer {

    private final List<PrescriptionRiskStrategy> strategies;

    public PrescriptionRiskAnalyzer(List<PrescriptionRiskStrategy> strategies) {
        this.strategies = strategies;
    }

    public PrescriptionRiskResult analyze(Prescription prescription) {
        return strategies.stream()
                .filter(strategy -> !(strategy instanceof DefaultPrescriptionRiskStrategy))
                .filter(strategy -> strategy.supports(prescription))
                .findFirst()
                .orElseGet(() -> strategies.stream()
                        .filter(DefaultPrescriptionRiskStrategy.class::isInstance)
                        .findFirst()
                        .orElseThrow())
                .analyze(prescription);
    }
}
