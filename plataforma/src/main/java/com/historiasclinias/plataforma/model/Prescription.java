package com.historiasclinias.plataforma.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "prescriptions")
public class Prescription implements Prototype<Prescription> {

    @Id
    @Column(columnDefinition = "BINARY(16)")
    private UUID id = UUID.randomUUID();
    private String medicationName;
    private String medicationCode;
    private String dose;
    private String frequency;
    private LocalDate startDate;
    private LocalDate endDate;
    private String createdBy;

    @jakarta.persistence.ManyToOne
    private Patient patient;

    public Prescription() {
    }

    @Override
    public Prescription copy() {
        Prescription copy = new Prescription();
        copy.setPatient(this.patient);
        copy.setMedicationName(this.medicationName);
        copy.setMedicationCode(this.medicationCode);
        copy.setDose(this.dose);
        copy.setFrequency(this.frequency);
        copy.setStartDate(this.startDate);
        copy.setEndDate(this.endDate);
        copy.setCreatedBy(this.createdBy);
        return copy;
    }

    public UUID getId() { return id; }
    public void setId(UUID id) { this.id = id; }

    public String getMedicationName() { return medicationName; }
    public void setMedicationName(String medicationName) { this.medicationName = medicationName; }

    public String getMedicationCode() { return medicationCode; }
    public void setMedicationCode(String medicationCode) { this.medicationCode = medicationCode; }

    public String getDose() { return dose; }
    public void setDose(String dose) { this.dose = dose; }

    public String getFrequency() { return frequency; }
    public void setFrequency(String frequency) { this.frequency = frequency; }

    public LocalDate getStartDate() { return startDate; }
    public void setStartDate(LocalDate startDate) { this.startDate = startDate; }

    public LocalDate getEndDate() { return endDate; }
    public void setEndDate(LocalDate endDate) { this.endDate = endDate; }

    public String getCreatedBy() { return createdBy; }
    public void setCreatedBy(String createdBy) { this.createdBy = createdBy; }

    public Patient getPatient() { return patient; }
    public void setPatient(Patient patient) { this.patient = patient; }
}