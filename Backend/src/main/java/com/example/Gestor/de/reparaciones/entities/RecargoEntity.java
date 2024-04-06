package com.example.Gestor.de.reparaciones.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "recargos")
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
//Falta recargo por atraso
public class RecargoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    Long id;

    String tipo_recargo;
    int rango_antiguedad_minimo;
    int rango_antiguedad_maximo;
    int rango_kilometraje_minimo;
    int rango_kilometraje_maximo;
    String tipo_vehiculo;
    double porcentaje_recargo;

}
