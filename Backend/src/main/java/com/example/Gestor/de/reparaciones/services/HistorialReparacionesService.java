package com.example.Gestor.de.reparaciones.services;

import com.example.Gestor.de.reparaciones.dtos.ReparacionesvsTipoAutos;
import com.example.Gestor.de.reparaciones.dtos.ReparacionesvsTipoMotor;
import com.example.Gestor.de.reparaciones.entities.AutomovilEntity;
import com.example.Gestor.de.reparaciones.entities.HistorialReparacionesEntity;
import com.example.Gestor.de.reparaciones.entities.ReparacionEntity;
import com.example.Gestor.de.reparaciones.repositories.HistorialReparacionesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.*;

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

/*
    public int getCantidadTipoReparaciones(int tipoReparacion) {
        List<String> patentes = new ArrayList<>();
        Set<String> tiposAutomovil = new HashSet<>(); // Cambiamos de List a Set para evitar duplicados
        List<ReparacionEntity> reparaciones = reparacionService.getReparaciones();
        for (ReparacionEntity reparacion : reparaciones) {
            if (reparacion.getTipoReparacion() == tipoReparacion) {
                patentes.add(reparacion.getPatente());
            }
        }
        for (String patente : patentes) {
            AutomovilEntity automovil = automovilService.getAutomovilByPatente(patente);
            tiposAutomovil.add(automovil.getTipo());
        }
        return tiposAutomovil.size();
    }


 */



    public int getCantidadTipoReparaciones(int tipoReparacion) {
        List<String> tiposAutomovil = new ArrayList<>(); // Utilizamos una lista en lugar de un Set

        List<ReparacionEntity> reparaciones = reparacionService.getReparaciones();
        for (ReparacionEntity reparacion : reparaciones) {
            if (reparacion.getTipoReparacion() == tipoReparacion) {
                String patente = reparacion.getPatente();
                AutomovilEntity automovil = automovilService.getAutomovilByPatente(patente);
                String tipoAutomovil = automovil.getTipo();

                // Si el tipo de automóvil no está en la lista, lo agregamos
                if (!tiposAutomovil.contains(tipoAutomovil)) {
                    tiposAutomovil.add(tipoAutomovil);
                }
            }
        }

        return tiposAutomovil.size();
    }



    public int getMontoTipoReparaciones(int tipoReparacion) {
        List<String> tiposAutomovil = new ArrayList<>(); // Utilizamos una lista en lugar de un Set
        List<String> tiposMotor = new ArrayList<>();

        List<ReparacionEntity> reparaciones = reparacionService.getReparaciones();
        for (ReparacionEntity reparacion : reparaciones) {
            if (reparacion.getTipoReparacion() == tipoReparacion) {
                String patente = reparacion.getPatente();
                AutomovilEntity automovil = automovilService.getAutomovilByPatente(patente);
                String tipoAutomovil = automovil.getTipo();

                // Si el tipo de automóvil no está en la lista, lo agregamos
                if (!tiposAutomovil.contains(tipoAutomovil)) {
                    tiposAutomovil.add(tipoAutomovil);
                    tiposMotor.add(automovil.getMotor());
                }
            }
        }
        int sumaMontos = 0;
        for(String tipoMotor : tiposMotor){
            sumaMontos += valorReparacionesService.getMonto(tipoReparacion, tipoMotor);
        }
        return sumaMontos;
    }




