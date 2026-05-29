package com.historiasclinias.plataforma.behavioral.observer;

import com.historiasclinias.plataforma.model.ClinicalAuditEvent;
import com.historiasclinias.plataforma.repository.ClinicalAuditEventRepository;
import org.springframework.stereotype.Component;

@Component
public class AuditTrailObserver implements ClinicalEventObserver {

    private final ClinicalAuditEventRepository repository;

    public AuditTrailObserver(ClinicalAuditEventRepository repository) {
        this.repository = repository;
    }

    @Override
    public void onClinicalEvent(ClinicalEvent event) {
        repository.save(new ClinicalAuditEvent(
                event.getEventType(),
                event.getEntityType(),
                event.getEntityId(),
                event.getDescription()
        ));
    }
}
