package com.historiasclinias.plataforma.decorator;

import com.historiasclinias.plataforma.factory.AlertNotifier;
import com.historiasclinias.plataforma.model.Interaction;

public abstract class AlertNotifierDecorator implements AlertNotifier {

    protected final AlertNotifier wrappedNotifier;

    public AlertNotifierDecorator(AlertNotifier wrappedNotifier) {
        this.wrappedNotifier = wrappedNotifier;
    }

    @Override
    public void notify(Interaction interaction) {
        wrappedNotifier.notify(interaction);
    }
}