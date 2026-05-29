package com.historiasclinias.plataforma.repository;

import com.historiasclinias.plataforma.model.PrescriptionMemento;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface PrescriptionMementoRepository extends JpaRepository<PrescriptionMemento, UUID> {
    List<PrescriptionMemento> findByPrescriptionIdOrderBySavedAtDesc(UUID prescriptionId);
}
