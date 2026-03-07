package com.historiasclinias.plataforma.factory;

public interface AlertFactory {
    AlertCreator getAlertCreator();
    AlertNotifier getAlertNotifier();
}