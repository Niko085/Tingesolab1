package com.example.Gestor.de.reparaciones.repositories;

import com.example.Gestor.de.reparaciones.entities.ReparacionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReparacionRepository extends JpaRepository<ReparacionEntity, Long> {
    public List<ReparacionEntity> findByIdHistorialReparaciones(long id);
    public List<ReparacionEntity> findByPatente(String patente);

    public List<ReparacionEntity> findByTipoReparacion(int tipoReparacion);


    //public List<ReparacionAutoEntity> findByIdHistorialReparaciones(int id);

    //@Query("SELECT COUNT(r) FROM ReparacionEntity r WHERE r.idHistorialReparaciones = :idHistorialReparaciones")
    //Integer countReparacionesByIdHistorialReparaciones(@Param("idHistorialReparaciones") Long idHistorialReparaciones);


/*
    @Query(value = "SELECT * FROM reparaciones WHERE reparaciones.patente = :patente", nativeQuery = true)
    List<ReparacionEntity> getReparacionesByPatente(@Param("patente") String patente);

 */
    //@Query("SELECT SUM(r.monto) FROM ReparacionEntity r WHERE r.patente = :patente")
    //Double sumReparacionesByPatente(@Param("patente") String patente);

    //@Query("SELECT COUNT(r) FROM ReparacionAutoEntity r WHERE r.idHistorialReparaciones = :idHistorial")
    //Integer countReparacionesByHistorial(@Param("idHistorial") Long idHistorial);

    @Query("SELECT COUNT(r) FROM ReparacionEntity r WHERE r.idHistorialReparaciones = :idHistorial")
    Integer countReparacionesByHistorial(@Param("idHistorial") Long idHistorial);

    @Query("SELECT COUNT(r) FROM ReparacionEntity r WHERE r.tipoReparacion = :tipoReparacion")
    Integer countReparacionesByTipoReparacion(@Param("tipoReparacion") int tipoReparacion);


}
