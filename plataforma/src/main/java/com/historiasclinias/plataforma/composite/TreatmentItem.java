package com.historiasclinias.plataforma.composite;

public class TreatmentItem implements ClinicalComponent {

    private final String treatmentName;
    private final String description;

    public TreatmentItem(String treatmentName, String description) {
        this.treatmentName = treatmentName;
        this.description = description;
    }

    @Override
    public String showDetails() {
        return "- Tratamiento: " + treatmentName + " | " + description + "\n";
    }
}