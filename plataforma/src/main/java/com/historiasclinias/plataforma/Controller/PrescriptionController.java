package com.historiasclinias.plataforma.Controller;

import com.historiasclinias.plataforma.model.Prescription;
import com.historiasclinias.plataforma.service.PrescriptionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/prescriptions")
public class PrescriptionController {
    private final PrescriptionService service;
    public PrescriptionController(PrescriptionService service) { this.service = service; }

    @PostMapping
    public ResponseEntity<Prescription> create(@RequestBody Prescription p) {
        Prescription saved = service.save(p);
        return ResponseEntity.ok(saved);
    }

    @GetMapping
    public ResponseEntity<List<Prescription>> list() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Prescription> get(@PathVariable UUID id) {
        Prescription p = service.findById(id);
        if (p == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(p);
    }
}