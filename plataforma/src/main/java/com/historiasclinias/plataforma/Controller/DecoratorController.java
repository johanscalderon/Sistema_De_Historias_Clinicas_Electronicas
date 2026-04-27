package com.historiasclinias.plataforma.Controller;

import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/decorator")
public class DecoratorController {

    @PostMapping("/notify")
    public ResponseEntity<?> notify(@RequestBody DecoratorRequest req) {

        String result = req.getMessage();

        if ("urgent".equals(req.getDecorator())) {
            result = "🚨 URGENTE: " + result;
        } else if ("format".equals(req.getDecorator())) {
            result = "*** " + result.toUpperCase() + " ***";
        } else if ("all".equals(req.getDecorator())) {
            result = "🚨 *** " + result.toUpperCase() + " ***";
        }

        return ResponseEntity.ok(Map.of(
                "original", req.getMessage(),
                "final", result
        ));
    }
}