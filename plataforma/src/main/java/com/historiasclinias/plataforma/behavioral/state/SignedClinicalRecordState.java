package com.historiasclinias.plataforma.behavioral.state;

import com.historiasclinias.plataforma.composite.ClinicalRecord;

public class SignedClinicalRecordState implements ClinicalRecordState {

    @Override
    public String name() { return "SIGNED"; }

    @Override
    public void validate(ClinicalRecord record) { record.setStatus("SIGNED"); }

    @Override
    public void sign(ClinicalRecord record) { record.setStatus("SIGNED"); }

    @Override
    public void reopen(ClinicalRecord record) {
        throw new IllegalStateException("Una historia clinica firmada no se puede reabrir desde este flujo.");
    }
}
