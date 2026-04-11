package com.historiasclinias.plataforma.bridge;

public class EmailAlertChannel implements AlertChannel {

    @Override
    public void send(String subject, String message) {
        System.out.println("ENVIANDO CORREO -> " + subject + " | " + message);
    }
}