package com.historiasclinias.plataforma.Controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.historiasclinias.plataforma.facade.PrescriptionFacade;

@RestController
@RequestMapping("/api/facade/prescriptions")
public class FacadeController {

    private final PrescriptionFacade facade;

    public FacadeController(PrescriptionFacade facade) {
        this.facade = facade;
    }

  
}
