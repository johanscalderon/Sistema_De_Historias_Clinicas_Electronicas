package com.historiasclinias.plataforma.flyweight;

import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class MedicationFlyweightFactory {

    private final Map<String, MedicationFlyweight> cache = new ConcurrentHashMap<>();
    private final Map<String, MedicationData> catalog = Map.of(
            "134153", new MedicationData("134153", "Acetaminofen", "Analgesic"),
            "ASP100", new MedicationData("ASP100", "Aspirin", "Analgesic"),
            "IBU200", new MedicationData("IBU200", "Ibuprofeno", "Anti-inflammatory")
    );

    public MedicationFlyweight getMedication(String code) {
        String key = code.toUpperCase();

        if (cache.containsKey(key)) {
            System.out.println("Reusing existing flyweight for medication " + key);
            return cache.get(key);
        }

        MedicationData data = catalog.get(key);
        if (data == null) {
            throw new RuntimeException("Medication not found: " + code);
        }

        System.out.println("Creating new flyweight for medication " + key);
        MedicationFlyweight flyweight = new SharedMedicationFlyweight(data.code, data.name, data.category);
        cache.put(key, flyweight);
        return flyweight;
    }

    public int getCacheSize() {
        return cache.size();
    }

    public Set<String> getCachedCodes() {
        return cache.keySet();
    }

    private static class MedicationData {
        private final String code;
        private final String name;
        private final String category;

        private MedicationData(String code, String name, String category) {
            this.code = code;
            this.name = name;
            this.category = category;
        }
    }
}