package com.historiasclinias.plataforma.Controller;

import com.historiasclinias.plataforma.model.Patient;
import com.historiasclinias.plataforma.model.Prescription;
import com.historiasclinias.plataforma.repository.PatientRepository;
import com.historiasclinias.plataforma.service.PrescriptionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/builder")
public class BuilderDemoController {

    private final PatientRepository patientRepository;
    private final PrescriptionService prescriptionService;

    public BuilderDemoController(PatientRepository patientRepository,
                                 PrescriptionService prescriptionService) {
        this.patientRepository = patientRepository;
        this.prescriptionService = prescriptionService;
    }

    @PostMapping("/prescriptions")
    public ResponseEntity<Prescription> create(@RequestBody BuilderDemoRequest request) {
        Patient patient = patientRepository.findById(request.getPatientId())
                .orElseThrow(() -> new RuntimeException("Patient not found"));

        Prescription saved = prescriptionService.createFromFields(
                patient,
                request.getMedicationName(),
                request.getMedicationCode(),
                request.getDose(),
                request.getFrequency(),
                request.getStartDate(),
                request.getEndDate(),
                request.getCreatedBy()
        );

        return ResponseEntity.ok(saved);
    }
}