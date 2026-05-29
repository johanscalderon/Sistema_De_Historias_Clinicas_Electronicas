package com.historiasclinias.plataforma.behavioral.strategy;

public class PrescriptionRiskResult {
    private final String level;
    private final String reason;

    public PrescriptionRiskResult(String level, String reason) {
        this.level = level;
        this.reason = reason;
    }

    public String getLevel() { return level; }
    public String getReason() { return reason; }
}
