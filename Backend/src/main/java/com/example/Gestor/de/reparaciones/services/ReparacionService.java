package com.example.Gestor.de.reparaciones.services;

import com.example.Gestor.de.reparaciones.entities.ReparacionEntity;
import com.example.Gestor.de.reparaciones.repositories.ReparacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReparacionService {

    private final ReparacionRepository reparacionRepository;

    @Autowired
    public ReparacionService(ReparacionRepository reparacionRepository) {
        this.reparacionRepository = reparacionRepository;
    }

    public List<ReparacionEntity> encontrarReparacionesPorPatente(String patente) {
        return reparacionRepository.findReparacionEntitiesByPatente(patente);
    }
}
