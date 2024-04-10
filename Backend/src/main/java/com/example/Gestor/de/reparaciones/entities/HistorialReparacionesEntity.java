package com.example.Gestor.de.reparaciones.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;

@Entity
@Table(name = "historialReparaciones")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class HistorialReparacionesEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id;
    private Date fechaIngresoTaller;
    private LocalTime horaIngresoTaller;

    //private String tipo_reparacion;

    private double montoTotalPagar;
    private Date fechaSalidaTaller;
    private LocalTime horaSalidaTaller;
    private Date fechaClienteSeLlevaVehiculo;
    private LocalTime horaClienteSeLlevaVehiculo;

    //Foranea
    private String patente;
}
