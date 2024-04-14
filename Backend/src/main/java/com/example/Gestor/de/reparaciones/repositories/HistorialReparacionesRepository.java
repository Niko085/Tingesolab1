package com.example.Gestor.de.reparaciones.repositories;

import com.example.Gestor.de.reparaciones.dtos.ReparacionesvsTipoAutos;
import com.example.Gestor.de.reparaciones.entities.HistorialReparacionesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HistorialReparacionesRepository extends JpaRepository<HistorialReparacionesEntity, Long> {

    public List<HistorialReparacionesEntity> findByPatente(String patente);

    //public List<HistorialReparacionesEntity> findByPatenteAndAndPagadoIsFalse(String patente);

    public HistorialReparacionesEntity findByPatenteAndAndPagadoIsFalse(String patente);

    public HistorialReparacionesEntity findHistorialByPatente(String patente);

    @Query("SELECT MAX(hr.id) FROM HistorialReparacionesEntity hr")
    Long findMaxId();


    /*
    @Query(value = "SELECT * FROM paychecks WHERE paychecks.year = :year AND paychecks.month = :month ORDER BY paychecks.year, paychecks.month, paychecks.rut", nativeQuery = true)
    List<PaycheckEntity> getPaychecksByYearMonth(@Param("year") int year, @Param("month") int month);

     */



}
