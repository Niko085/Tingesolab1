package com.example.Gestor.de.reparaciones.repositories;

import com.example.Gestor.de.reparaciones.entities.DatosBonosEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface DatosBonosRepository extends JpaRepository<DatosBonosEntity, Long> {
    public DatosBonosEntity findByMarcaAutomovil(String marca);
}
