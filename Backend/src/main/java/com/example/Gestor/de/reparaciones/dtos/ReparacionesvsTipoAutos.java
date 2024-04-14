package com.example.Gestor.de.reparaciones.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReparacionesvsTipoAutos {
    private String tipoReparacion;
    private int numeroTiposAutos;
    private int montoTotalReparaciones;
}
