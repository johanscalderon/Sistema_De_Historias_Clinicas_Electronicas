package com.historiasclinias.plataforma.behavioral.chain;

import com.historiasclinias.plataforma.composite.ClinicalHistoryRequest;
import org.springframework.stereotype.Component;

@Component
public class ClinicalHistoryValidationChain {

    private final HistoryValidationHandler chain;

    public ClinicalHistoryValidationChain() {
        chain = new PatientRequiredHandler();
        chain.linkWith(new DiagnosisRequiredHandler())
                .linkWith(new TreatmentRequiredHandler());
    }

    public void validate(ClinicalHistoryRequest request) {
        chain.validate(request);
    }
}
