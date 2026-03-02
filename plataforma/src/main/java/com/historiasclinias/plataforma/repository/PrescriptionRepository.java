package com.historiasclinias.plataforma.repository;

import com.historiasclinias.plataforma.model.Prescription;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;
public interface PrescriptionRepository extends JpaRepository<Prescription, UUID> { }