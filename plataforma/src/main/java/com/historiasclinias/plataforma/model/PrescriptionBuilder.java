package com.historiasclinias.plataforma.model;

import java.time.LocalDate;
import java.util.UUID;

/**
 * Builder para Prescription.
 * Construye la entidad paso a paso con métodos fluent.
 */
public class PrescriptionBuilder {

    private final Prescription prescription;

    public PrescriptionBuilder() {
        this.prescription = new Prescription();
        // asignar defaults si se desea
    }

    public PrescriptionBuilder withId(UUID id) {
        this.prescription.setId(id);
        return this;
    }

    public PrescriptionBuilder withPatient(Patient patient) {
        this.prescription.setPatient(patient);
        return this;
    }

    public PrescriptionBuilder withMedicationName(String medicationName) {
        this.prescription.setMedicationName(medicationName);
        return this;
    }

    public PrescriptionBuilder withMedicationCode(String medicationCode) {
        this.prescription.setMedicationCode(medicationCode);
        return this;
    }

    public PrescriptionBuilder withDose(String dose) {
        this.prescription.setDose(dose);
        return this;
    }

    public PrescriptionBuilder withFrequency(String frequency) {
        this.prescription.setFrequency(frequency);
        return this;
    }

    public PrescriptionBuilder withStartDate(LocalDate startDate) {
        this.prescription.setStartDate(startDate);
        return this;
    }

    public PrescriptionBuilder withEndDate(LocalDate endDate) {
        this.prescription.setEndDate(endDate);
        return this;
    }

    public PrescriptionBuilder withCreatedBy(String createdBy) {
        this.prescription.setCreatedBy(createdBy);
        return this;
    }

    // Añadir más métodos conXxx(...) según campos de tu entidad

    public Prescription build() {
        // Validaciones básicas opcionales
        if (prescription.getStartDate() == null) {
            prescription.setStartDate(LocalDate.now());
        }
        // más checks si hace falta
        return prescription;
    }
}