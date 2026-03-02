package com.historiasclinias.plataforma.repository;

import com.historiasclinias.plataforma.model.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AppointmentRepository extends JpaRepository<Appointment, UUID> {
    // consultas personalizadas si las necesitas
}
