package com.historiasclinias.plataforma.factory;

import org.springframework.stereotype.Component;

/**
 * Fábrica para alertas clínicas (persistir interactions en BD + notificador por
 * consola/email).
 */
@Component("clinicalAlertFactory")
public class ClinicalAlertFactory implements AlertFactory {

    private final ClinicalAlertCreator creator;
    private final ConsoleAlertNotifier notifier;

    public ClinicalAlertFactory(ClinicalAlertCreator creator, ConsoleAlertNotifier notifier) {
        this.creator = creator;
        this.notifier = notifier;
    }

    @Override
    public AlertCreator getAlertCreator() {
        return creator;
    }

    @Override
    public AlertNotifier getAlertNotifier() {
        return notifier;
    }
}