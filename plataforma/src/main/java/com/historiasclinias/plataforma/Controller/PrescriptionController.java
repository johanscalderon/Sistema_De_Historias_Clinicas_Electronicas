package com.historiasclinias.plataforma.Controller;

import com.historiasclinias.plataforma.model.Prescription;
import com.historiasclinias.plataforma.repository.PatientRepository;
import com.historiasclinias.plataforma.service.PrescriptionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/prescriptions")
public class PrescriptionController {

    private final PrescriptionService prescriptionService;
    private final PatientRepository patientRepository;

    public PrescriptionController(PrescriptionService prescriptionService,
                                  PatientRepository patientRepository) {
        this.prescriptionService = prescriptionService;
        this.patientRepository = patientRepository;
    }

    @PostMapping
    public ResponseEntity<Prescription> create(@RequestBody Prescription p) {
        return ResponseEntity.ok(prescriptionService.save(p));
    }

    @GetMapping
    public ResponseEntity<List<Prescription>> list() {
        return ResponseEntity.ok(prescriptionService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Prescription> get(@PathVariable UUID id) {
        Prescription p = prescriptionService.findById(id);
        if (p == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(p);
    }

    @GetMapping("/patient/{patientId}")
    public ResponseEntity<List<Prescription>> byPatient(@PathVariable UUID patientId) {
        return ResponseEntity.ok(prescriptionService.findByPatientId(patientId));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Prescription> update(@PathVariable UUID id,
                                               @RequestBody BuilderDemoRequest request) {
        var patient = patientRepository.findById(request.getPatientId())
                .orElseThrow(() -> new RuntimeException("Patient not found"));

        Prescription updated = prescriptionService.updateFromFields(
                id,
                patient,
                request.getMedicationName(),
                request.getMedicationCode(),
                request.getDose(),
                request.getFrequency(),
                request.getStartDate(),
                request.getEndDate(),
                request.getCreatedBy()
        );

        return ResponseEntity.ok(updated);
    }

    @PostMapping("/{id}/clone")
    public ResponseEntity<Prescription> clonePrescription(@PathVariable UUID id) {
        return ResponseEntity.ok(prescriptionService.clonePrescription(id));
    }
}
