package com.example.Gestor.de.reparaciones.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Table(name = "descuentos")
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DescuentoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String tipo_descuento;
    int cant_reparaciones_min;
    int cant_reparaciones_max;
    String marca_vehiculo;
    String tipo_motor;
    int cantidad_bonos;
    int monto_bono;
    Date dia_inicio_descuento;
    Date dia_fin_descuento;
    double porcentaje_descuento;
}
