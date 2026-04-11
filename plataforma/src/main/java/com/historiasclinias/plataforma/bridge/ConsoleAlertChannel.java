package com.historiasclinias.plataforma.bridge;

public class ConsoleAlertChannel implements AlertChannel {

    @Override
    public void send(String subject, String message) {
        System.out.println("[" + subject + "] " + message);
    }
}
