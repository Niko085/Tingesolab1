package com.example.Gestor.de.reparaciones.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "reparaciones")
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Reparacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    Long id;

    String descripcion;
    String tipo_moto_a_reparar;
    int precio;
}
