package com.historiasclinias.plataforma.proxy;

import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/proxy/patients")
public class ProxyController {

    private final PatientProxy proxy;

    public ProxyController(PatientProxy proxy) {
        this.proxy = proxy;
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getPatient(
            @PathVariable UUID id,
            @RequestParam String role) {

        return ResponseEntity.ok(proxy.getPatient(id, role));
    }
}