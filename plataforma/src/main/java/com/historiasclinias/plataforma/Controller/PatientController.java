package com.historiasclinias.plataforma.Controller;

import com.historiasclinias.plataforma.model.Patient;
import com.historiasclinias.plataforma.service.PatientService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/patients")
public class PatientController {
    private final PatientService service;
    public PatientController(PatientService service) { this.service = service; }

    @PostMapping
    public ResponseEntity<Patient> create(@RequestBody Patient p) {
        return ResponseEntity.ok(service.save(p));
    }

    @GetMapping
    public ResponseEntity<List<Patient>> list() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Patient> get(@PathVariable UUID id) {
        Patient p = service.findById(id);
        if (p == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(p);
    }
}
