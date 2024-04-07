package com.example.Gestor.de.reparaciones.controller;

import com.example.Gestor.de.reparaciones.entities.ReparacionEntity;
import com.example.Gestor.de.reparaciones.services.ReparacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reparaciones")
@CrossOrigin("*")
public class ReparacionController {
    @Autowired
    ReparacionService reparacionService;

    @GetMapping("/")
    public ResponseEntity<List<ReparacionEntity>> listExtraHours() {
        List<ReparacionEntity> reparaciones = reparacionService.getReparaciones();
        return ResponseEntity.ok(reparaciones);

    }

    @GetMapping("/{id}")
    public ResponseEntity<ReparacionEntity> getReparacionesById(@PathVariable Long id) {
        ReparacionEntity reparaciones = reparacionService.getReparacionById(id);
        return ResponseEntity.ok(reparaciones);
    }

    @PostMapping("/")
    public ResponseEntity<ReparacionEntity> saveReparacion(@RequestBody ReparacionEntity reparacion) {
        ReparacionEntity reparacionNew = reparacionService.saveReparacion(reparacion);
        return ResponseEntity.ok(reparacionNew);
    }
/*
    @GetMapping("/{rut}/{year}/{month}")
    public ResponseEntity<List<ReparacionEntity>> listExtraHoursByRut(@PathVariable("rut") String rut, @PathVariable("year") int year, @PathVariable("month") int month) {
        List<ReparacionEntity> extraHours = reparacionService.getExtraHoursByRutYearMonth(rut,year,month);
        return ResponseEntity.ok(extraHours);
    }

 */

    @PutMapping("/")
    public ResponseEntity<ReparacionEntity> updateReparacion(@RequestBody ReparacionEntity reparacion){
        ReparacionEntity reparacionUpdated = reparacionService.updateReparacion(reparacion);
        return ResponseEntity.ok(reparacionUpdated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteReparacionById(@PathVariable Long id) throws Exception {
        var isDeleted = reparacionService.deleteReparacion(id);
        return ResponseEntity.noContent().build();
    }
}