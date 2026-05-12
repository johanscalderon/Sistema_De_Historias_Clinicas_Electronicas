package com.historiasclinias.plataforma.composite;

import com.historiasclinias.plataforma.model.Patient;
import com.historiasclinias.plataforma.repository.PatientRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ClinicalRecordService {

    private final ClinicalRecordRepository clinicalRecordRepository;
    private final PatientRepository patientRepository;

    public ClinicalRecordService(ClinicalRecordRepository clinicalRecordRepository,
                                 PatientRepository patientRepository) {
        this.clinicalRecordRepository = clinicalRecordRepository;
        this.patientRepository = patientRepository;
    }

    public ClinicalRecord createHistory(ClinicalHistoryRequest request) {
        Patient patient = patientRepository.findById(request.getPatientId())
                .orElseThrow(() -> new RuntimeException("Patient not found"));

        ClinicalRecord record = new ClinicalRecord();
        record.setPatientId(patient.getId());
        record.setPatientName(patient.getFirstName() + " " + patient.getLastName());
        record.setDiagnoses(request.getDiagnoses());
        record.setTreatments(request.getTreatments());

        return clinicalRecordRepository.save(record);
    }

    public List<ClinicalRecord> findByPatientId(UUID patientId) {
        return clinicalRecordRepository.findByPatientIdOrderByCreatedAtDesc(patientId);
    }

    public List<ClinicalRecord> findAll() {
        return clinicalRecordRepository.findAllByOrderByCreatedAtDesc();
    }
}