package com.historiasclinias.plataforma.pattern;

import com.historiasclinias.plataforma.model.Interaction;
import com.historiasclinias.plataforma.model.Prescription;
import com.historiasclinias.plataforma.repository.InteractionRepository;

import java.time.ZonedDateTime;
import java.util.Optional;

/**
 * AlertEngine: singleton clásico. Mantiene la lógica simple de "detectar interacciones".
 * NOTA: la persistencia se realiza pasando el repository como parámetro (evita mezclar spring en singleton).
 */
public class AlertEngine {

    // instancia única
    private static volatile AlertEngine instance;

    // constructor privado
    private AlertEngine() { }

    // acceso con doble-check locking
    public static AlertEngine getInstance() {
        if (instance == null) {
            synchronized (AlertEngine.class) {
                if (instance == null) {
                    instance = new AlertEngine();
                }
            }
        }
        return instance;
    }

    /**
     * Método simple de ejemplo que detecta una "interacción" ficticia:
     * Si el nombre del medicamento contiene "X" devolvemos una interacción de severidad "moderate".
     * En un sistema real aquí se consultaría catálogo RxNorm y reglas clínicas.
     *
     * Guarda el resultado en la tabla interactions usando el repository pasado.
     */
    public Optional<Interaction> checkAndPersistInteraction(Prescription p, InteractionRepository repo) {
        // lógica de ejemplo: signo simple
        if (p.getMedicationName() != null && p.getMedicationName().toLowerCase().contains("aspirin")) {
            Interaction it = new Interaction();
            it.setPrescription(p);
            it.setSeverity("moderate");
            it.setDescription("Posible interacción con aspirina detectada por regla simple.");
            it.setRuleId("rule_simple_aspirin_check");
            it.setDetectedAt(ZonedDateTime.now());
            Interaction saved = repo.save(it);
            return Optional.of(saved);
        }
        // otra regla de ejemplo: si medicamento contiene "X" -> high
        if (p.getMedicationName() != null && p.getMedicationName().toLowerCase().contains("x")) {
            Interaction it = new Interaction();
            it.setPrescription(p);
            it.setSeverity("high");
            it.setDescription("Interacción crítica detectada (nombre contiene 'x').");
            it.setRuleId("rule_name_contains_x");
            it.setDetectedAt(ZonedDateTime.now());
            Interaction saved = repo.save(it);
            return Optional.of(saved);
        }
        return Optional.empty();
    }
}
