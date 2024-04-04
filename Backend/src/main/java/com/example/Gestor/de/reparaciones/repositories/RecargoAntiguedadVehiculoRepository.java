package com.example.Gestor.de.reparaciones.repositories;

import com.example.Gestor.de.reparaciones.entities.RecargoAntiguedadVehiculoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecargoAntiguedadVehiculoRepository extends JpaRepository<RecargoAntiguedadVehiculoEntity, Long> {
}