package com.example.Gestor.de.reparaciones.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Objects;

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

    private String patente;//4 letras y 2 números
    private String marca;//Toyota, Kia, Honda, Ford, Chevrolet, Hyundai, etc.
    private String modelo;
    private String tipo;//Sedan, Hatchback, SUV, Pickup, Furgoneta)
    private int anioFabricacion;
    private String motor;//gasolina, diésel, híbrido, eléctrico
    private int cantAsientos;
    private int kilometraje;



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AutomovilEntity that = (AutomovilEntity) o;
        return Objects.equals(patente, that.patente);
    }

    @Override
    public int hashCode() {
        return Objects.hash(patente);
    }
}


