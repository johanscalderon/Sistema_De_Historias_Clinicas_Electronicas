package com.historiasclinias.plataforma.repository;

import com.historiasclinias.plataforma.model.Interaction;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;
public interface InteractionRepository extends JpaRepository<Interaction, UUID> { }