package com.example.Gestor.de.reparaciones.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Table(name = "descuentos")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DescuentoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id;

    //tipo de descuento
    private String tipoDescuento;

    //Descuento por número de reparaciones//
    //Rango en enteros mayores a 0
    private int rangoCantidadReparcionesMinimo;
    private int rangoCantidadReparcionesMaximo;

    private double gasolina;
    private double diesel;
    private double hibrido;
    private double electrico;

    //Descuento por bonos
    //Monto de bono Ej: 70000
    private int bonoToyota;
    private int bonoFord;
    private int bonoHyundai;
    private int bonoHonda;

    //Cantidad de bonos que se entregan
    private int cantidadBonosToyota;
    private int cantidadBonosFord;
    private int cantidadBonosHyundai;
    private int cantidadBonosHonda;


    //Descuento por día de atención
    private Date diaInicioDescuento;
    private Date diaFinDescuento;
    private double porcentajeDescuentoDia;
    //Falta hora inicio y hora de finalización

}