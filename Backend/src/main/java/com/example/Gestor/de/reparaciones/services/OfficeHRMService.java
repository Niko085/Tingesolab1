package com.example.Gestor.de.reparaciones.services;

import com.example.Gestor.de.reparaciones.entities.AutomovilEntity;
import com.example.Gestor.de.reparaciones.entities.DatosBonosEntity;
import com.example.Gestor.de.reparaciones.entities.HistorialReparacionesEntity;
import com.example.Gestor.de.reparaciones.entities.ReparacionAutoEntity;
import com.example.Gestor.de.reparaciones.repositories.DatosBonosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.List;

@Service
public class OfficeHRMService {
    @Autowired
    private DatosBonosService datosBonosService;

    public double getPorcentajeRecargoKilometraje(AutomovilEntity automovil){
        int kilometraje = automovil.getKilometraje();
        String tipoAuto = automovil.getTipo();
        double porcentajeRecargo = 0.0;
        if (kilometraje >= 0 && kilometraje <= 5000){
            if(tipoAuto.equals("Sedan")){
                porcentajeRecargo = 0;
            }else if(tipoAuto.equals("Hatchback")){
                porcentajeRecargo = 0;
            }else if(tipoAuto.equals("SUV")){
                porcentajeRecargo = 0;
            }else if(tipoAuto.equals("Pickup")){
                porcentajeRecargo = 0;
            }else if(tipoAuto.equals("Furgoneta")){
                porcentajeRecargo = 0;
            }
        }else if (kilometraje >= 5001 && kilometraje <= 12000){
            if(tipoAuto.equals("Sedan")){
                porcentajeRecargo = 0.03;
            }else if(tipoAuto.equals("Hatchback")){
                porcentajeRecargo = 0.03;
            }else if(tipoAuto.equals("SUV")){
                porcentajeRecargo = 0.05;
            }else if(tipoAuto.equals("Pickup")){
                porcentajeRecargo = 0.05;
            }else if(tipoAuto.equals("Furgoneta")){
                porcentajeRecargo = 0.05;
            }
        }else if (kilometraje >= 12001 && kilometraje <= 25000){
            if(tipoAuto.equals("Sedan")){
                porcentajeRecargo = 0.07;
            }else if(tipoAuto.equals("Hatchback")){
                porcentajeRecargo = 0.07;
            }else if(tipoAuto.equals("SUV")){
                porcentajeRecargo = 0.09;
            }else if(tipoAuto.equals("Pickup")){
                porcentajeRecargo = 0.09;
            }else if(tipoAuto.equals("Furgoneta")){
                porcentajeRecargo = 0.09;
            }
        }else if (kilometraje >= 25001 && kilometraje <= 40000){
            if(tipoAuto.equals("Sedan")){
                porcentajeRecargo = 0.12;
            }else if(tipoAuto.equals("Hatchback")){
                porcentajeRecargo = 0.12;
            }else if(tipoAuto.equals("SUV")){
                porcentajeRecargo = 0.12;
            }else if(tipoAuto.equals("Pickup")){
                porcentajeRecargo = 0.12;
            }else if(tipoAuto.equals("Furgoneta")){
                porcentajeRecargo = 0.12;
            }
        }else if (kilometraje >= 40001){
            if(tipoAuto.equals("Sedan")){
                porcentajeRecargo = 0.2;
            }else if(tipoAuto.equals("Hatchback")){
                porcentajeRecargo = 0.2;
            }else if(tipoAuto.equals("SUV")){
                porcentajeRecargo = 0.2;
            }else if(tipoAuto.equals("Pickup")){
                porcentajeRecargo = 0.2;
            }else if(tipoAuto.equals("Furgoneta")){
                porcentajeRecargo = 0.2;
            }
        }
        return porcentajeRecargo;
    }


    public double getPorcentajeRecargoAntiguedad(AutomovilEntity automovil){
        int edad = 2024 - automovil.getAnioFabricacion();
        String tipoAuto = automovil.getTipo();
        double porcentajeRecargo = 0.0;
        if (edad >= 0 && edad <= 5){
            if(tipoAuto.equals("Sedan")){
                porcentajeRecargo = 0;
            }else if(tipoAuto.equals("Diesel")){
                porcentajeRecargo = 0;
            }else if(tipoAuto.equals("Hatchback")){
                porcentajeRecargo = 0;
            }else if(tipoAuto.equals("Pickup")){
                porcentajeRecargo = 0;
            }else if(tipoAuto.equals("Furgoneta")){
                porcentajeRecargo = 0;
            }
        }else if (edad >= 6 && edad <= 10){
            if(tipoAuto.equals("Sedan")){
                porcentajeRecargo = 0.05;
            }else if(tipoAuto.equals("Diesel")){
                porcentajeRecargo = 0.05;
            }else if(tipoAuto.equals("Hatchback")){
                porcentajeRecargo = 0.07;
            }else if(tipoAuto.equals("Pickup")){
                porcentajeRecargo = 0.07;
            }else if(tipoAuto.equals("Furgoneta")){
                porcentajeRecargo = 0.07;
            }
        }else if (edad >= 11 && edad <= 15){
            if(tipoAuto.equals("Sedan")){
                porcentajeRecargo = 0.09;
            }else if(tipoAuto.equals("Diesel")){
                porcentajeRecargo = 0.09;
            }else if(tipoAuto.equals("Hatchback")){
                porcentajeRecargo = 0.11;
            }else if(tipoAuto.equals("Pickup")){
                porcentajeRecargo = 0.11;
            }else if(tipoAuto.equals("Furgoneta")){
                porcentajeRecargo = 0.11;
            }
        }else if (edad >= 16){
            if(tipoAuto.equals("Sedan")){
                porcentajeRecargo = 0.15;
            }else if(tipoAuto.equals("Diesel")){
                porcentajeRecargo = 0.15;
            }else if(tipoAuto.equals("Hatchback")){
                porcentajeRecargo = 0.2;
            }else if(tipoAuto.equals("Pickup")){
                porcentajeRecargo = 0.2;
            }else if(tipoAuto.equals("Furgoneta")){
                porcentajeRecargo = 0.2;
            }
        }
        return porcentajeRecargo;
    }


