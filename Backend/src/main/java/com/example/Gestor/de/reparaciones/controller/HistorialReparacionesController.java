package com.example.Gestor.de.reparaciones.controller;

import com.example.Gestor.de.reparaciones.entities.HistorialReparacionesEntity;
import com.example.Gestor.de.reparaciones.services.HistorialReparacionesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/historialReparaciones")
@CrossOrigin("*")
public class HistorialReparacionesController {
    @Autowired
    HistorialReparacionesService historialReparacionesService;

    /*
    @GetMapping("/")
    public ResponseEntity<List<HistorialReparacionesEntity>> listhistorialReparaciones() {
        List<HistorialReparacionesEntity> historialReparaciones = historialReparacionesService.getHistorialReparaciones();
        return ResponseEntity.ok(historialReparaciones);
    }

     */
/*
    @GetMapping("/calculate")
    public ResponseEntity<Void> calculatePaychecks(@RequestParam("year") int year, @RequestParam("month") int month) {
        paycheckService.calculatePaychecks(year, month);
        return ResponseEntity.noContent().build();
    }

 */
}
