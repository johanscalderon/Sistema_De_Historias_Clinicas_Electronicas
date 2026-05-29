package com.historiasclinias.plataforma.behavioral.state;

import com.historiasclinias.plataforma.composite.ClinicalRecord;
import org.springframework.stereotype.Component;

@Component
public class ClinicalRecordStateMachine {

    public void transition(ClinicalRecord record, String action) {
        ClinicalRecordState state = stateFor(record.getStatus());
        switch (action.toLowerCase()) {
            case "validate" -> state.validate(record);
            case "sign" -> state.sign(record);
            case "reopen" -> state.reopen(record);
            default -> throw new IllegalArgumentException("Accion de estado no soportada: " + action);
        }
    }

    private ClinicalRecordState stateFor(String status) {
        return switch (status == null ? "DRAFT" : status) {
            case "VALIDATED" -> new ValidatedClinicalRecordState();
            case "SIGNED" -> new SignedClinicalRecordState();
            default -> new DraftClinicalRecordState();
        };
    }
}
