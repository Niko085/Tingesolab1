package com.example.Gestor.de.reparaciones.services;

import com.example.Gestor.de.reparaciones.entities.Detalle;
import com.example.Gestor.de.reparaciones.repositories.DetalleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReparacionService {

    private final DetalleRepository reparacionRepository;

    @Autowired
    public ReparacionService(DetalleRepository reparacionRepository) {
        this.reparacionRepository = reparacionRepository;
    }

    public List<Detalle> encontrarReparacionesPorPatente(String patente) {
        return reparacionRepository.findReparacionEntitiesByPatente(patente);
    }
}
