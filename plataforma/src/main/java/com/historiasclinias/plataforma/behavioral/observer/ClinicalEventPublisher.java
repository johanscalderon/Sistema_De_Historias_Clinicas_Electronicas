package com.historiasclinias.plataforma.behavioral.observer;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ClinicalEventPublisher {

    private final List<ClinicalEventObserver> observers;

    public ClinicalEventPublisher(List<ClinicalEventObserver> observers) {
        this.observers = observers;
    }

    public void publish(ClinicalEvent event) {
        observers.forEach(observer -> observer.onClinicalEvent(event));
    }
}
