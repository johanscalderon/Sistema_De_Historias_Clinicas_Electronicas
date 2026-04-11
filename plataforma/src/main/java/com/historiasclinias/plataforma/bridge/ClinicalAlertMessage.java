package com.historiasclinias.plataforma.bridge;

public class ClinicalAlertMessage extends AlertMessage {

    public ClinicalAlertMessage(AlertChannel channel, String message) {
        super(channel, "ALERTA CLÍNICA", message);
    }
}