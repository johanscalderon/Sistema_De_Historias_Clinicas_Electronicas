package com.historiasclinias.plataforma.behavioral.state;

import com.historiasclinias.plataforma.composite.ClinicalRecord;

public class DraftClinicalRecordState implements ClinicalRecordState {

    @Override
    public String name() { return "DRAFT"; }

    @Override
    public void validate(ClinicalRecord record) { record.setStatus("VALIDATED"); }

    @Override
    public void sign(ClinicalRecord record) {
        throw new IllegalStateException("Primero se debe validar la historia clinica.");
    }

    @Override
    public void reopen(ClinicalRecord record) { record.setStatus("DRAFT"); }
}
