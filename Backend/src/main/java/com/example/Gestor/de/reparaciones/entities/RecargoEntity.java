package com.example.Gestor.de.reparaciones.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "recargos")
@Data
@NoArgsConstructor
@AllArgsConstructor
//Falta recargo por atraso
public class RecargoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id;

    //Tipo de recargo
    private String tipoRecargo;

    //Rangos de recargo por antiguedad
    //En años
    private int rangoAntiguedadMinimo;
    private int rangoAntiguedadMaximo;

    //Rangos de recargo por kilometraje
    //En kilometros
    private int rangoKilometrajeMinimo;
    private int rangoKilometrajeMaximo;

    //Porcentajes de recargo dependiendo del tipo de vehiculo
    private double porcentajeSedan;
    private double porcentajeHatchback;
    private double porcentajeSuv;
    private double porcentajePickup;
    private double porcentajeFurgoneta;

    //Recargo por retraso en recogida del vehiculo
    private double PorcentajePorRetraso;

}
