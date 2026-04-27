package com.historiasclinias.plataforma.proxy;

import java.util.UUID;

import com.historiasclinias.plataforma.model.Patient;

public interface PatientAccess {
    Patient getPatient(UUID id, String role);
}
