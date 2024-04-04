package com.example.Gestor.de.reparaciones.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "automoviles")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AutomovilEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id;

    private String patente;//Validar 4 letras y 2 numeros
    private String marca;
    private String modelo;
    private String tipo; //Sedan, Hatchback, SUV, Pickup, Furgoneta
    private int anio_fabricacion;
    private String tipo_motor; //gasolina, diésel, híbrido, eléctrico
    private String cant_asientos; //Poner restricciones

}
