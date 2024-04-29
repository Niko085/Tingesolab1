package com.example.Gestor.de.reparaciones.services;

import com.example.Gestor.de.reparaciones.entities.AutomovilEntity;
import com.example.Gestor.de.reparaciones.repositories.AutomovilRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;


@SpringBootTest
public class AutomovilServiceTest {
    @InjectMocks
    AutomovilService automovilService;

    @Mock
    AutomovilRepository automovilRepository;

    @Mock
    HistorialReparacionesService historialReparacionesService;

    @BeforeEach
    public void setUp(){
        AutomovilEntity automovil1 = new AutomovilEntity();
        automovil1.setPatente("CFYF55");
        automovil1.setMarca("Hyundai");
        automovil1.setModelo("Getz");
        automovil1.setTipo("Sedan");
        automovil1.setAnioFabricacion(2010);
        automovil1.setMotor("Gasolina");
        automovil1.setCantAsientos(5);
        automovil1.setKilometraje(150000);

        AutomovilEntity automovil2 = new AutomovilEntity();
        automovil2.setPatente("TW6977");
        automovil2.setMarca("Toyota");
        automovil2.setModelo("i10");
        automovil2.setTipo("Sedan");
        automovil2.setAnioFabricacion(2015);
        automovil2.setMotor("Electrico");
        automovil2.setCantAsientos(5);
        automovil2.setKilometraje(110000);

        AutomovilEntity automovil3 = new AutomovilEntity();
        automovil3.setPatente("QWER12");
        automovil3.setMarca("Toyota");
        automovil3.setModelo("i12");
        automovil3.setTipo("Sedan");
        automovil3.setAnioFabricacion(2014);
        automovil3.setMotor("Diesel");
        automovil3.setCantAsientos(7);
        automovil3.setKilometraje(115000);

        AutomovilEntity automovil4 = new AutomovilEntity();
        automovil4.setPatente("ASDF12");
        automovil4.setMarca("Ford");
        automovil4.setModelo("i15");
        automovil4.setTipo("Sedan");
        automovil4.setAnioFabricacion(2013);
        automovil4.setMotor("Hibrido");
        automovil4.setCantAsientos(4);
        automovil4.setKilometraje(110000);

        List<AutomovilEntity> automoviles = new ArrayList<>();
        automoviles.add(automovil1);
        automoviles.add(automovil2);
        automoviles.add(automovil3);
        automoviles.add(automovil4);

        List<String> marcas = new ArrayList<>();
        marcas.add(automovil1.getMarca());
        marcas.add(automovil2.getMarca());

        List<String> patentesMarcas1 = new ArrayList<>();
        patentesMarcas1.add(automovil1.getPatente());

        List<String> patentesMarcas2 = new ArrayList<>();
        patentesMarcas2.add(automovil2.getPatente());
        patentesMarcas2.add(automovil3.getPatente());


        Mockito.when(automovilRepository.save(automovil1)).thenReturn(automovil1);
        Mockito.when(automovilRepository.findAll()).thenReturn(automoviles);

    }


    @Test
    public void testRegistrarAutomovil() {
        AutomovilEntity vehiculo = new AutomovilEntity();
        vehiculo.setPatente("LJSY77");
        vehiculo.setMarca("Hyundai");
        vehiculo.setModelo("Accent");
        vehiculo.setTipo("Sedan");
        vehiculo.setAnioFabricacion(2019);
        vehiculo.setMotor("Gasolina");
        vehiculo.setCantAsientos(5);
        vehiculo.setKilometraje(42000);

        AutomovilEntity vehiculoTest = automovilService.saveAutomovil(vehiculo);

        assertEquals(vehiculo, vehiculoTest);
        System.out.println("Vehiculo registrado = " + vehiculoTest);
    }
}

















