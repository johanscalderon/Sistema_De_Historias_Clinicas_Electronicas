package com.historiasclinias.plataforma.bridge;

public abstract class AlertMessage {

    protected AlertChannel channel;
    protected String subject;
    protected String message;

    protected AlertMessage(AlertChannel channel, String subject, String message) {
        this.channel = channel;
        this.subject = subject;
        this.message = message;
    }

    public void send() {
        channel.send(subject, message);
    }
}