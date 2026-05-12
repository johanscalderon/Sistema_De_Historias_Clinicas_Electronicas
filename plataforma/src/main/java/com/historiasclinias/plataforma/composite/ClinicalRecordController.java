package com.historiasclinias.plataforma.composite;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/composite/histories")
@CrossOrigin("*")
public class ClinicalRecordController {

    private final ClinicalRecordService clinicalRecordService;

    public ClinicalRecordController(ClinicalRecordService clinicalRecordService) {
        this.clinicalRecordService = clinicalRecordService;
    }

    @PostMapping
    public ResponseEntity<ClinicalRecord> create(@RequestBody ClinicalHistoryRequest request) {
        return ResponseEntity.ok(clinicalRecordService.createHistory(request));
    }

    @GetMapping("/patient/{patientId}")
    public ResponseEntity<List<ClinicalRecord>> byPatient(@PathVariable UUID patientId) {
        return ResponseEntity.ok(clinicalRecordService.findByPatientId(patientId));
    }

    @GetMapping
    public ResponseEntity<List<ClinicalRecord>> all() {
        return ResponseEntity.ok(clinicalRecordService.findAll());
    }
}