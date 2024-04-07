package com.example.Gestor.de.reparaciones.repositories;

import com.example.Gestor.de.reparaciones.entities.Recargo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecargoRepository extends JpaRepository<Recargo, Long> {
}
