package com.example.Gestor.de.reparaciones.repositories;

import com.example.Gestor.de.reparaciones.entities.Descuento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DescuentoRepository extends JpaRepository<Descuento, Long> {
}
