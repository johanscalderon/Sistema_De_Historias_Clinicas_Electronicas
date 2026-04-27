package com.historiasclinias.plataforma.proxy;

import java.util.UUID;

import org.springframework.stereotype.Service;

import com.historiasclinias.plataforma.model.Patient;
import com.historiasclinias.plataforma.repository.PatientRepository;

@Service
public class RealPatientService implements PatientAccess {

    private final PatientRepository repo;

    public RealPatientService(PatientRepository repo) {
        this.repo = repo;
    }

    @Override
    public Patient getPatient(UUID id, String role) {
        return repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Patient not found"));
    }
}