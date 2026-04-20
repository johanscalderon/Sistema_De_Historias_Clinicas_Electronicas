package com.historiasclinias.plataforma.composite;

import org.springframework.stereotype.Service;

@Service
public class ClinicalRecordService {

    public ClinicalRecord buildDemoRecord() {
        ClinicalRecord record = new ClinicalRecord("Carlos Calderon");

        record.add(new DiagnosisItem("Hipertensión", "Presión arterial elevada"));
        record.add(new TreatmentItem("Acetaminofén", "100mg cada 8 horas"));

        return record;
    }
}