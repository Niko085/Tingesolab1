package com.example.Gestor.de.reparaciones.services;

import com.example.Gestor.de.reparaciones.entities.AutomovilEntity;
import com.example.Gestor.de.reparaciones.entities.ReparacionEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ActiveProfiles("test")
public class ReparacionServiceTest {
    @Autowired
    ReparacionService reparacionService;


    @Test
    public void testGetReparacionesList() throws Exception {
        //Give
        ReparacionEntity reparacion1 = new ReparacionEntity();
        reparacion1.setPatente("CFYF55");
        reparacion1.setTipoReparacion(1);
        reparacion1.setDescripcion("Reparacion de frenos");
        reparacion1.setIdHistorialReparaciones(1);

        ReparacionEntity reparacion2 = new ReparacionEntity();
            reparacion2.setPatente("CFYF55");
        reparacion2.setTipoReparacion(2);
        reparacion2.setDescripcion("Reparacion de sistema electrico");
        reparacion2.setIdHistorialReparaciones(2);

        reparacionService.saveReparacion(reparacion1);
        reparacionService.saveReparacion(reparacion2);

        List<ReparacionEntity> reparaciones = new ArrayList<>();
        reparaciones.add(reparacion1);
        reparaciones.add(reparacion2);

        //When
        List<ReparacionEntity> reparacionesTest = reparacionService.getReparaciones();

        //Then
        assertEquals(reparaciones.get(0).getPatente(), reparacionesTest.get(0).getPatente());
        assertEquals(reparaciones.get(1).getPatente(), reparacionesTest.get(1).getPatente());

        reparacionService.deleteReparacion(reparacion1.getId());
        reparacionService.deleteReparacion(reparacion2.getId());

    }


}
