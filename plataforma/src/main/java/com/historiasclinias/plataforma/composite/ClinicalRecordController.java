package com.historiasclinias.plataforma.controller;

import com.historiasclinias.plataforma.composite.ClinicalRecord;
import com.historiasclinias.plataforma.composite.ClinicalRecordService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/composite")
public class ClinicalRecordController {

    private final ClinicalRecordService service;

    public ClinicalRecordController(ClinicalRecordService service) {
        this.service = service;
    }

    @GetMapping("/demo")
    public ResponseEntity<String> demo() {
        ClinicalRecord record = service.buildDemoRecord();
        return ResponseEntity.ok(record.showDetails());
    }
}