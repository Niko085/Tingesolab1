package com.example.Gestor.de.reparaciones.services;

import com.example.Gestor.de.reparaciones.dtos.CrearAutomovil;
import com.example.Gestor.de.reparaciones.entities.Automovil;
import com.example.Gestor.de.reparaciones.repositories.AutomovilRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AutomovilService {


    AutomovilRepository automovilRepository;
    @Autowired

    public AutomovilService(AutomovilRepository automovilRepository) {
        this.automovilRepository = automovilRepository;
    }
    //private AutomovilRepository automovilRepository;

    //public AutomovilEntity registrarAutomovil(AutomovilEntity automovil) {
    //    return automovilRepository.save(automovil);
    //}
    public List<Automovil> getAutomoviles(){return automovilRepository.findAll();}


    @Transactional
    public Automovil saveAutomovil(CrearAutomovil body) {
        Automovil nuevoAutomovil = new Automovil();
        nuevoAutomovil.setId(body.getId());
        nuevoAutomovil.setPatente(body.getPatente());
        nuevoAutomovil.setMarca(body.getMarca());
        nuevoAutomovil.setModelo(body.getModelo());
        nuevoAutomovil.setTipo(body.getTipo());
        nuevoAutomovil.setAnio_fabricacion(body.getAnio_fabricacion());
        nuevoAutomovil.setTipo_motor(body.getTipo_motor());
        nuevoAutomovil.setCant_asientos(body.getCant_asientos());

        return automovilRepository.save(nuevoAutomovil);
    }


}
