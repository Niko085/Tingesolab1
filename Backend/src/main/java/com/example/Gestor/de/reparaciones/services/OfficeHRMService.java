package com.example.Gestor.de.reparaciones.services;

import com.example.Gestor.de.reparaciones.entities.AutomovilEntity;
import com.example.Gestor.de.reparaciones.entities.HistorialReparacionesEntity;
import org.springframework.stereotype.Service;

@Service
public class OfficeHRMService {
/*
    public void aplicarRecargo(HistorialReparacionesEntity historialReparaciones, AutomovilEntity automovil){
        double recargo = aplicarRecargoKilometraje(automovil);
        int montoTotalReparacion = historialReparaciones.getMontoTotalReparacion();
        int nuevoMontoTotalReparacion = (int) (montoTotalReparacion * (1 + recargo));
        historialReparaciones.setMontoTotalReparacion(nuevoMontoTotalReparacion);
    }

    //falta poner el resultado en el monto total del auto
    public double aplicarRecargoKilometraje(AutomovilEntity automovil){
        int kilometraje = automovil.getKilometraje();
        String tipoAuto = automovil.getTipo();
        if (kilometraje >= 0 && kilometraje <= 5000){
            if(tipoAuto.equals("Sedan")){
                return 1;
            }else if(tipoAuto.equals("Hatchback")){
                return 1;
            }else if(tipoAuto.equals("SUV")){
                return 1;
            }else if(tipoAuto.equals("Pickup")){
                return 1;
            }else if(tipoAuto.equals("Furgoneta")){
                return 1;
            }
        }else if (kilometraje >= 5001 && kilometraje <= 12000){
            if(tipoAuto.equals("Sedan")){
                return 1.03;
            }else if(tipoAuto.equals("Hatchback")){
                return  1.03;
            }else if(tipoAuto.equals("SUV")){
                return 1.05;
            }else if(tipoAuto.equals("Pickup")){
                return 1.05;
            }else if(tipoAuto.equals("Furgoneta")){
                return 1.05;
            }
        }else if (kilometraje >= 12001 && kilometraje <= 25000){
            if(tipoAuto.equals("Sedan")){
                return 1.07;
            }else if(tipoAuto.equals("Hatchback")){
                return 1.07;
            }else if(tipoAuto.equals("SUV")){
                return 1.09;
            }else if(tipoAuto.equals("Pickup")){
                return 1.09;
            }else if(tipoAuto.equals("Furgoneta")){
                return 1.09;
            }
        }else if (kilometraje >= 25001 && kilometraje <= 40000){
            if(tipoAuto.equals("Sedan")){
                return 1.12;
            }else if(tipoAuto.equals("Hatchback")){
                return 1.12;
            }else if(tipoAuto.equals("SUV")){
                return 1.12;
            }else if(tipoAuto.equals("Pickup")){
                return 1.12;
            }else if(tipoAuto.equals("Furgoneta")){
                return 1.12;
            }
        }else if (kilometraje >= 40001){
            if(tipoAuto.equals("Sedan")){
                return 1.2;
            }else if(tipoAuto.equals("Hatchback")){
                return 1.2;
            }else if(tipoAuto.equals("SUV")){
                return 1.2;
            }else if(tipoAuto.equals("Pickup")){
                return 1.2;
            }else if(tipoAuto.equals("Furgoneta")){
                return 1.2;
            }
        }
        return 0;
    }

 */

















    public void aplicarRecargoKilometraje(AutomovilEntity automovil, HistorialReparacionesEntity historialReparaciones){
        int kilometraje = automovil.getKilometraje();
        String tipoAuto = automovil.getTipo();
        int montoTotalReparacion = historialReparaciones.getMontoTotalReparacion();
        double porcentajeRecargo = 0.0;

        if (kilometraje >= 0 && kilometraje <= 5000){
            if(tipoAuto.equals("Sedan")){
                porcentajeRecargo = 1;
            }else if(tipoAuto.equals("Hatchback")){
                porcentajeRecargo = 1;
            }else if(tipoAuto.equals("SUV")){
                porcentajeRecargo = 1;
            }else if(tipoAuto.equals("Pickup")){
                porcentajeRecargo = 1;
            }else if(tipoAuto.equals("Furgoneta")){
                porcentajeRecargo = 1;
            }
        }else if (kilometraje >= 5001 && kilometraje <= 12000){
            if(tipoAuto.equals("Sedan")){
                porcentajeRecargo = 1.03;
            }else if(tipoAuto.equals("Hatchback")){
                porcentajeRecargo = 1.03;
            }else if(tipoAuto.equals("SUV")){
                porcentajeRecargo = 1.05;
            }else if(tipoAuto.equals("Pickup")){
                porcentajeRecargo = 1.05;
            }else if(tipoAuto.equals("Furgoneta")){
                porcentajeRecargo = 1.05;
            }
        }else if (kilometraje >= 12001 && kilometraje <= 25000){
            if(tipoAuto.equals("Sedan")){
                porcentajeRecargo = 1.07;
            }else if(tipoAuto.equals("Hatchback")){
                porcentajeRecargo = 1.07;
            }else if(tipoAuto.equals("SUV")){
                porcentajeRecargo = 1.09;
            }else if(tipoAuto.equals("Pickup")){
                porcentajeRecargo = 1.09;
            }else if(tipoAuto.equals("Furgoneta")){
                porcentajeRecargo = 1.09;
            }
        }else if (kilometraje >= 25001 && kilometraje <= 40000){
            if(tipoAuto.equals("Sedan")){
                porcentajeRecargo = 1.12;
            }else if(tipoAuto.equals("Hatchback")){
                porcentajeRecargo = 1.12;
            }else if(tipoAuto.equals("SUV")){
                porcentajeRecargo = 1.12;
            }else if(tipoAuto.equals("Pickup")){
                porcentajeRecargo = 1.12;
            }else if(tipoAuto.equals("Furgoneta")){
                porcentajeRecargo = 1.12;
            }
        }else if (kilometraje >= 40001){
            if(tipoAuto.equals("Sedan")){
                porcentajeRecargo = 1.2;
            }else if(tipoAuto.equals("Hatchback")){
                porcentajeRecargo = 1.2;
            }else if(tipoAuto.equals("SUV")){
                porcentajeRecargo = 1.2;
            }else if(tipoAuto.equals("Pickup")){
                porcentajeRecargo = 1.2;
            }else if(tipoAuto.equals("Furgoneta")){
                porcentajeRecargo = 1.2;
            }
        }

        int nuevoMontoTotalReparacion = (int) (montoTotalReparacion * porcentajeRecargo);
        historialReparaciones.setMontoTotalReparacion(nuevoMontoTotalReparacion);
    }
























