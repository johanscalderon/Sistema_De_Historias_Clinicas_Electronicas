package com.historiasclinias.plataforma.service;

import com.historiasclinias.plataforma.model.Interaction;
import com.historiasclinias.plataforma.model.Patient;
import com.historiasclinias.plataforma.model.Prescription;
import com.historiasclinias.plataforma.model.PrescriptionBuilder;
import com.historiasclinias.plataforma.pattern.AlertEngine;
import com.historiasclinias.plataforma.repository.PrescriptionRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class PrescriptionService {

    private final PrescriptionRepository repo;
    private final AlertEngine alertEngine;

    public PrescriptionService(PrescriptionRepository repo, AlertEngine alertEngine) {
        this.repo = repo;
        this.alertEngine = alertEngine;
    }

    public Prescription save(Prescription p) {
        Prescription saved = repo.save(p);

        // Delegamos completamente a AlertEngine + fabrica: creación y notificación
        Optional<Interaction> maybe = alertEngine.checkAndPersistInteraction(saved);

        return saved;
    }

    public Prescription createFromFields(Patient patient,
                                         String medicationName,
                                         String medicationCode,
                                         String dose,
                                         String frequency,
                                         LocalDate startDate,
                                         LocalDate endDate,
                                         String createdBy) {
        Prescription p = new PrescriptionBuilder()
                .withPatient(patient)
                .withMedicationName(medicationName)
                .withMedicationCode(medicationCode)
                .withDose(dose)
                .withFrequency(frequency)
                .withStartDate(startDate)
                .withEndDate(endDate)
                .withCreatedBy(createdBy)
                .build();

        return repo.save(p);
    }

    public Prescription clonePrescription(UUID prescriptionId) {
        Prescription original = repo.findById(prescriptionId)
                .orElseThrow(() -> new RuntimeException("Prescription not found"));

        Prescription cloned = original.copy();
        cloned.setStartDate(LocalDate.now()); // nueva fecha para la copia

        return save(cloned);
    }

    public List<Prescription> findAll() {
        return repo.findAll();
    }

    public Prescription findById(UUID id) {
        return repo.findById(id).orElse(null);
    }
}