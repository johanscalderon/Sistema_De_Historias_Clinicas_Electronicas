package com.historiasclinias.plataforma.flyweight;

import com.historiasclinias.plataforma.model.Prescription;

public interface MedicationFlyweight {
    void applyTo(Prescription prescription);
    String getCode();
    String getName();
    String getCategory();
}