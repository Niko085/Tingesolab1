package com.example.Gestor.de.reparaciones.repositories;

import com.example.Gestor.de.reparaciones.entities.DescuentoBonosEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DescuentoBonosRepository extends JpaRepository<DescuentoBonosEntity, Long> {
}
