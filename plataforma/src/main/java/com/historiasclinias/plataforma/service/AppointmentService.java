package com.historiasclinias.plataforma.service;

import com.historiasclinias.plataforma.model.Appointment;
import com.historiasclinias.plataforma.repository.AppointmentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class AppointmentService {
    private final AppointmentRepository repo;
    public AppointmentService(AppointmentRepository repo) { this.repo = repo; }
    public Appointment save(Appointment a) { return repo.save(a); }
    public List<Appointment> findAll() { return repo.findAll(); }
    public Appointment findById(UUID id) { return repo.findById(id).orElse(null); }
}