    public double getPorcentajeRecargoRetraso(HistorialReparacionesEntity historialReparaciones){
        LocalDate fechasSalida = historialReparaciones.getFechaSalidaTaller();
        LocalDate fechaRetirada = historialReparaciones.getFechaClienteSeLlevaVehiculo();

        //Calcular diferencia entre fechas
        long diferenciaEnDias = ChronoUnit.DAYS.between(fechasSalida, fechaRetirada);

        //Si hay retraso, calcular el recargo
        double recargo = 0;
        if (diferenciaEnDias > 0) {
            recargo = 0.05 * diferenciaEnDias; // 5% del monto total por cada día de retraso
        }
        return recargo;
    }


    public double getPorcentajeDescuentoDia(LocalDate fechaEntrada, LocalTime horaEntrada){
        DayOfWeek diaDeLaSemana = fechaEntrada.getDayOfWeek();
        int horaDeEntrada = horaEntrada.getHour();

        //Verificar día de la semana
        if((diaDeLaSemana == DayOfWeek.MONDAY || diaDeLaSemana == DayOfWeek.THURSDAY) && (horaDeEntrada >= 9 && horaDeEntrada < 12)){
            return 0.1;
        }
        else{
            return 0;
        }
    }



    public double getDescuentoCantidadReparaciones(AutomovilEntity automovil, int cantidadReparaciones){
        String tipoMotor = automovil.getMotor();
        double porcentajeRecargo = 0.0;
        if (cantidadReparaciones >= 1 && cantidadReparaciones <= 2){
            if(tipoMotor.equals("Gasolina")){
                porcentajeRecargo = 0.05;
            }else if(tipoMotor.equals("Diesel")){
                porcentajeRecargo = 0.07;
            }else if(tipoMotor.equals("Hibrido")){
                porcentajeRecargo = 0.1;
            }else if(tipoMotor.equals("Electrico")){
                porcentajeRecargo = 0.08;
            }
        }else if (cantidadReparaciones >= 3 && cantidadReparaciones <= 5){
            if(tipoMotor.equals("Gasolina")){
                porcentajeRecargo = 0.1;
            }else if(tipoMotor.equals("Diesel")){
                porcentajeRecargo = 0.12;
            }else if(tipoMotor.equals("Hibrido")){
                porcentajeRecargo = 0.15;
            }else if(tipoMotor.equals("Electrico")){
                porcentajeRecargo = 0.13;
            }
        }else if (cantidadReparaciones >= 6 && cantidadReparaciones <= 9){
            if(tipoMotor.equals("Gasolina")){
                porcentajeRecargo = 0.15;
            }else if(tipoMotor.equals("Diesel")){
                porcentajeRecargo = 0.17;
            }else if(tipoMotor.equals("Hibrido")){
                porcentajeRecargo = 0.2;
            }else if(tipoMotor.equals("Electrico")){
                porcentajeRecargo = 0.18;
            }
        }else if (cantidadReparaciones >= 10){
            if(tipoMotor.equals("Gasolina")){
                porcentajeRecargo = 0.2;
            }else if(tipoMotor.equals("Diesel")){
                porcentajeRecargo = 0.22;
            }else if(tipoMotor.equals("Hibrido")){
                porcentajeRecargo = 0.25;
            }else if(tipoMotor.equals("Electrico")){
                porcentajeRecargo = 0.23;
            }
        }
        return porcentajeRecargo;
    }

    public int getMontoDescuentoBonos(AutomovilEntity automovil){
        String marca = automovil.getMarca();
        DatosBonosEntity datosBono = datosBonosService.getDatosBonosByMarca(marca);
        if(datosBono.getCantidadBonos()>0){
            datosBono.setCantidadBonos(datosBono.getCantidadBonos()-1);
            return datosBono.getMontoBono();
        }else return 0;
    }




}
