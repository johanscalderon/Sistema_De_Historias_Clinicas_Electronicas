package com.historiasclinias.plataforma.decorator;

import com.historiasclinias.plataforma.factory.AlertNotifier;
import com.historiasclinias.plataforma.model.Interaction;

public class SeverityAlertNotifierDecorator extends AlertNotifierDecorator {

    public SeverityAlertNotifierDecorator(AlertNotifier wrappedNotifier) {
        super(wrappedNotifier);
    }

    @Override
    public void notify(Interaction interaction) {
        if (interaction != null) {
            System.out.println("Severidad de la alerta: " + interaction.getSeverity());
        }
        super.notify(interaction);
    }
}