package com.historiasclinias.plataforma.Controller;

import com.historiasclinias.plataforma.model.Interaction;
import com.historiasclinias.plataforma.repository.InteractionRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/interactions")
public class InteractionController {

    private final InteractionRepository interactionRepository;

    public InteractionController(InteractionRepository interactionRepository) {
        this.interactionRepository = interactionRepository;
    }

    @GetMapping
    public ResponseEntity<List<Interaction>> list() {
        return ResponseEntity.ok(interactionRepository.findAll());
    }
}
