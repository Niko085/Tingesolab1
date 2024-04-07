package com.example.Gestor.de.reparaciones.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "detalle_descuento")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DetalleDescuento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    Long id;

    //Foraneas
    int id_detalle;
    int id_descuento;
}
