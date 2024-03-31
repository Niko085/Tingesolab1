package com.example.Gestor.de.reparaciones.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "descuentos_dia_atencion")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DescuentoDiaAtencion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Long id;

    //@Column(name = "dia_semana")
    private String diaSemana;

    //@Column(name = "hora_inicio")
    private String horaInicio;

    //@Column(name = "hora_fin")
    private String horaFin;

    //@Column(name = "porcentaje_descuento")
    private double porcentajeDescuento;
}
