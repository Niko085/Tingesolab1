package com.example.Gestor.de.reparaciones.services;

import com.example.Gestor.de.reparaciones.entities.AutomovilEntity;
import com.example.Gestor.de.reparaciones.entities.HistorialReparacionesEntity;
import com.example.Gestor.de.reparaciones.entities.ReparacionAutoEntity;
import com.example.Gestor.de.reparaciones.repositories.HistorialReparacionesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class HistorialReparacionesService {
    @Autowired
    HistorialReparacionesRepository historialReparacionesRepository;
    @Autowired
    AutomovilService automovilService;
    @Autowired
    OfficeHRMService officeHRMService;
    @Autowired
    ReparacionService reparacionService;

    public ArrayList<HistorialReparacionesEntity> getHistorialReparaciones() {
        return (ArrayList<HistorialReparacionesEntity>) historialReparacionesRepository.findAll();
    }

    public HistorialReparacionesEntity saveHistorialReparaciones(HistorialReparacionesEntity historialReparaciones) {
        return historialReparacionesRepository.save(historialReparaciones);
    }

    public List<HistorialReparacionesEntity> getHistorialReparacionesByPatente(String patente) {
        return historialReparacionesRepository.findByPatente(patente);
    }

    public HistorialReparacionesEntity getHistorialAutoByPatente(String patente){
        return historialReparacionesRepository.findHistorialByPatente(patente);
    }



    /*
        public Boolean calcularMontoTotalPagar(String patente){
            //Obtener lista de autos
            List<AutomovilEntity> automoviles = automovilService.getAutomoviles();

            //Obtener lista de reparaciones
            List<ReparacionEntity> reparaciones = reparacionService.getReparacionesByPatente(patente);
            double cant = reparacionService.sumReparacionesByPatente(patente);
            //Iteración sobre la lista de autos
            for(AutomovilEntity automovil : automoviles){
                //Crear historial para cada automovil
                HistorialReparacionesEntity historialReparaciones = new HistorialReparacionesEntity();

                //Asignar valores a cada historial de cobro
                historialReparaciones.setPatente(automovil.getPatente());


                //Calcular recargos
                //Calcular bonificaciones

                //Calculo y insertar total
                historialReparaciones.setMontoTotalPagar(cant);

                //Guardar
                historialReparacionesRepository.save(historialReparaciones);
            }
            return true;
        }

     */
    /*
    public Boolean calcularMontoTotalPagar(String patenten) {
        // Obtener todas las reparaciones
        List<ReparacionEntity> reparaciones = reparacionService.getReparaciones();

        // Calcular y guardar el monto total por patente en el historial de reparaciones
        for (ReparacionEntity reparacion : reparaciones) {
            String patente = reparacion.getPatente();
            double monto = reparacion.getMonto();

            // Obtener el historial de reparaciones para la patente actual
            List<HistorialReparacionesEntity> historiales = historialReparacionesRepository.findAll();

            for (HistorialReparacionesEntity historial : historiales) {
                if (historial.getPatente().equals(patente)) {
                    // Actualizar el monto total sumando el monto actual
                    double montoTotal = historial.getMontoTotalPagar() + monto;
                    historial.setMontoTotalPagar(montoTotal);

                    // Guardar el historial actualizado en la base de datos
                    historialReparacionesRepository.save(historial);
                }
            }
        }

        return true;
    }

     */
/*
    public Boolean calcularMontoTotalPagar() {
        // Obtener todos los automóviles
        List<AutomovilEntity> automoviles = automovilService.getAutomoviles();

        // Iterar sobre cada automóvil
        for (AutomovilEntity automovil : automoviles) {
            // Obtener las reparaciones asociadas a este automóvil
            List<ReparacionEntity> reparaciones = reparacionService.getReparacionesByPatente(automovil.getPatente());

            // Calcular la suma de los montos de las reparaciones
            double montoTotal = 0;
            for (ReparacionEntity reparacion : reparaciones) {
                montoTotal += reparacion.getMonto();
            }
            // Obtener el historial de reparaciones asociado a este automóvil
            List<HistorialReparacionesEntity> historiales = historialReparacionesRepository.findByPatente(automovil.getPatente());

            // Si no hay historial para este automóvil, crear uno nuevo
            HistorialReparacionesEntity historial;
            if (historiales.isEmpty()) {
                historial = new HistorialReparacionesEntity();
                historial.setPatente(automovil.getPatente());
            } else {
                historial = historiales.get(0); // Obtener el primer historial encontrado
            }
            // Actualizar el monto total en el historial
            historial.setMontoTotalPagar(montoTotal);

            // Guardar el historial (o actualizarlo)
            historialReparacionesRepository.save(historial);
        }

        return true;
    }



 */

    //Función modificada para que caLcule el monto total a pagar de un auto en particular, en un historial ya creado
    public Boolean calcularMontoTotalPagar(String patente) {
        double montoTotal = 0;

        List<ReparacionAutoEntity> reparaciones = reparacionService.getReparacionesByPatente(patente);

        for (ReparacionAutoEntity reparacion : reparaciones) {
            montoTotal += reparacion.getMonto();
        }

        // Buscar el historial existente por patente
        HistorialReparacionesEntity historial = historialReparacionesRepository.findHistorialByPatente(patente);
        AutomovilEntity automovil = automovilService.getAutomovilByPatente(patente);

        historial.setMontoTotalPagar(montoTotal);
        double recargoKilometraje = officeHRMService.getPorcentajeRecargoKilometraje(automovil) * montoTotal;
        double recargoAntiguedad = officeHRMService.getPorcentajeRecargoAntiguedad(automovil)* montoTotal;
        historial.setDescuentos(10);
        //historial.setRecargos(recargoKilometraje);
        historial.setRecargos(recargoAntiguedad);
        historial.setRecargos(recargoAntiguedad + recargoKilometraje);
        historial.setIva(1.19);

        // Guardar o actualizar el historial en la base de datos
        historialReparacionesRepository.save(historial);
        return true;
    }



}

















