package com.historiasclinias.plataforma.behavioral.chain;

import com.historiasclinias.plataforma.composite.ClinicalHistoryRequest;

public abstract class HistoryValidationHandler {

    private HistoryValidationHandler next;

    public HistoryValidationHandler linkWith(HistoryValidationHandler next) {
        this.next = next;
        return next;
    }

    public void validate(ClinicalHistoryRequest request) {
        check(request);
        if (next != null) {
            next.validate(request);
        }
    }

    protected abstract void check(ClinicalHistoryRequest request);
}
