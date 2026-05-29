package com.historiasclinias.plataforma.behavioral.command;

import com.historiasclinias.plataforma.behavioral.observer.ClinicalEvent;
import com.historiasclinias.plataforma.behavioral.observer.ClinicalEventPublisher;
import org.springframework.stereotype.Component;

@Component
public class ClinicalCommandExecutor {

    private final ClinicalEventPublisher eventPublisher;

    public ClinicalCommandExecutor(ClinicalEventPublisher eventPublisher) {
        this.eventPublisher = eventPublisher;
    }

    public <T> T execute(String commandName, String entityType, String entityId, ClinicalCommand<T> command) {
        T result = command.execute();
        eventPublisher.publish(new ClinicalEvent(
                "COMMAND_EXECUTED",
                entityType,
                entityId,
                "Se ejecuto el comando clinico: " + commandName
        ));
        return result;
    }
}