/*
    public List<ReparacionesvsTipoAutos> reporteReparacionesvsTipoAutos(){
        List<ReparacionesvsTipoAutos> reparacionesvsTipoAutos = new ArrayList<>();
        int cantidadReparaciones = 0;
        int montoTotalReparaciones = 0;
        for(int tipoReparacion = 1; tipoReparacion <= 11; tipoReparacion++){
            cantidadReparaciones = getCantidadTipoReparaciones(tipoReparacion);
            montoTotalReparaciones = getMontoTipoReparaciones(tipoReparacion);
            ReparacionesvsTipoAutos reparacionPorTipoAuto = new ReparacionesvsTipoAutos(tipoReparacion, cantidadReparaciones, montoTotalReparaciones);
            reparacionesvsTipoAutos.add(reparacionPorTipoAuto);
        }
        return reparacionesvsTipoAutos;
    }

 */

    public List<ReparacionesvsTipoAutos> reporteReparacionesvsTipoAutos(){
        List<ReparacionesvsTipoAutos> reparacionesvsTipoAutos = new ArrayList<>();

        int cantidadReparaciones = 0;
        int montoTotalReparaciones = 0;

        // Obtener los datos y agregarlos a la lista
        for(int tipoReparacion = 1; tipoReparacion <= 11; tipoReparacion++){
            cantidadReparaciones = getCantidadTipoReparaciones(tipoReparacion);
            montoTotalReparaciones = getMontoTipoReparaciones(tipoReparacion);

            // Crear objeto ReparacionesvsTipoAutos y agregarlo a la lista
            ReparacionesvsTipoAutos reparacionPorTipoAuto = new ReparacionesvsTipoAutos(tipoReparacion, cantidadReparaciones, montoTotalReparaciones);
            reparacionesvsTipoAutos.add(reparacionPorTipoAuto);
        }

        // Ordenar la lista por montoTotalReparaciones de menor a mayor
        Collections.sort(reparacionesvsTipoAutos, Comparator.comparingInt(ReparacionesvsTipoAutos::getMontoTotalReparaciones));

        return reparacionesvsTipoAutos;
    }

/*
    public int getCantidadTipoMotor(int tipoReparacion, String tipoMotor) {
        List<String> patentes = new ArrayList<>();
        List<String> tiposMotor = new ArrayList<>();
        List<ReparacionEntity> reparaciones = reparacionService.getReparaciones();
        for (ReparacionEntity reparacion : reparaciones) {
            if ((reparacion.getTipoReparacion() == tipoReparacion)) {
                patentes.add(reparacion.getPatente());
            }
        }
        for (String patente : patentes) {
            AutomovilEntity automovil = automovilService.getAutomovilByPatente(patente);
            if (automovil.getMotor().equals(tipoMotor)) {
                tiposMotor.add(automovil.getMotor());
            }


        }
        return tiposMotor.size();
    }
 */

    public int getCantidadTipoMotor(int tipoReparacion, String tipoMotor) {
        int cantidad = 0;

        List<ReparacionEntity> reparaciones = reparacionService.getReparaciones();
        for (ReparacionEntity reparacion : reparaciones) {
            if (reparacion.getTipoReparacion() == tipoReparacion) {
                AutomovilEntity automovil = automovilService.getAutomovilByPatente(reparacion.getPatente());
                if (automovil != null && automovil.getMotor() != null && automovil.getMotor().equals(tipoMotor)) {
                    cantidad++;
                }
            }
        }

        return cantidad;
    }


