package com.historiasclinias.plataforma.composite;

import java.util.ArrayList;
import java.util.List;

public class ClinicalRecord implements ClinicalComponent {

    private final String patientName;
    private final List<ClinicalComponent> items = new ArrayList<>();

    public ClinicalRecord(String patientName) {
        this.patientName = patientName;
    }

    public void add(ClinicalComponent item) {
        items.add(item);
    }

    public void remove(ClinicalComponent item) {
        items.remove(item);
    }

    @Override
    public String showDetails() {
        StringBuilder sb = new StringBuilder();
        sb.append("Historia clínica de: ").append(patientName).append("\n");
        sb.append("--------------------------------\n");

        for (ClinicalComponent item : items) {
            sb.append(item.showDetails());
        }

        return sb.toString();
    }
}