package com.historiasclinias.plataforma.Controller;

import com.historiasclinias.plataforma.model.Patient;
import com.historiasclinias.plataforma.model.Prescription;
import com.historiasclinias.plataforma.model.PrescriptionBuilder;
import com.historiasclinias.plataforma.repository.PatientRepository;
import com.historiasclinias.plataforma.repository.PrescriptionRepository;

import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.UUID;

@RestController
@RequestMapping("/api/test")
public class TestBuilderController {

    private final PatientRepository patientRepository;
    private final PrescriptionRepository prescriptionRepository;

    public TestBuilderController(PatientRepository patientRepository,
                                 PrescriptionRepository prescriptionRepository) {
        this.patientRepository = patientRepository;
        this.prescriptionRepository = prescriptionRepository;
    }

    @PostMapping("/builder/{patientId}")
    public Prescription createPrescriptionWithBuilder(@PathVariable UUID patientId) {

        Patient patient = patientRepository.findById(patientId).orElseThrow();

        Prescription prescription = new PrescriptionBuilder()
                .withPatient(patient)
                .withMedicationName("Aspirin")
                .withDose("100mg")
                .withFrequency("daily")
                .withStartDate(LocalDate.now())
                .build();

        return prescriptionRepository.save(prescription);
    }
}