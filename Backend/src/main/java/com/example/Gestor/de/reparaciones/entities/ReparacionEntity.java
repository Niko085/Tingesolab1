package com.example.Gestor.de.reparaciones.entities;

import java.util.Date;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "reparaciones")
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ReparacionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    Long id;

    Date fechaIngresoTaller;
    String horaIngresoTaller;
    String tipoReparacion;
    double montoTotalReparacion;
    Date fechaSalidaReparacion;
    String horaSalidaReparacion;

    //Con esto calcular el recargo por recogida
    Date fechaEntregaCliente;//Fecha en que el cliente se llevó el vehículo
    String horaEntregaCliente;//Hora en la que el cliente se llevó el vehículo

    int id_automovil;
    //Revisar
    //@ManyToOne
    //@JoinColumn(name = "automovil_id")
   // private AutomovilEntity automovil;
}
