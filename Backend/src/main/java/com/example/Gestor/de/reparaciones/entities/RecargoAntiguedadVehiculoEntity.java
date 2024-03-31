package com.example.Gestor.de.reparaciones.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "recargos_antiguedad_vehiculo")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RecargoAntiguedadVehiculoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id;

    //@Column(name = "rango_antiguedad_minimo")
    private int rangoAntiguedadMinimo;

    //@Column(name = "rango_antiguedad_maximo")
    private int rangoAntiguedadMaximo;

    //@Column(name = "porcentaje_recargo")
    private double porcentajeRecargo;
}
