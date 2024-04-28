package com.example.Gestor.de.reparaciones.repositories;

import com.example.Gestor.de.reparaciones.entities.ValorReparacionesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ValorReparacionesRepository extends JpaRepository<ValorReparacionesEntity, Long> {
    //public int findByNumeroReparacionAndAndTipoMotor(int numeroReparacion, String tipoMotor);
    //int findByNumeroReparacionAndTipoMotor(int identificadorReparacion, String tipoMotor);

    @Query("SELECT vr.monto FROM ValorReparacionesEntity vr WHERE vr.numeroReparacion = :numeroReparacion AND vr.tipoMotor = :tipoMotor")
    int findMontoByNumeroReparacionAndTipoMotor(int numeroReparacion, String tipoMotor);

/*
    public String findByNumeroReparacionAndTipoMotor(int numero, String tipoMotor);

 */
}
