package com.example.Gestor.de.reparaciones.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "descuentos_bonos")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DescuentoBonosEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id;

    //@Column(name = "marca_vehiculo")
    private String marcaVehiculo;

    //@Column(name = "numero_bonos")
    private int numeroBonos;

    //@Column(name = "monto_bono")
    private double montoBono;
}
