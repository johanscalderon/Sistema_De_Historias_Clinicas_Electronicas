package com.historiasclinias.plataforma.bridge;

public interface AlertChannel {
    void send(String subject, String message);
}
