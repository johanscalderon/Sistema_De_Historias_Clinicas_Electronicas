package com.historiasclinias.plataforma.factory;

import com.historiasclinias.plataforma.model.Interaction;

public interface AlertNotifier {
    /**
     * Notifica de una Interaction (puede ser console log, email, etc.)
     */
    void notify(Interaction interaction);
}