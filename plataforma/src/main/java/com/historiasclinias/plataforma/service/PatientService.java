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
    public List<Patient> findAll() { return repo.findAll(); }
    public Patient findById(UUID id) { return repo.findById(id).orElse(null); }
}
