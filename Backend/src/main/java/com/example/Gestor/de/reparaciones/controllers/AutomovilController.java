package com.example.Gestor.de.reparaciones.controllers;


import com.example.Gestor.de.reparaciones.dtos.CrearAutomovil;
import com.example.Gestor.de.reparaciones.entities.Automovil;
import com.example.Gestor.de.reparaciones.services.AutomovilService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class AutomovilController {

    AutomovilService automovilService;
    @Autowired

    public AutomovilController(AutomovilService automovilService) {
        this.automovilService = automovilService;
    }

    @GetMapping("/automoviles")
    List<Automovil> getAutomoviles() {
        return automovilService.getAutomoviles();
    }


    @PostMapping("/automoviles")
    Automovil createAutomovil(@RequestBody CrearAutomovil body) {
        return automovilService.saveAutomovil(body);
    }
















}