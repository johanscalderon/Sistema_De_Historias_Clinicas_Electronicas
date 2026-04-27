package com.historiasclinias.plataforma.proxy;

import java.util.UUID;

import org.springframework.stereotype.Service;

import com.historiasclinias.plataforma.model.Patient;

@Service
public class PatientProxy implements PatientAccess {

    private final RealPatientService realService;

    public PatientProxy(RealPatientService realService) {
        this.realService = realService;
    }

    @Override
    public Patient getPatient(UUID id, String role) {

        if ("GUEST".equalsIgnoreCase(role)) {
            throw new RuntimeException("Acceso denegado");
        }

        System.out.println("Acceso permitido para rol: " + role);

        return realService.getPatient(id, role);
    }
}
