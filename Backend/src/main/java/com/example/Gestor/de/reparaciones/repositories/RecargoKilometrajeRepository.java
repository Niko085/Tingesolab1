package com.example.Gestor.de.reparaciones.repositories;

import com.example.Gestor.de.reparaciones.entities.RecargoKilometrajeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecargoKilometrajeRepository extends JpaRepository<RecargoKilometrajeEntity, Long> {
}