package com.historiasclinias.plataforma.proxy;

import com.historiasclinias.plataforma.model.Patient;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@Primary
public class PatientAccessProxy implements PatientAccessService {

    private final RealPatientAccessService realService;

    public PatientAccessProxy(RealPatientAccessService realService) {
        this.realService = realService;
    }

    @Override
    public Patient getPatientById(UUID id, String role) {
        Patient patient = realService.getPatientById(id, role);

        if (role != null &&
            (role.equalsIgnoreCase("DOCTOR") || role.equalsIgnoreCase("ADMIN"))) {
            return patient;
        }

        Patient masked = new Patient();
        masked.setId(patient.getId());
        masked.setFirstName(mask(patient.getFirstName()));
        masked.setLastName(mask(patient.getLastName()));
        masked.setDni("****");
        masked.setBirthDate(null);
        masked.setGender(patient.getGender());

        return masked;
    }

    private String mask(String value) {
        if (value == null || value.isBlank()) {
            return value;
        }
        return value.substring(0, 1) + "***";
    }
}