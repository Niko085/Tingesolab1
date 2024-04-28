package com.example.Gestor.de.reparaciones.controller;

import com.example.Gestor.de.reparaciones.dtos.ReparacionesvsTipoAutos;
import com.example.Gestor.de.reparaciones.dtos.ReparacionesvsTipoMotor;
import com.example.Gestor.de.reparaciones.dtos.TiemposPromedio;
import com.example.Gestor.de.reparaciones.entities.AutomovilEntity;
import com.example.Gestor.de.reparaciones.entities.HistorialReparacionesEntity;
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
/*
    @GetMapping("/{patente}")
    public ResponseEntity<List<HistorialReparacionesEntity>> getHistorialReparacionesByPatente(@PathVariable String patente) {
        List<HistorialReparacionesEntity> reparaciones = historialReparacionesService.getHistorialReparacionesByPatente(patente);
        return ResponseEntity.ok(reparaciones);
    }

 */


    @GetMapping("/{id}")
    public HistorialReparacionesEntity getHistorialReparacionesById(@PathVariable Long id) {
        HistorialReparacionesEntity reparaciones = historialReparacionesService.getHistorialAutoById(id);
        return ResponseEntity.ok(reparaciones).getBody();
    }



    @PostMapping("/")
    public ResponseEntity<HistorialReparacionesEntity> saveHistorial(@RequestBody HistorialReparacionesEntity historial) {
        HistorialReparacionesEntity historialNew = historialReparacionesService.saveHistorialReparaciones(historial);
        return ResponseEntity.ok(historialNew);
    }

    @PutMapping("/")
    public ResponseEntity<HistorialReparacionesEntity> updateHistorial(@RequestBody HistorialReparacionesEntity historial){
        HistorialReparacionesEntity historialUpdated = historialReparacionesService.updateHistorial(historial);
        return ResponseEntity.ok(historialUpdated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteHistorialById(@PathVariable Long id) throws Exception {
        var isDeleted = historialReparacionesService.deleteHistorial(id);
        return ResponseEntity.noContent().build();
    }


    /*
    @GetMapping("/calculate")
    public ResponseEntity<Void> calculatehistorial() {
        historialReparacionesService.calcularMontoTotalPagar();
        return ResponseEntity.noContent().build();
    }

     */

    //http://localhost:8090/api/historialreparaciones/calculate?patente=CFYF55
    @GetMapping("/calculate")
    public ResponseEntity<Void> calculatehistorial(@RequestParam("patente") String patente) {
        historialReparacionesService.calcularMontoTotalPagar(patente);
        return ResponseEntity.noContent().build();
    }




/*
    @GetMapping("/calculate")
    public ResponseEntity<Void> calculatePaychecks(@RequestParam("year") int year, @RequestParam("month") int month) {
        paycheckService.calculatePaychecks(year, month);
        return ResponseEntity.noContent().build();
    }

 */
    //http://localhost:8090/api/historialreparaciones/reporte/reparaciones-vs-tipo-autos
    @GetMapping("/reporte/reparaciones-vs-tipo-autos")
    public List<ReparacionesvsTipoAutos> getReporteReparacionesvsTipoAutos() {
        return historialReparacionesService.reporteReparacionesvsTipoAutos();
    }

    //http://localhost:8090/api/historialreparaciones/reporte/reparaciones-vs-tipo-motores
    @GetMapping("/reporte/reparaciones-vs-tipo-motores")
    public List<ReparacionesvsTipoMotor> getReporteReparacionesvsTipoMotor() {
        return historialReparacionesService.reporteReparacionesvsTipoMotor();
    }

    @GetMapping("/reporte/marcas-vs-tiempo-promedio")
    public List<TiemposPromedio> getReporteMarcasvsTiempoReparacion() {
        return historialReparacionesService.reporteTiempoPromedioReparacion();
    }

}
