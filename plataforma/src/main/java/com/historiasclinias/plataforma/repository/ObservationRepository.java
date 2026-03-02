package com.historiasclinias.plataforma.repository;

import com.historiasclinias.plataforma.model.Observation;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;
public interface ObservationRepository extends JpaRepository<Observation, UUID> { }