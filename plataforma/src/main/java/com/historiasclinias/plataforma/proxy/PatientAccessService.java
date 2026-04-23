package com.historiasclinias.plataforma.proxy;

import com.historiasclinias.plataforma.model.Patient;

import java.util.UUID;

public interface PatientAccessService {
    Patient getPatientById(UUID id, String role);
}