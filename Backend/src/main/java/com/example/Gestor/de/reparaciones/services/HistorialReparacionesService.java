package com.example.Gestor.de.reparaciones.services;

import com.example.Gestor.de.reparaciones.entities.AutomovilEntity;
import com.example.Gestor.de.reparaciones.entities.HistorialReparacionesEntity;
import com.example.Gestor.de.reparaciones.entities.ReparacionEntity;
import com.example.Gestor.de.reparaciones.repositories.HistorialReparacionesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
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
    @Autowired
    ValorReparacionesService valorReparacionesService;

    public ArrayList<HistorialReparacionesEntity> getHistorialReparaciones() {
        return (ArrayList<HistorialReparacionesEntity>) historialReparacionesRepository.findAll();
    }

    public HistorialReparacionesEntity saveHistorialReparaciones(HistorialReparacionesEntity historialReparaciones) {
        return historialReparacionesRepository.save(historialReparaciones);
    }

    public List<HistorialReparacionesEntity> getHistorialReparacionesByPatente(String patente) {
        return historialReparacionesRepository.findByPatente(patente);
    }

    public HistorialReparacionesEntity getHistorialReparacionesNoPagadasByPatente(String patente) {
        return historialReparacionesRepository.findByPatenteAndAndPagadoIsFalse(patente);
    }

    public HistorialReparacionesEntity getHistorialAutoByPatente(String patente){
        return historialReparacionesRepository.findHistorialByPatente(patente);
    }


    //Función modificada para que calcule el monto total a pagar de un auto en particular, en un historial ya creado
    public Boolean calcularMontoTotalPagar(String patente) {
        double montoTotal = 0;

        //Buscar historiales por patente
        List<HistorialReparacionesEntity> historiales = historialReparacionesRepository.findByPatente(patente);

        //Buscar automovil por patente
        AutomovilEntity automovil = automovilService.getAutomovilByPatente(patente);
        String tipoMotor = automovil.getMotor();

        // Buscar el historial existente por patente que esté sin pagar
        HistorialReparacionesEntity historial = historialReparacionesRepository.findByPatenteAndAndPagadoIsFalse(patente);
        long idhistorial = historial.getId();
        List<ReparacionEntity> reparaciones = reparacionService.getReparacionByIdHistorialReparaciones(idhistorial);

        //Calculo del monto de reparaciones, sin descuentos, recargos ni iva
        for (ReparacionEntity reparacion : reparaciones) {
            montoTotal += valorReparacionesService.getMonto(reparacion.getTipoReparacion(), tipoMotor);
        }


        //Descuentos
        double descuentoDia = (officeHRMService.getPorcentajeDescuentoDia(historial.getFechaIngresoTaller(), historial.getHoraIngresoTaller()) * montoTotal);
        double descuentoCantidadReparaciones = (officeHRMService.getDescuentoCantidadReparaciones(automovil,encontrarReparacionesPorFecha(historiales)))* montoTotal;
        int descuentoPorBonos = officeHRMService.getMontoDescuentoBonos(automovil);
        double descuentos = descuentoDia + descuentoCantidadReparaciones + descuentoPorBonos;


        //Recargos
        //historial.setRecargos(recargoAntiguedad);
        double recargoKilometraje = officeHRMService.getPorcentajeRecargoKilometraje(automovil) * montoTotal;
        double recargoAntiguedad = officeHRMService.getPorcentajeRecargoAntiguedad(automovil) * montoTotal;
        double recargoRetraso = officeHRMService.getPorcentajeRecargoRetraso(historial) * montoTotal;
        double recargos = recargoAntiguedad + recargoKilometraje + recargoRetraso;

        double iva = (montoTotal + recargos - descuentos) * 0.19;

        //Setters de nuevos valores
        historial.setRecargos(recargos);
        historial.setDescuentos(descuentos);
        historial.setIva(iva);
        historial.setMontoTotalPagar((montoTotal + recargos - descuentos) + iva);
        historial.setPagado(true);

        // Guardar o actualizar el historial en la base de datos
        historialReparacionesRepository.save(historial);
        return true;
    }


    public int encontrarReparacionesPorFecha(List<HistorialReparacionesEntity> historialReparaciones){
        int cantidad = 0;
        //Fecha actual
        LocalDate fechaActual = LocalDate.now();
        //La fecha actual, pero hace 1 año
        LocalDate fechaHace12Meses = fechaActual.minus(12, ChronoUnit.MONTHS);

        for (HistorialReparacionesEntity historialReparacion : historialReparaciones){
            if((historialReparacion.getFechaIngresoTaller()).isAfter(fechaHace12Meses) || (historialReparacion.getFechaIngresoTaller()).isEqual(fechaHace12Meses)){
                cantidad += reparacionService.contarReparacionesPorHistorial(historialReparacion.getId());
            }
        }
        return cantidad;
    }
}
