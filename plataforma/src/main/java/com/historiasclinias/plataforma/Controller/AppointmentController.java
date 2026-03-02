package com.historiasclinias.plataforma.Controller;

import com.historiasclinias.plataforma.model.Appointment;
import com.historiasclinias.plataforma.service.AppointmentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/appointments")
public class AppointmentController {
    private final AppointmentService service;
    public AppointmentController(AppointmentService service) { this.service = service; }

    @PostMapping
    public ResponseEntity<Appointment> create(@RequestBody Appointment a) {
        return ResponseEntity.ok(service.save(a));
    }

    @GetMapping
    public ResponseEntity<List<Appointment>> list() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Appointment> get(@PathVariable UUID id) {
        Appointment a = service.findById(id);
        if (a == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(a);
    }
}