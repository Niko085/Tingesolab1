package com.example.Gestor.de.reparaciones.controller;

import com.example.Gestor.de.reparaciones.entities.HistorialReparacionesEntity;
import com.example.Gestor.de.reparaciones.entities.ReparacionEntity;
import com.example.Gestor.de.reparaciones.services.HistorialReparacionesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/historialreparaciones")
@CrossOrigin("*")
public class HistorialReparacionesController {
    @Autowired
    HistorialReparacionesService historialReparacionesService;


    @GetMapping("/")
    public ResponseEntity<List<HistorialReparacionesEntity>> listhistorialReparaciones() {
        List<HistorialReparacionesEntity> historialReparaciones = historialReparacionesService.getHistorialReparaciones();
        return ResponseEntity.ok(historialReparaciones);
    }

    @GetMapping("/{patente}")
    public ResponseEntity<List<HistorialReparacionesEntity>> getHistorialReparacionesByPatente(@PathVariable String patente) {
        List<HistorialReparacionesEntity> reparaciones = historialReparacionesService.getHistorialReparacionesByPatente(patente);
        return ResponseEntity.ok(reparaciones);
    }

    @GetMapping("/calculate")
    public ResponseEntity<Void> calculatehistorial() {
        historialReparacionesService.calcularMontoTotalPagar();
        return ResponseEntity.noContent().build();
    }
/*
    @GetMapping("/calculate")
    public ResponseEntity<Void> calculatePaychecks(@RequestParam("year") int year, @RequestParam("month") int month) {
        paycheckService.calculatePaychecks(year, month);
        return ResponseEntity.noContent().build();
    }

 */
}
