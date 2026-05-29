package com.historiasclinias.plataforma.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "clinical_audit_events")
public class ClinicalAuditEvent {

    @Id
    @Column(columnDefinition = "BINARY(16)")
    private UUID id = UUID.randomUUID();

    private String eventType;
    private String entityType;
    private String entityId;

    @Column(length = 2000)
    private String description;

    private LocalDateTime occurredAt = LocalDateTime.now();

    public ClinicalAuditEvent() {
    }

    public ClinicalAuditEvent(String eventType, String entityType, String entityId, String description) {
        this.eventType = eventType;
        this.entityType = entityType;
        this.entityId = entityId;
        this.description = description;
    }

    public UUID getId() { return id; }
    public void setId(UUID id) { this.id = id; }
    public String getEventType() { return eventType; }
    public void setEventType(String eventType) { this.eventType = eventType; }
    public String getEntityType() { return entityType; }
    public void setEntityType(String entityType) { this.entityType = entityType; }
    public String getEntityId() { return entityId; }
    public void setEntityId(String entityId) { this.entityId = entityId; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    public LocalDateTime getOccurredAt() { return occurredAt; }
    public void setOccurredAt(LocalDateTime occurredAt) { this.occurredAt = occurredAt; }
}
