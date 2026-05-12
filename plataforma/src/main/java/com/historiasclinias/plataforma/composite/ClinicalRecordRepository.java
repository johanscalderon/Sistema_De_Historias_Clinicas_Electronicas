package com.historiasclinias.plataforma.composite;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface ClinicalRecordRepository extends JpaRepository<ClinicalRecord, UUID> {
    List<ClinicalRecord> findByPatientIdOrderByCreatedAtDesc(UUID patientId);
    List<ClinicalRecord> findAllByOrderByCreatedAtDesc();
}