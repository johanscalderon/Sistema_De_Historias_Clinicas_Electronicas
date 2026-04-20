package com.historiasclinias.plataforma.facade;

import com.historiasclinias.plataforma.model.Patient;
import com.historiasclinias.plataforma.model.Prescription;
import com.historiasclinias.plataforma.model.PrescriptionBuilder;
import com.historiasclinias.plataforma.repository.PatientRepository;
import com.historiasclinias.plataforma.service.PrescriptionService;
import org.springframework.stereotype.Service;

@Service
public class ClinicalCareFacade {

    private final PatientRepository patientRepository;
    private final PrescriptionService prescriptionService;

    public ClinicalCareFacade(PatientRepository patientRepository,
                              PrescriptionService prescriptionService) {
        this.patientRepository = patientRepository;
        this.prescriptionService = prescriptionService;
    }

    public Prescription createPrescription(CreatePrescriptionRequest request) {
        Patient patient = patientRepository.findById(request.getPatientId())
                .orElseThrow(() -> new RuntimeException("Patient not found"));

        Prescription prescription = new PrescriptionBuilder()
                .withPatient(patient)
                .withMedicationName(request.getMedicationName())
                .withMedicationCode(request.getMedicationCode())
                .withDose(request.getDose())
                .withFrequency(request.getFrequency())
                .withStartDate(request.getStartDate())
                .withEndDate(request.getEndDate())
                .withCreatedBy(request.getCreatedBy())
                .build();

        return prescriptionService.save(prescription);
    }
}