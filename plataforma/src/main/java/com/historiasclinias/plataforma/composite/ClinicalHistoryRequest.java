package com.historiasclinias.plataforma.composite;

import java.util.UUID;

public class ClinicalHistoryRequest {
    private UUID patientId;
    private String diagnoses;
    private String treatments;

    public UUID getPatientId() { return patientId; }
    public void setPatientId(UUID patientId) { this.patientId = patientId; }

    public String getDiagnoses() { return diagnoses; }
    public void setDiagnoses(String diagnoses) { this.diagnoses = diagnoses; }

    public String getTreatments() { return treatments; }
    public void setTreatments(String treatments) { this.treatments = treatments; }
}