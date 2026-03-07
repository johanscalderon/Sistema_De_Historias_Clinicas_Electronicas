package com.historiasclinias.plataforma.factory;

import com.historiasclinias.plataforma.model.Interaction;
import com.historiasclinias.plataforma.model.Prescription;

import java.util.Optional;

public interface AlertCreator {
    /**
     * Crea (y persiste) una Interaction basada en la Prescription.
     * Devuelve Optional con la Interaction si se generó, o empty() si no.
     */
    Optional<Interaction> createAndPersist(Prescription p);
}