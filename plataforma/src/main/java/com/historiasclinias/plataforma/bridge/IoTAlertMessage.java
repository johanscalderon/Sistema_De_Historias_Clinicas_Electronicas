package com.historiasclinias.plataforma.bridge;

public class IoTAlertMessage extends AlertMessage {

    public IoTAlertMessage(AlertChannel channel, String message) {
        super(channel, "ALERTA IOT", message);
    }
}