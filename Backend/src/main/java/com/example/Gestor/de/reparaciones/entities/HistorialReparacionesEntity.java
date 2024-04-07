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
    private Date fecha_ingreso_al_taller;
    private LocalTime hora_ingreso_al_taller;

    //private String tipo_reparacion;

    private int monto_total_reparacion;
    private Date fecha_salida_del_taller;
    private LocalDate hora_salida_del_taller;
    private Date fecha_cliente_se_lleva_vehiculo;
    private LocalTime hora_cliente_se_lleva_vehiculo;

    //Foranea
    private String patente;
}