    public double aplicarRecargoAntiguedad(AutomovilEntity automovil){
        int edad = 2024 - automovil.getAnioFabricacion();
        String tipoAuto = automovil.getTipo();
        if (edad >= 0 && edad <= 5){
            if(tipoAuto.equals("Sedan")){
                return 1;
            }else if(tipoAuto.equals("Diesel")){
                return 1;
            }else if(tipoAuto.equals("Hatchback")){
                return 1;
            }else if(tipoAuto.equals("Pickup")){
                return 1;
            }else if(tipoAuto.equals("Furgoneta")){
                return 1;
            }
        }else if (edad >= 6 && edad <= 10){
            if(tipoAuto.equals("Sedan")){
                return 0.05;
            }else if(tipoAuto.equals("Diesel")){
                return 0.05;
            }else if(tipoAuto.equals("Hatchback")){
                return 0.07;
            }else if(tipoAuto.equals("Pickup")){
                return 0.07;
            }else if(tipoAuto.equals("Furgoneta")){
                return 0.07;
            }
        }else if (edad >= 11 && edad <= 15){
            if(tipoAuto.equals("Sedan")){
                return 0.09;
            }else if(tipoAuto.equals("Diesel")){
                return 0.09;
            }else if(tipoAuto.equals("Hatchback")){
                return 0.11;
            }else if(tipoAuto.equals("Pickup")){
                return 0.11;
            }else if(tipoAuto.equals("Furgoneta")){
                return 0.11;
            }
        }else if (edad >= 16){
            if(tipoAuto.equals("Sedan")){
                return 0.15;
            }else if(tipoAuto.equals("Diesel")){
                return 0.15;
            }else if(tipoAuto.equals("Hatchback")){
                return 0.2;
            }else if(tipoAuto.equals("Pickup")){
                return 0.2;
            }else if(tipoAuto.equals("Furgoneta")){
                return 0.2;
            }
        }
        return 0;
    }


    public double aplicarDescuentoCantidadReparaciones(AutomovilEntity automovil){
        int cantidadReparaciones = automovil.getCantReparaciones();
        String tipoMotor = automovil.getMotor();
        if (cantidadReparaciones >= 1 && cantidadReparaciones <= 2){
            if(tipoMotor.equals("Gasolina")){
                return 0.05;
            }else if(tipoMotor.equals("Diesel")){
                return 0.07;
            }else if(tipoMotor.equals("Hibrido")){
                return 0.1;
            }else if(tipoMotor.equals("Electrico")){
                return 0.08;
            }
        }else if (cantidadReparaciones >= 3 && cantidadReparaciones <= 5){
            if(tipoMotor.equals("Gasolina")){
                return 0.1;
            }else if(tipoMotor.equals("Diesel")){
                return 0.12;
            }else if(tipoMotor.equals("Hibrido")){
                return 0.15;
            }else if(tipoMotor.equals("Electrico")){
                return 0.13;
            }
        }else if (cantidadReparaciones >= 6 && cantidadReparaciones <= 9){
            if(tipoMotor.equals("Gasolina")){
                return 0.15;
            }else if(tipoMotor.equals("Diesel")){
                return 0.17;
            }else if(tipoMotor.equals("Hibrido")){
                return 0.2;
            }else if(tipoMotor.equals("Electrico")){
                return 0.18;
            }
        }else if (cantidadReparaciones >= 10){
            if(tipoMotor.equals("Gasolina")){
                return 0.2;
            }else if(tipoMotor.equals("Diesel")){
                return 0.22;
            }else if(tipoMotor.equals("Hibrido")){
                return 0.25;
            }else if(tipoMotor.equals("Electrico")){
                return 0.23;
            }
        }
        return 0;
    }
}
