package com.example.Gestor.de.reparaciones.services;

import com.example.Gestor.de.reparaciones.entities.ReparacionEntity;
import com.example.Gestor.de.reparaciones.repositories.ReparacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ReparacionService {
    @Autowired
    ReparacionRepository reparacionRepository;

    public ArrayList<ReparacionEntity> getReparaciones(){
        return (ArrayList<ReparacionEntity>) reparacionRepository.findAll();
    }

    public ReparacionEntity saveReparacion(ReparacionEntity reparacion){
        return reparacionRepository.save(reparacion);
    }

    /*
    public ReparacionEntity getReparacionById(Long id){
        return reparacionRepository.findById(id).get();
    }

     */

    public List<ReparacionEntity> getReparacionesByPatente(String patente) {
        return reparacionRepository.findByPatente(patente);
    }

    public ReparacionEntity updateReparacion(ReparacionEntity reparacion) {
        return reparacionRepository.save(reparacion);
    }


    public boolean deleteReparacion(Long id) throws Exception {
        try{
            reparacionRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    public Double sumReparacionesByPatente(String patente) {
        return reparacionRepository.sumReparacionesByPatente(patente);
    }

}
