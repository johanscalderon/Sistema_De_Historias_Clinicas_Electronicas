package com.historiasclinias.plataforma.service;

import com.historiasclinias.plataforma.model.Patient;
import com.historiasclinias.plataforma.repository.PatientRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class PatientService {
    private final PatientRepository repo;

    public PatientService(PatientRepository repo) { this.repo = repo; }

    public Patient save(Patient p) { return repo.save(p); }

    public Patient update(UUID id, Patient data) {
        Patient patient = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Patient not found"));

        patient.setFirstName(data.getFirstName());
        patient.setLastName(data.getLastName());
        patient.setDni(data.getDni());
        patient.setBirthDate(data.getBirthDate());
        patient.setGender(data.getGender());

        return repo.save(patient);
    }

    public List<Patient> findAll() { return repo.findAll(); }
    public Patient findById(UUID id) { return repo.findById(id).orElse(null); }
}
