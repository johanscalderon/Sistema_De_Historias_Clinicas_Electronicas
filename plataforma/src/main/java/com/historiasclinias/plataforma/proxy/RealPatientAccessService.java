package com.historiasclinias.plataforma.proxy;

import com.historiasclinias.plataforma.model.Patient;
import com.historiasclinias.plataforma.repository.PatientRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class RealPatientAccessService implements PatientAccessService {

    private final PatientRepository patientRepository;

    public RealPatientAccessService(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    @Override
    public Patient getPatientById(UUID id, String role) {
        return patientRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Patient not found"));
    }
}