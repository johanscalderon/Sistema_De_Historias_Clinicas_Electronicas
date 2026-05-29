package com.historiasclinias.plataforma.behavioral.observer;

public class ClinicalEvent {
    private final String eventType;
    private final String entityType;
    private final String entityId;
    private final String description;

    public ClinicalEvent(String eventType, String entityType, String entityId, String description) {
        this.eventType = eventType;
        this.entityType = entityType;
        this.entityId = entityId;
        this.description = description;
    }

    public String getEventType() { return eventType; }
    public String getEntityType() { return entityType; }
    public String getEntityId() { return entityId; }
    public String getDescription() { return description; }
}
