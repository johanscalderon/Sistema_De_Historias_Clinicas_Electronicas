package com.historiasclinias.plataforma.facade;

import java.time.LocalDate;
import java.util.UUID;

public class CreatePrescriptionRequest {
    private UUID patientId;
    private String medicationName;
    private String medicationCode;
    private String dose;
    private String frequency;
    private LocalDate startDate;
    private LocalDate endDate;
    private String createdBy;

    public UUID getPatientId() { return patientId; }
    public void setPatientId(UUID patientId) { this.patientId = patientId; }

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
}