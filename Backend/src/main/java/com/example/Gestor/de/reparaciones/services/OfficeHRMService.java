package com.example.Gestor.de.reparaciones.services;

import com.example.Gestor.de.reparaciones.entities.AutomovilEntity;
import com.example.Gestor.de.reparaciones.entities.HistorialReparacionesEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Date;

@Service
public class OfficeHRMService {
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























    public double getDescuentoCantidadReparaciones(AutomovilEntity automovil){
        int cantidadReparaciones = automovil.getCantReparaciones();
        String tipoMotor = automovil.getMotor();
        double porcentajeRecargo = 0.0;
        if (cantidadReparaciones >= 1 && cantidadReparaciones <= 2){
            if(tipoMotor.equals("Gasolina")){
                porcentajeRecargo = 0.95;
            }else if(tipoMotor.equals("Diesel")){
                porcentajeRecargo = 0.93;
            }else if(tipoMotor.equals("Hibrido")){
                porcentajeRecargo = 0.9;
            }else if(tipoMotor.equals("Electrico")){
                porcentajeRecargo = 0.92;
            }
        }else if (cantidadReparaciones >= 3 && cantidadReparaciones <= 5){
            if(tipoMotor.equals("Gasolina")){
                porcentajeRecargo = 0.9;
            }else if(tipoMotor.equals("Diesel")){
                porcentajeRecargo = 0.88;
            }else if(tipoMotor.equals("Hibrido")){
                porcentajeRecargo = 0.85;
            }else if(tipoMotor.equals("Electrico")){
                porcentajeRecargo = 0.87;
            }
        }else if (cantidadReparaciones >= 6 && cantidadReparaciones <= 9){
            if(tipoMotor.equals("Gasolina")){
                porcentajeRecargo = 0.85;
            }else if(tipoMotor.equals("Diesel")){
                porcentajeRecargo = 0.83;
            }else if(tipoMotor.equals("Hibrido")){
                porcentajeRecargo = 0.8;
            }else if(tipoMotor.equals("Electrico")){
                porcentajeRecargo = 0.82;
            }
        }else if (cantidadReparaciones >= 10){
            if(tipoMotor.equals("Gasolina")){
                porcentajeRecargo = 0.8;
            }else if(tipoMotor.equals("Diesel")){
                porcentajeRecargo = 0.78;
            }else if(tipoMotor.equals("Hibrido")){
                porcentajeRecargo = 0.75;
            }else if(tipoMotor.equals("Electrico")){
                porcentajeRecargo = 0.77;
            }
        }
        return porcentajeRecargo;
    }
}
