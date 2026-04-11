package com.historiasclinias.plataforma.decorator;

import com.historiasclinias.plataforma.factory.AlertNotifier;
import com.historiasclinias.plataforma.model.Interaction;

import java.time.ZonedDateTime;

public class TimestampAlertNotifierDecorator extends AlertNotifierDecorator {

    public TimestampAlertNotifierDecorator(AlertNotifier wrappedNotifier) {
        super(wrappedNotifier);
    }

    @Override
    public void notify(Interaction interaction) {
        System.out.println("Hora de notificación: " + ZonedDateTime.now());
        super.notify(interaction);
    }
}