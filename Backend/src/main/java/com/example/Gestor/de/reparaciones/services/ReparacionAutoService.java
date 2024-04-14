package com.example.Gestor.de.reparaciones.services;

import com.example.Gestor.de.reparaciones.entities.ReparacionAutoEntity;
import com.example.Gestor.de.reparaciones.repositories.ReparacionAutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ReparacionAutoService {
    @Autowired
    ReparacionAutoRepository reparacionAutoRepository;

    public ArrayList<ReparacionAutoEntity> getReparaciones(){
        return (ArrayList<ReparacionAutoEntity>) reparacionAutoRepository.findAll();
    }

    public ReparacionAutoEntity saveReparacion(ReparacionAutoEntity reparacion){
        return reparacionAutoRepository.save(reparacion);
    }

    /*
    public ReparacionEntity getReparacionById(Long id){
        return reparacionRepository.findById(id).get();
    }

     */

    public List<ReparacionAutoEntity> getReparacionesByPatente(String patente) {
        return reparacionAutoRepository.findByPatente(patente);
    }

    /*
    public List<ReparacionAutoEntity> getReparacionesByIdHistorial(int id) {
        return reparacionAutoRepository.findByIdHistorialReparaciones(id);
    }

     */

    public ReparacionAutoEntity updateReparacion(ReparacionAutoEntity reparacion) {
        return reparacionAutoRepository.save(reparacion);
    }


    public boolean deleteReparacion(Long id) throws Exception {
        try{
            reparacionAutoRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    public Double sumReparacionesByPatente(String patente) {
        return reparacionAutoRepository.sumReparacionesByPatente(patente);
    }

    public int contarReparacionesPorHistorial(Long idHistorial) {
        // Llamar al método definido en el repositorio para contar las reparaciones por historial
        return reparacionAutoRepository.countReparacionesByHistorial(idHistorial);
    }

}
