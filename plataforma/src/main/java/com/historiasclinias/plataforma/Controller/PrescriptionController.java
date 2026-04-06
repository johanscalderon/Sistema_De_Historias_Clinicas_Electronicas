package com.historiasclinias.plataforma.controller;

import com.historiasclinias.plataforma.model.Prescription;
import com.historiasclinias.plataforma.service.PrescriptionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/prescriptions")
public class PrescriptionController {

    private final PrescriptionService prescriptionService;

    public PrescriptionController(PrescriptionService prescriptionService) {
        this.prescriptionService = prescriptionService;
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

    @PostMapping("/{id}/clone")
    public ResponseEntity<Prescription> clonePrescription(@PathVariable UUID id) {
        return ResponseEntity.ok(prescriptionService.clonePrescription(id));
    }
}