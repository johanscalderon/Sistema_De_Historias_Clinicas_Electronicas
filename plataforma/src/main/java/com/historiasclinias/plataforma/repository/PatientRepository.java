package com.historiasclinias.plataforma.repository;

import com.historiasclinias.plataforma.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PatientRepository extends JpaRepository<Patient, UUID> { }
