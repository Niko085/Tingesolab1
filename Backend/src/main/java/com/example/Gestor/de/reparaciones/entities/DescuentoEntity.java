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
    private Long id;

    private String tipo_descuento;
    private int cant_reparaciones_min;
    private int cant_reparaciones_max;
    private String marca_vehiculo;
    private String tipo_motor;
    private int cantidad_bonos;
    private int monto_bono;
    private Date dia_inicio_descuento;
    private Date dia_fin_descuento;
    private double porcentaje_descuento;
}
