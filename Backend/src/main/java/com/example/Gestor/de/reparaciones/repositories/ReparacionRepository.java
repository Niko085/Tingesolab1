package com.example.Gestor.de.reparaciones.repositories;

import com.example.Gestor.de.reparaciones.entities.ReparacionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReparacionRepository extends JpaRepository<ReparacionEntity, Long> {
    public List<ReparacionEntity> findById(int id);
    public List<ReparacionEntity> findByPatente(String patente);

/*
    @Query(value = "SELECT * FROM reparaciones WHERE reparaciones.patente = :patente", nativeQuery = true)
    List<ReparacionEntity> getReparacionesByPatente(@Param("patente") String patente);

 */
}
