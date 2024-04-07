package com.example.Gestor.de.reparaciones.services;

import com.example.Gestor.de.reparaciones.entities.AutomovilEntity;
import com.example.Gestor.de.reparaciones.repositories.AutomovilRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class AutomovilService {
    @Autowired
    AutomovilRepository automovilRepository;
    public ArrayList<AutomovilEntity> getAutomoviles(){
        return (ArrayList<AutomovilEntity>) automovilRepository.findAll();
    }
    public AutomovilEntity saveAutomovil(AutomovilEntity automovil){
        return automovilRepository.save(automovil);
    }

    public AutomovilEntity getAutomovilById(Long id){
        return automovilRepository.findById(id).get();
    }

    public AutomovilEntity getAutomovilByPatente(String patente){
        return automovilRepository.findByPatente(patente);
    }

    public AutomovilEntity getAutomovilByAnioFabricacion(int anioFabricacion){
        return automovilRepository.findByAnioFabricacion(anioFabricacion);
    }

    public AutomovilEntity updateAutomovil(AutomovilEntity automovil) {
        return automovilRepository.save(automovil);
    }

    public boolean deleteAutomovil(Long id) throws Exception {
        try{
            automovilRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }

    }
}
