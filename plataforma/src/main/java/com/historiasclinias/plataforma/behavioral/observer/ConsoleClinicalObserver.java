package com.historiasclinias.plataforma.behavioral.observer;

import org.springframework.stereotype.Component;

@Component
public class ConsoleClinicalObserver implements ClinicalEventObserver {

    @Override
    public void onClinicalEvent(ClinicalEvent event) {
        System.out.println("[OBSERVER] " + event.getEventType() + " - " + event.getDescription());
    }
}
