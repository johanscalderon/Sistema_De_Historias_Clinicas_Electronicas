package com.historiasclinias.plataforma.proxy;

import com.historiasclinias.plataforma.model.Patient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/proxy/patients")
public class PatientProxyController {

    private final PatientAccessService patientAccessService;

    public PatientProxyController(PatientAccessService patientAccessService) {
        this.patientAccessService = patientAccessService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Patient> getPatient(
            @PathVariable UUID id,
            @RequestParam(required = false, defaultValue = "PATIENT") String role) {
        try {
            return ResponseEntity.ok(patientAccessService.getPatientById(id, role));
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
}