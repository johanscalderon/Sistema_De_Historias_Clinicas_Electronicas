package com.historiasclinias.plataforma.composite;

public class DiagnosisItem implements ClinicalComponent {

    private final String diagnosisName;
    private final String description;

    public DiagnosisItem(String diagnosisName, String description) {
        this.diagnosisName = diagnosisName;
        this.description = description;
    }

    @Override
    public String showDetails() {
        return "- Diagnóstico: " + diagnosisName + " | " + description + "\n";
    }
}