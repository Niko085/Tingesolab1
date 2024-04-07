package com.example.Gestor.de.reparaciones.controllers;

import com.example.Gestor.de.reparaciones.entities.Detalle;
import com.example.Gestor.de.reparaciones.services.ReparacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class DetalleController {
    private final ReparacionService reparacionService;

    @Autowired
    public DetalleController(ReparacionService reparacionService) {
        this.reparacionService = reparacionService;
    }

    @GetMapping("/reparaciones")
    public List<Detalle> encontrarReparacionesPorPatente(@RequestParam String patente) {
        return reparacionService.encontrarReparacionesPorPatente(patente);
    }
}
