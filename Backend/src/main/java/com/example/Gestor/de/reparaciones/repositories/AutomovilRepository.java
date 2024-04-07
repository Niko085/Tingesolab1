package com.example.Gestor.de.reparaciones.repositories;

import com.example.Gestor.de.reparaciones.entities.AutomovilEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface AutomovilRepository extends JpaRepository<AutomovilEntity, Long> {
    public AutomovilEntity findByPatente(String patente);
    //List<AutomovilEntity> findByAnio_fabricacion(int anio_fabricacion);
}
