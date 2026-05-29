package com.historiasclinias.plataforma.repository;

import com.historiasclinias.plataforma.model.ClinicalAuditEvent;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface ClinicalAuditEventRepository extends JpaRepository<ClinicalAuditEvent, UUID> {
    List<ClinicalAuditEvent> findTop30ByOrderByOccurredAtDesc();
}
