package com.historiasclinias.plataforma.behavioral.state;

import com.historiasclinias.plataforma.composite.ClinicalRecord;

public interface ClinicalRecordState {
    String name();
    void validate(ClinicalRecord record);
    void sign(ClinicalRecord record);
    void reopen(ClinicalRecord record);
}
