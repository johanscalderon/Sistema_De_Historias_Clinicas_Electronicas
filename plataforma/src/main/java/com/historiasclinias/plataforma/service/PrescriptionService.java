package com.historiasclinias.plataforma.service;

import com.historiasclinias.plataforma.model.Interaction;
import com.historiasclinias.plataforma.model.Prescription;
import com.historiasclinias.plataforma.pattern.AlertEngine;
import com.historiasclinias.plataforma.repository.InteractionRepository;
import com.historiasclinias.plataforma.repository.PrescriptionRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class PrescriptionService {
    private final PrescriptionRepository repo;
    private final InteractionRepository interactionRepo;

    public PrescriptionService(PrescriptionRepository repo, InteractionRepository interactionRepo) {
        this.repo = repo;
        this.interactionRepo = interactionRepo;
    }

    public Prescription save(Prescription p) {
        Prescription saved = repo.save(p);
        // uso del singleton AlertEngine
        AlertEngine engine = AlertEngine.getInstance();
        Optional<Interaction> maybe = engine.checkAndPersistInteraction(saved, interactionRepo);
        // Podrías notificar a usuarios si maybe.isPresent()
        return saved;
    }

    public List<Prescription> findAll() { return repo.findAll(); }
    public Prescription findById(UUID id) { return repo.findById(id).orElse(null); }
}
