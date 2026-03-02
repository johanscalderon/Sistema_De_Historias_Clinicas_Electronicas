package com.historiasclinias.plataforma.model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.time.ZonedDateTime;
import java.util.UUID;

@Entity
@Table(name = "appointments")
public class Appointment {
    @Id
    @Column(columnDefinition = "BINARY(16)")
    private UUID id = UUID.randomUUID();

    @ManyToOne
    @JoinColumn(name = "patient_id")
    private Patient patient;

    private ZonedDateTime startAt;
    private ZonedDateTime endAt;
    private String status; // scheduled, cancelled, done

    // getters/setters
    public UUID getId() { return id; }
    public void setId(UUID id) { this.id = id; }
    public Patient getPatient() { return patient; }
    public void setPatient(Patient patient) { this.patient = patient; }
    public ZonedDateTime getStartAt() { return startAt; }
    public void setStartAt(ZonedDateTime startAt) { this.startAt = startAt; }
    public ZonedDateTime getEndAt() { return endAt; }
    public void setEndAt(ZonedDateTime endAt) { this.endAt = endAt; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}