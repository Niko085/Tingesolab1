package com.example.Gestor.de.reparaciones.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "constantes")
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ConstanteEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    Long id;

    double iva;
}
