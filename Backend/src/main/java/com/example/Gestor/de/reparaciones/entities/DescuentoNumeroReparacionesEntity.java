package com.example.Gestor.de.reparaciones.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "descuentos_numero_reparaciones")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DescuentoNumeroReparacionesEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id;

    private int rangoCantidadReparcionesMinimo;
    private int rangoCantidadReparcionesMaximo;

    //@Column(name = "numero_reparaciones")
    //private int numeroReparaciones;

    private double gasolina;
    private double diesel;
    private double hibrido;
    private double electrico;
}
