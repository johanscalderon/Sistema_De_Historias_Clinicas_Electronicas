package com.historiasclinias.plataforma.factory;

import org.springframework.stereotype.Component;

/**
 * Fábrica para alertas generadas por datos IoT.
 */
@Component("iotAlertFactory")
public class IoTAlertFactory implements AlertFactory {

    private final IoTAlertCreator creator;
    private final ConsoleAlertNotifier notifier;

    public IoTAlertFactory(IoTAlertCreator creator, ConsoleAlertNotifier notifier) {
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