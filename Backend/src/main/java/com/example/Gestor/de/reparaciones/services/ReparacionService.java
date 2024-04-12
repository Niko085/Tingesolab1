package com.example.Gestor.de.reparaciones.services;

import com.example.Gestor.de.reparaciones.entities.ReparacionAutoEntity;
import com.example.Gestor.de.reparaciones.repositories.ReparacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ReparacionService {
    @Autowired
    ReparacionRepository reparacionRepository;

    public ArrayList<ReparacionAutoEntity> getReparaciones(){
        return (ArrayList<ReparacionAutoEntity>) reparacionRepository.findAll();
    }

    public ReparacionAutoEntity saveReparacion(ReparacionAutoEntity reparacion){
        return reparacionRepository.save(reparacion);
    }

    /*
    public ReparacionEntity getReparacionById(Long id){
        return reparacionRepository.findById(id).get();
    }

     */

    public List<ReparacionAutoEntity> getReparacionesByPatente(String patente) {
        return reparacionRepository.findByPatente(patente);
    }

    public ReparacionAutoEntity updateReparacion(ReparacionAutoEntity reparacion) {
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
