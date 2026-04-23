package com.historiasclinias.plataforma.flyweight;

import com.historiasclinias.plataforma.model.Prescription;
import com.historiasclinias.plataforma.service.PrescriptionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/flyweight")
public class FlyweightPrescriptionController {

    private final PrescriptionService prescriptionService;
    private final MedicationFlyweightFactory medicationFlyweightFactory;

    public FlyweightPrescriptionController(PrescriptionService prescriptionService,
                                           MedicationFlyweightFactory medicationFlyweightFactory) {
        this.prescriptionService = prescriptionService;
        this.medicationFlyweightFactory = medicationFlyweightFactory;
    }

    @PostMapping("/prescriptions")
    public ResponseEntity<Prescription> create(@RequestBody FlyweightPrescriptionRequest request) {
        return ResponseEntity.ok(prescriptionService.createFromFlyweight(request));
    }

    @GetMapping("/cache")
    public ResponseEntity<String> cacheInfo() {
        return ResponseEntity.ok(
                "Cache size: " + medicationFlyweightFactory.getCacheSize() +
                " | Cached codes: " + medicationFlyweightFactory.getCachedCodes()
        );
    }
}