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
            case "temperature":
            case "temp":
            case "thermometer":
                System.out.println("Handler seleccionado: TemperatureDeviceHandler");
                return new TemperatureDeviceHandler();

            case "blood_pressure":
            case "blood-pressure":
            case "pressure":
            case "bp":
            case "systolic":
                return new PressureDeviceHandler();
            default:
                return new GenericDeviceHandler();
        }
    }
}