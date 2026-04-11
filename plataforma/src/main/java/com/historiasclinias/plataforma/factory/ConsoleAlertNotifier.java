package com.historiasclinias.plataforma.factory;

import com.historiasclinias.plataforma.bridge.AlertChannel;
import com.historiasclinias.plataforma.bridge.AlertMessage;
import com.historiasclinias.plataforma.bridge.ClinicalAlertMessage;
import com.historiasclinias.plataforma.bridge.ConsoleAlertChannel;
import com.historiasclinias.plataforma.bridge.IoTAlertMessage;
import com.historiasclinias.plataforma.model.Interaction;
import org.springframework.stereotype.Component;

@Component
public class ConsoleAlertNotifier implements AlertNotifier {

    @Override
    public void notify(Interaction interaction) {
        AlertChannel channel = new ConsoleAlertChannel();

        String text = interaction.getDescription() + " (severity=" + interaction.getSeverity() + ")";

        AlertMessage message;
        if (interaction.getRuleId() != null && interaction.getRuleId().toLowerCase().contains("iot")) {
            message = new IoTAlertMessage(channel, text);
        } else {
            message = new ClinicalAlertMessage(channel, text);
        }

        message.send();
    }
}