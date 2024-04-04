package com.example.Gestor.de.reparaciones.entities;

import java.util.Date;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "reparaciones")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReparacionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id;

    private Date fechaIngresoTaller;
    private String horaIngresoTaller;
    private String tipoReparacion;
    private double montoTotalReparacion;
    private Date fechaSalidaReparacion;
    private String horaSalidaReparacion;

    //Con esto calcular el recargo por recogida
    private Date fechaEntregaCliente;//Fecha en que el cliente se llevó el vehículo
    private String horaEntregaCliente;//Hora en la que el cliente se llevó el vehículo

    //Revisar
    //@ManyToOne
    //@JoinColumn(name = "automovil_id")
   // private AutomovilEntity automovil;
}
