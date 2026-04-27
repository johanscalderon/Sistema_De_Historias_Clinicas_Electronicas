package com.historiasclinias.plataforma.facade;

import java.time.LocalDate;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.historiasclinias.plataforma.Controller.FacadePrescriptionRequest;
import com.historiasclinias.plataforma.model.Patient;
import com.historiasclinias.plataforma.model.Prescription;
import com.historiasclinias.plataforma.repository.PatientRepository;
import com.historiasclinias.plataforma.service.PrescriptionService;

@Service
public class PrescriptionFacade {

    private final PrescriptionService prescriptionService;
    private final PatientRepository patientRepository;

    public PrescriptionFacade(PrescriptionService prescriptionService,
                              PatientRepository patientRepository) {
        this.prescriptionService = prescriptionService;
        this.patientRepository = patientRepository;
    }

    public Prescription createSimplePrescription(FacadePrescriptionRequest req) {

        Patient patient = patientRepository.findById(UUID.fromString(req.getPatientId()))
                .orElseThrow(() -> new RuntimeException("Patient not found"));

        return prescriptionService.createFromFields(
                patient,
                req.getMedicationName(),
                "AUTO",
                req.getDose(),
                req.getFrequency(),
                LocalDate.now(),
                null,
                "system"
        );
    }
}