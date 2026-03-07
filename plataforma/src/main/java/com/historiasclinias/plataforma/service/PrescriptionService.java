package com.historiasclinias.plataforma.service;

import com.historiasclinias.plataforma.model.Interaction;
import com.historiasclinias.plataforma.model.Prescription;
import com.historiasclinias.plataforma.pattern.AlertEngine;
import com.historiasclinias.plataforma.repository.PrescriptionRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class PrescriptionService {

    private final PrescriptionRepository repo;
    private final AlertEngine alertEngine;

    public PrescriptionService(PrescriptionRepository repo, AlertEngine alertEngine) {
        this.repo = repo;
        this.alertEngine = alertEngine;
    }

    public Prescription save(Prescription p) {
        Prescription saved = repo.save(p);

        // Delegamos completamente a AlertEngine + fabrica: creación y notificación
        Optional<Interaction> maybe = alertEngine.checkAndPersistInteraction(saved);

        // NO imprimir aquí (evita duplicados).
        // Si necesitas auditar, usa un logger en nivel DEBUG (ver alternativa abajo).

        return saved;
    }

    public List<Prescription> findAll() {
        return repo.findAll();
    }

    public Prescription findById(UUID id) {
        return repo.findById(id).orElse(null);
    }
}