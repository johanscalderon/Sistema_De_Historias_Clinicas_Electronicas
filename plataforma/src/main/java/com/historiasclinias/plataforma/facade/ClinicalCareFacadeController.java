package com.historiasclinias.plataforma.facade;

import com.historiasclinias.plataforma.model.Prescription;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/facade")
public class ClinicalCareFacadeController {

    private final ClinicalCareFacade clinicalCareFacade;

    public ClinicalCareFacadeController(ClinicalCareFacade clinicalCareFacade) {
        this.clinicalCareFacade = clinicalCareFacade;
    }

    @PostMapping("/prescriptions")
    public ResponseEntity<Prescription> createPrescription(@RequestBody CreatePrescriptionRequest request) {
        return ResponseEntity.ok(clinicalCareFacade.createPrescription(request));
    }
}