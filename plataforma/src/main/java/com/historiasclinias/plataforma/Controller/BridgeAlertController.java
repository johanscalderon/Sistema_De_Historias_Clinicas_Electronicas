package com.historiasclinias.plataforma.Controller;

import com.historiasclinias.plataforma.bridge.AlertChannel;
import com.historiasclinias.plataforma.bridge.AlertMessage;
import com.historiasclinias.plataforma.bridge.ClinicalAlertMessage;
import com.historiasclinias.plataforma.bridge.ConsoleAlertChannel;
import com.historiasclinias.plataforma.bridge.EmailAlertChannel;
import com.historiasclinias.plataforma.bridge.IoTAlertMessage;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/bridge/alerts")
public class BridgeAlertController {

    @PostMapping("/send")
    public ResponseEntity<?> send(@RequestBody BridgeAlertRequest request) {
        AlertChannel channel = "email".equalsIgnoreCase(request.getChannelType())
                ? new EmailAlertChannel()
                : new ConsoleAlertChannel();

        AlertMessage alert = "iot".equalsIgnoreCase(request.getAlertType())
                ? new IoTAlertMessage(channel, request.getMessage())
                : new ClinicalAlertMessage(channel, request.getMessage());

        alert.send();

        return ResponseEntity.ok(Map.of(
                "status", "ok",
                "alertType", request.getAlertType(),
                "channelType", request.getChannelType(),
                "message", request.getMessage()
        ));
    }
}