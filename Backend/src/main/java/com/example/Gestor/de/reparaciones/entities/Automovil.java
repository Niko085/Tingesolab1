package com.example.Gestor.de.reparaciones.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "automoviles")
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Automovil {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    Long id;

    String patente;//Validar 4 letras y 2 numeros
    String marca;
    String modelo;
    String tipo; //Sedan, Hatchback, SUV, Pickup, Furgoneta
    int anio_fabricacion;
    String tipo_motor; //gasolina, diésel, híbrido, eléctrico
    String cant_asientos; //Poner restricciones
    int kilometraje;

}
