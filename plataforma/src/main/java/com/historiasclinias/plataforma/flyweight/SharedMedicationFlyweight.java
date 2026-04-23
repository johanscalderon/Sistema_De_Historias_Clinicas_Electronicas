package com.historiasclinias.plataforma.flyweight;

import com.historiasclinias.plataforma.model.Prescription;

public class SharedMedicationFlyweight implements MedicationFlyweight {

    private final String code;
    private final String name;
    private final String category;

    public SharedMedicationFlyweight(String code, String name, String category) {
        this.code = code;
        this.name = name;
        this.category = category;
    }

    @Override
    public void applyTo(Prescription prescription) {
        prescription.setMedicationCode(code);
        prescription.setMedicationName(name);
    }

    @Override
    public String getCode() {
        return code;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getCategory() {
        return category;
    }
}