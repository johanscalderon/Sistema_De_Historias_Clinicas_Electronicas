package com.historiasclinias.plataforma.iot;

/**
 * Factory Method simple: crea el handler según deviceType.
 */
public class DeviceHandlerFactory {

    public static DeviceHandler create(String deviceType) {
        if (deviceType == null) return new GenericDeviceHandler();

        switch (deviceType.toLowerCase()) {
            case "heartrate":
            case "heart_rate":
                return new HeartRateDeviceHandler();
            // agregar más tipos (glucose, spo2, etc.) aquí
            default:
                return new GenericDeviceHandler();
        }
    }
}