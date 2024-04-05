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

    private String tipo_recargo;
    private int rango_antiguedad_minimo;
    private int rango_antiguedad_maximo;
    private int rango_kilometraje_minimo;
    private int rango_kilometraje_maximo;
    private String tipo_vehiculo;
    private double porcentaje_recargo;

}
