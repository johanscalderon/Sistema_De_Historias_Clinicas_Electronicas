package com.historiasclinias.plataforma.Controller;

import com.historiasclinias.plataforma.adapter.*;
import com.historiasclinias.plataforma.model.Observation;
import com.historiasclinias.plataforma.service.IoTService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/iot/adapter")
public class IoTAdapterController {

    private final IoTService iotService;

    public IoTAdapterController(IoTService iotService) {
        this.iotService = iotService;
    }

    @PostMapping("/heart-rate")
    public ResponseEntity<Observation> heartRate(@RequestBody HeartRateDevicePayload payload) {
        Observation observation = new HeartRateObservationAdapter(payload).adapt();
        return ResponseEntity.ok(iotService.processObservation("heartrate", observation));
    }

    @PostMapping("/temperature")
    public ResponseEntity<Observation> temperature(@RequestBody TemperatureDevicePayload payload) {
        Observation observation = new TemperatureObservationAdapter(payload).adapt();
        return ResponseEntity.ok(iotService.processObservation("temperature", observation));
    }

    @PostMapping("/pressure")
    public ResponseEntity<Observation> pressure(@RequestBody PressureDevicePayload payload) {
        Observation observation = new PressureObservationAdapter(payload).adapt();
        return ResponseEntity.ok(iotService.processObservation("pressure", observation));
    }
}