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
@Table(name = "observations")
public class Observation {
    @Id
    @Column(columnDefinition = "BINARY(16)")
    private UUID id = UUID.randomUUID();

    private String deviceId; //Identificador del dispositivo

    @ManyToOne
    @JoinColumn(name = "patient_id")
    private Patient patient; //Paciente

    private String metric; // Lo que se esa midiendo
    private Double value; //valor medido
    private String unit; //unidad (latidos por minuto)
    private ZonedDateTime recordedAt; //fecha del dato

    // getters/setters
    public UUID getId() { return id; }
    public void setId(UUID id) { this.id = id; }
    public String getDeviceId() { return deviceId; }
    public void setDeviceId(String deviceId) { this.deviceId = deviceId; }
    public Patient getPatient() { return patient; }
    public void setPatient(Patient patient) { this.patient = patient; }
    public String getMetric() { return metric; }
    public void setMetric(String metric) { this.metric = metric; }
    public Double getValue() { return value; }
    public void setValue(Double value) { this.value = value; }
    public String getUnit() { return unit; }
    public void setUnit(String unit) { this.unit = unit; }
    public ZonedDateTime getRecordedAt() { return recordedAt; }
    public void setRecordedAt(ZonedDateTime recordedAt) { this.recordedAt = recordedAt; }
}