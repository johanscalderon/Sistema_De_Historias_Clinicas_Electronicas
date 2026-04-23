package com.historiasclinias.plataforma.service;

import com.historiasclinias.plataforma.flyweight.FlyweightPrescriptionRequest;
import com.historiasclinias.plataforma.flyweight.MedicationFlyweight;
import com.historiasclinias.plataforma.flyweight.MedicationFlyweightFactory;
import com.historiasclinias.plataforma.model.Interaction;
import com.historiasclinias.plataforma.model.Patient;
import com.historiasclinias.plataforma.model.Prescription;
import com.historiasclinias.plataforma.model.PrescriptionBuilder;
import com.historiasclinias.plataforma.pattern.AlertEngine;
import com.historiasclinias.plataforma.repository.PatientRepository;
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
    private final PatientRepository patientRepository;
    private final MedicationFlyweightFactory medicationFlyweightFactory;

    public PrescriptionService(PrescriptionRepository repo,
                               AlertEngine alertEngine,
                               PatientRepository patientRepository,
                               MedicationFlyweightFactory medicationFlyweightFactory) {
        this.repo = repo;
        this.alertEngine = alertEngine;
        this.patientRepository = patientRepository;
        this.medicationFlyweightFactory = medicationFlyweightFactory;
    }

    public Prescription save(Prescription p) {
        Prescription saved = repo.save(p);
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
        cloned.setStartDate(LocalDate.now());

        return save(cloned);
    }

    public Prescription createFromFlyweight(FlyweightPrescriptionRequest request) {
        Patient patient = patientRepository.findById(request.getPatientId())
                .orElseThrow(() -> new RuntimeException("Patient not found"));

        MedicationFlyweight medication = medicationFlyweightFactory.getMedication(request.getMedicationCode());

        Prescription prescription = new Prescription();
        prescription.setPatient(patient);
        medication.applyTo(prescription);

        prescription.setDose(request.getDose());
        prescription.setFrequency(request.getFrequency());
        prescription.setStartDate(request.getStartDate());
        prescription.setEndDate(request.getEndDate());
        prescription.setCreatedBy(request.getCreatedBy());

        return save(prescription);
    }

    public List<Prescription> findAll() {
        return repo.findAll();
    }

    public Prescription findById(UUID id) {
        return repo.findById(id).orElse(null);
    }
}