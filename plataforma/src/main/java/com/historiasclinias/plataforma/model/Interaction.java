package com.historiasclinias.plataforma.model;

import java.time.ZonedDateTime;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "interactions")
public class Interaction {
    @Id
    @Column(columnDefinition = "BINARY(16)")
    private UUID id = UUID.randomUUID();

    @ManyToOne
    @JoinColumn(name = "prescription_id")
    private Prescription prescription;

    private String severity; // low, moderate, high
    @Column(length = 2000)
    private String description;
    private String ruleId;
    private ZonedDateTime detectedAt = ZonedDateTime.now();

    // getters/setters
    public UUID getId() { return id; }
    public void setId(UUID id) { this.id = id; }
    public Prescription getPrescription() { return prescription; }
    public void setPrescription(Prescription prescription) { this.prescription = prescription; }
    public String getSeverity() { return severity; }
    public void setSeverity(String severity) { this.severity = severity; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    public String getRuleId() { return ruleId; }
    public void setRuleId(String ruleId) { this.ruleId = ruleId; }
    public ZonedDateTime getDetectedAt() { return detectedAt; }
    public void setDetectedAt(ZonedDateTime detectedAt) { this.detectedAt = detectedAt; }
}
