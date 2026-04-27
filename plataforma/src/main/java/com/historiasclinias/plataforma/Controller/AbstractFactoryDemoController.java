package com.historiasclinias.plataforma.Controller;

import com.historiasclinias.plataforma.model.Patient;
import com.historiasclinias.plataforma.model.Prescription;
import com.historiasclinias.plataforma.model.PrescriptionBuilder;
import com.historiasclinias.plataforma.pattern.AlertEngine;
import com.historiasclinias.plataforma.repository.PatientRepository;
import com.historiasclinias.plataforma.repository.PrescriptionRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/abstract-factory")
public class AbstractFactoryDemoController {

    private final PatientRepository patientRepository;
    private final PrescriptionRepository prescriptionRepository;
    private final AlertEngine alertEngine;

    public AbstractFactoryDemoController(PatientRepository patientRepository,
                                         PrescriptionRepository prescriptionRepository,
                                         AlertEngine alertEngine) {
        this.patientRepository = patientRepository;
        this.prescriptionRepository = prescriptionRepository;
        this.alertEngine = alertEngine;
    }

    @PostMapping("/demo/{factoryBeanName}")
    public ResponseEntity<Prescription> demo(
            @PathVariable String factoryBeanName,
            @RequestBody AbstractFactoryDemoRequest request) {

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

        Prescription saved = prescriptionRepository.save(prescription);

        alertEngine.checkAndPersistInteraction(saved, factoryBeanName);

        return ResponseEntity.ok(saved);
    }
}