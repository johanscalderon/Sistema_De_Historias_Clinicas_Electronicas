package com.historiasclinias.plataforma.factory;

import com.historiasclinias.plataforma.model.Interaction;
import org.springframework.stereotype.Component;

@Component
public class ConsoleAlertNotifier implements AlertNotifier {

    @Override
    public void notify(Interaction interaction) {
        if (interaction != null) {
            System.out.println("NOTIFICACIÓN: " + interaction.getDescription() + " (severity=" + interaction.getSeverity() + ")");
        }
    }
}