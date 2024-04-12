package com.example.Gestor.de.reparaciones.controller;

import com.example.Gestor.de.reparaciones.entities.ReparacionAutoEntity;
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
    public ResponseEntity<List<ReparacionAutoEntity>> listReparaciones() {
        List<ReparacionAutoEntity> reparaciones = reparacionService.getReparaciones();
        return ResponseEntity.ok(reparaciones);

    }
/*
    @GetMapping("/{id}")
    public ResponseEntity<ReparacionEntity> getReparacionById(@PathVariable Long id) {
        ReparacionEntity reparacion = reparacionService.getReparacionById(id);
        return ResponseEntity.ok(reparacion);
    }

 */

    @GetMapping("/{patente}")
    public ResponseEntity<List<ReparacionAutoEntity>> getReparacionesByPatente(@PathVariable String patente) {
        List<ReparacionAutoEntity> reparaciones = reparacionService.getReparacionesByPatente(patente);
        return ResponseEntity.ok(reparaciones);
    }

    @PostMapping("/")
    public ResponseEntity<ReparacionAutoEntity> saveReparacion(@RequestBody ReparacionAutoEntity reparacion) {
        ReparacionAutoEntity reparacionNew = reparacionService.saveReparacion(reparacion);
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
    public ResponseEntity<ReparacionAutoEntity> updateReparacion(@RequestBody ReparacionAutoEntity reparacion){
        ReparacionAutoEntity reparacionUpdated = reparacionService.updateReparacion(reparacion);
        return ResponseEntity.ok(reparacionUpdated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteReparacionById(@PathVariable Long id) throws Exception {
        var isDeleted = reparacionService.deleteReparacion(id);
        return ResponseEntity.noContent().build();
    }
}
