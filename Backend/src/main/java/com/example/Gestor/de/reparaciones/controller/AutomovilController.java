package com.example.Gestor.de.reparaciones.controller;

import com.example.Gestor.de.reparaciones.services.AutomovilService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/automoviles")
@CrossOrigin("*")
public class AutomovilController {
    @Autowired
    AutomovilService automovilService;
}