/*
    public List<ReparacionesvsTipoMotor> reporteReparacionesvsTipoMotor(){
        List<ReparacionesvsTipoMotor> reparacionesvsTipoMotores = new ArrayList<>();
        int cantGasolina;
        int cantDiesel;
        int cantHibrido;
        int cantElectrico;
        int montoGasolina;
        int montoDiesel;
        int montoHibrido;
        int montoElectrico;
        int montoTotal;
        for(int tipoReparacion = 1; tipoReparacion <= 11; tipoReparacion++){
            cantGasolina = getCantidadTipoMotor(tipoReparacion, "Gasolina");
            montoGasolina = valorReparacionesService.getMonto(tipoReparacion, "Gasolina") * cantGasolina;
            cantDiesel = getCantidadTipoMotor(tipoReparacion, "Diesel");
            montoDiesel = valorReparacionesService.getMonto(tipoReparacion, "Diesel") * cantDiesel;
            cantHibrido = getCantidadTipoMotor(tipoReparacion, "Hibrido");
            montoHibrido = valorReparacionesService.getMonto(tipoReparacion, "Hibrido") * cantHibrido;
            cantElectrico = getCantidadTipoMotor(tipoReparacion, "Electrico");
            montoElectrico = valorReparacionesService.getMonto(tipoReparacion, "Electrico") * cantElectrico;
            montoTotal = montoGasolina + montoDiesel + montoHibrido + montoElectrico;
            ReparacionesvsTipoMotor reparacionPorTipoMotor = new ReparacionesvsTipoMotor(tipoReparacion, cantGasolina, cantDiesel, cantHibrido, cantElectrico, montoTotal);
            reparacionesvsTipoMotores.add(reparacionPorTipoMotor);
        }
        return reparacionesvsTipoMotores;
    }

 */
    public List<ReparacionesvsTipoMotor> reporteReparacionesvsTipoMotor(){
        List<ReparacionesvsTipoMotor> reparacionesvsTipoMotores = new ArrayList<>();

        // Obtener los datos y agregarlos a la lista
        for(int tipoReparacion = 1; tipoReparacion <= 11; tipoReparacion++){
            int cantGasolina = getCantidadTipoMotor(tipoReparacion, "Gasolina");
            int montoGasolina = valorReparacionesService.getMonto(tipoReparacion, "Gasolina") * cantGasolina;
            int cantDiesel = getCantidadTipoMotor(tipoReparacion, "Diesel");
            int montoDiesel = valorReparacionesService.getMonto(tipoReparacion, "Diesel") * cantDiesel;
            int cantHibrido = getCantidadTipoMotor(tipoReparacion, "Hibrido");
            int montoHibrido = valorReparacionesService.getMonto(tipoReparacion, "Hibrido") * cantHibrido;
            int cantElectrico = getCantidadTipoMotor(tipoReparacion, "Electrico");
            int montoElectrico = valorReparacionesService.getMonto(tipoReparacion, "Electrico") * cantElectrico;
            int  montoTotal = montoGasolina + montoDiesel + montoHibrido + montoElectrico;

            // Crear objeto ReparacionesvsTipoMotor y agregarlo a la lista
            ReparacionesvsTipoMotor reparacionPorTipoMotor = new ReparacionesvsTipoMotor(tipoReparacion, cantGasolina, cantDiesel, cantHibrido, cantElectrico, montoTotal);
            reparacionesvsTipoMotores.add(reparacionPorTipoMotor);
        }

        // Ordenar la lista por montoTotalReparaciones de menor a mayor
        Collections.sort(reparacionesvsTipoMotores, Comparator.comparingInt(ReparacionesvsTipoMotor::getMontoTotalReparaciones));

        return reparacionesvsTipoMotores;
    }



    /*
    public List<ReparacionesvsTipoMotor> reporteReparacionesvsTipoMotor() {
        List<ReparacionesvsTipoMotor> reparacionesvsTipoMotores = new ArrayList<>();

        for (int tipoReparacion = 1; tipoReparacion <= 11; tipoReparacion++) {
            int cantGasolina = getCantidadTipoMotor(tipoReparacion, "Gasolina");
            int montoGasolina = getMontoTipoMotor(tipoReparacion, "Gasolina") * cantGasolina;

            int cantDiesel = getCantidadTipoMotor(tipoReparacion, "Diesel");
            int montoDiesel = getMontoTipoMotor(tipoReparacion, "Diesel") * cantDiesel;

            int cantHibrido = getCantidadTipoMotor(tipoReparacion, "Hibrido");
            int montoHibrido = getMontoTipoMotor(tipoReparacion, "Hibrido") * cantHibrido;

            int cantElectrico = getCantidadTipoMotor(tipoReparacion, "Electrico");
            int montoElectrico = getMontoTipoMotor(tipoReparacion, "Electrico") * cantElectrico;

            int montoTotal = montoGasolina + montoDiesel + montoHibrido + montoElectrico;

            ReparacionesvsTipoMotor reparacionPorTipoMotor = new ReparacionesvsTipoMotor(tipoReparacion, cantGasolina, cantDiesel, cantHibrido, cantElectrico, montoTotal);
            reparacionesvsTipoMotores.add(reparacionPorTipoMotor);
        }

        return reparacionesvsTipoMotores;
    }



    private int getMontoTipoMotor(int tipoReparacion, String tipoMotor) {
        return valorReparacionesService.getMonto(tipoReparacion, tipoMotor);
    }

     */

}
