package com.example.Gestor.de.reparaciones.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "recargos_kilometraje")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RecargoKilometrajeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id;

    //@Column(name = "rango_kilometraje_minimo")
    private int rangoKilometrajeMinimo;

    //@Column(name = "rango_kilometraje_maximo")
    private int rangoKilometrajeMaximo;

    private double porcentajeSedan;
    private double porcentajeHatchback;
    private double porcentajeSuv;
    private double porcentajePickup;
    private double porcentajeFurgoneta;
}
