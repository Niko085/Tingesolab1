package com.example.Gestor.de.reparaciones.repositories;

import com.example.Gestor.de.reparaciones.entities.ReparacionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReparacionRepository extends JpaRepository<ReparacionEntity, Long> {
    //estudiante

    @Query("SELECT r FROM ReparacionEntity r JOIN Automovil a ON r.id_automovil = a.id WHERE a.patente = :patenteAutomovil")
    List<ReparacionEntity> findReparacionEntitiesByPatente(@Param("patenteAutomovil") String patenteAutomovil);

    //@Query("SELECT r FROM ReparacionEntity r JOIN AutomovilEntity a ON r.id_automovil = a.id WHERE a.patente = :patente")
    //List<ReparacionEntity> findReparacionEntitiesByPatente(@Param("patente") String patente);

}