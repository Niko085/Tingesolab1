package com.example.Gestor.de.reparaciones.dtos;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CrearAutomovil {
    Long id;
    String patente;//Validar 4 letras y 2 numeros
    String marca;
    String modelo;
    String tipo; //Sedan, Hatchback, SUV, Pickup, Furgoneta
    int anio_fabricacion;
    String tipo_motor; //gasolina, diésel, híbrido, eléctrico
    String cant_asientos;
    int kilometraje;
}
