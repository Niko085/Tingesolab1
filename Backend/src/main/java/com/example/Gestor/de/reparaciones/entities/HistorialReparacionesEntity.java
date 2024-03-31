package com.example.Gestor.de.reparaciones.entities;

import java.util.Date;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "historial_reparaciones")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class HistorialReparacionesEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id;

    //@Column(name = "fecha_ingreso_taller")
    private Date fechaIngresoTaller;

    //@Column(name = "hora_ingreso_taller")
    private String horaIngresoTaller;

    //@Column(name = "tipo_reparacion")
    private String tipoReparacion;

    //@Column(name = "monto_total_reparacion")
    private double montoTotalReparacion;

    //@Column(name = "fecha_salida_reparacion")
    private Date fechaSalidaReparacion;

    //@Column(name = "hora_salida_reparacion")
    private String horaSalidaReparacion;

    //@Column(name = "fecha_entrega_cliente")
    private Date fechaEntregaCliente;//Fecha en que el cliente se llevó el vehículo

    //@Column(name = "hora_entrega_cliente")
    private String horaEntregaCliente;//Hora en la que el cliente se llevó el vehículo

    @ManyToOne
    @JoinColumn(name = "automovil_id")
    private AutomovilEntity automovil;
}
