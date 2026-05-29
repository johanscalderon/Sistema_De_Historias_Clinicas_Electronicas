package com.historiasclinias.plataforma.composite;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "clinical_records")
public class ClinicalRecord implements ClinicalComponent {

    @Id
    @Column(columnDefinition = "BINARY(16)")
    private UUID id = UUID.randomUUID();

    private UUID patientId;

    private String patientName;

    @Lob
    @Column(length = 4000)
    private String diagnoses;

    @Lob
    @Column(length = 4000)
    private String treatments;

    @Column(name = "status")
    private String status = "DRAFT";

    private LocalDateTime createdAt = LocalDateTime.now();

    public ClinicalRecord() {
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public UUID getPatientId() {
        return patientId;
    }

    public void setPatientId(UUID patientId) {
        this.patientId = patientId;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public String getDiagnoses() {
        return diagnoses;
    }

    public void setDiagnoses(String diagnoses) {
        this.diagnoses = diagnoses;
    }

    public String getTreatments() {
        return treatments;
    }

    public void setTreatments(String treatments) {
        this.treatments = treatments;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    @Transient
    public String getDetails() {
        StringBuilder sb = new StringBuilder();

        sb.append("Historia clínica de: ")
          .append(patientName)
          .append("\n\n");

        sb.append("Estado: ")
          .append(status)
          .append("\n\n");

        sb.append("Diagnósticos:\n")
          .append(diagnoses)
          .append("\n\n");

        sb.append("Tratamientos:\n")
          .append(treatments);

        return sb.toString();
    }

    @Override
    public String showDetails() {
        return getDetails();
    }
}