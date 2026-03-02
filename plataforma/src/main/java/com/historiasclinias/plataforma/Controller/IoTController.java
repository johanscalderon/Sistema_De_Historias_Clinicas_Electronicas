package com.historiasclinias.plataforma.Controller;

import com.historiasclinias.plataforma.model.Observation;
import com.historiasclinias.plataforma.service.IoTService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/iot")
public class IoTController {
    private final IoTService service;
    public IoTController(IoTService service) { this.service = service; }

    /**
     * POST /api/iot/observe?deviceType=heartrate
     * body: Observation JSON (patient must have been created)
     */
    @PostMapping("/observe")
    public ResponseEntity<Observation> observe(@RequestParam(required = false) String deviceType,
                                               @RequestBody Observation obs) {
        Observation saved = service.processObservation(deviceType, obs);
        return ResponseEntity.ok(saved);
    }
}
