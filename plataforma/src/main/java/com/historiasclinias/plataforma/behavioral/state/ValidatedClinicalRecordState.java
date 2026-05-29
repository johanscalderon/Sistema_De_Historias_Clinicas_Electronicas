package com.historiasclinias.plataforma.behavioral.state;

import com.historiasclinias.plataforma.composite.ClinicalRecord;

public class ValidatedClinicalRecordState implements ClinicalRecordState {

    @Override
    public String name() { return "VALIDATED"; }

    @Override
    public void validate(ClinicalRecord record) { record.setStatus("VALIDATED"); }

    @Override
    public void sign(ClinicalRecord record) { record.setStatus("SIGNED"); }

    @Override
    public void reopen(ClinicalRecord record) { record.setStatus("DRAFT"); }
}
