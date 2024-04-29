package com.example.Gestor.de.reparaciones.services;

import com.example.Gestor.de.reparaciones.entities.AutomovilEntity;
import com.example.Gestor.de.reparaciones.repositories.AutomovilRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.lang.reflect.Executable;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
public class AutomovilServiceTest {
    @Autowired
    AutomovilService automovilService;

    @Mock
    AutomovilRepository automovilRepository;

    @Mock
    HistorialReparacionesService historialReparacionesService;

    @Test
    public void testGetAutomovilesList() throws Exception {
        //Give
        AutomovilEntity automovil1 = new AutomovilEntity();
        automovil1.setPatente("ASDF17");
        automovil1.setMarca("Hyundai");
        automovil1.setModelo("i9");
        automovil1.setTipo("Sedan");
        automovil1.setAnioFabricacion(2017);
        automovil1.setMotor("Electrico");
        automovil1.setCantAsientos(5);
        automovil1.setKilometraje(12000);

        AutomovilEntity automovil2 = new AutomovilEntity();
        automovil2.setPatente("UJHY16");
        automovil2.setMarca("Ford");
        automovil2.setModelo("i5");
        automovil2.setTipo("Sedan");
        automovil2.setAnioFabricacion(2016);
        automovil2.setMotor("Hibrido");
        automovil2.setCantAsientos(5);
        automovil2.setKilometraje(12000);

        automovilService.saveAutomovil(automovil1);
        automovilService.saveAutomovil(automovil2);

        List<AutomovilEntity> automoviles = new ArrayList<>();
        automoviles.add(automovil1);
        automoviles.add(automovil2);

        //When
        List<AutomovilEntity> automovilesTest = automovilService.getAutomoviles();
        //for (AutomovilEntity auto : automovilesTest){
        //    System.out.println(auto.getPatente());
        //}

        //Then
        assertEquals(automoviles.get(0).getPatente(), automovilesTest.get(0).getPatente());
        assertEquals(automoviles.get(1).getPatente(), automovilesTest.get(1).getPatente());

        automovilService.deleteAutomovil(automovil1.getId());
        automovilService.deleteAutomovil(automovil2.getId());

    }

    @Test
    public void testSaveAutomovil() throws Exception {
        //Give
        AutomovilEntity automovil = new AutomovilEntity();
        automovil.setPatente("FGTR23");
        automovil.setMarca("Hyundai");
        automovil.setModelo("i5");
        automovil.setTipo("Sedan");
        automovil.setAnioFabricacion(2017);
        automovil.setMotor("Gasolina");
        automovil.setCantAsientos(5);
        automovil.setKilometraje(12000);

        //When
        AutomovilEntity autoPrueba = automovilService.saveAutomovil(automovil);
        //AutomovilEntity autoPrueba = automovil;

        //Then
        assertEquals(automovil, autoPrueba);
        automovilService.deleteAutomovil(automovil.getId());
    }


    @Test
    public void testGetAutomovilById() throws Exception{
        //Give
        AutomovilEntity automovil3 = new AutomovilEntity();
        automovil3.setPatente("ORTP63");
        automovil3.setMarca("Honda");
        automovil3.setModelo("Accent");
        automovil3.setTipo("Hatchback");
        automovil3.setAnioFabricacion(2018);
        automovil3.setMotor("Diesel");
        automovil3.setCantAsientos(4);
        automovil3.setKilometraje(12500);

        //When
        AutomovilEntity saveAutoGetId = automovilService.saveAutomovil(automovil3);
        AutomovilEntity getAutoIdTestId = automovilService.getAutomovilById(saveAutoGetId.getId());

        //Then
        assertEquals(automovil3.getPatente(), getAutoIdTestId.getPatente());
        automovilService.deleteAutomovil(automovil3.getId());
    }

    @Test
    public void testGetAutomovilByPatente() throws Exception{
        //Give
        AutomovilEntity automovil4 = new AutomovilEntity();
        automovil4.setPatente("TYRB63");
        automovil4.setMarca("Honda");
        automovil4.setModelo("Accent");
        automovil4.setTipo("Suv");
        automovil4.setAnioFabricacion(2019);
        automovil4.setMotor("Electrico");
        automovil4.setCantAsientos(5);
        automovil4.setKilometraje(11000);

        //When
        AutomovilEntity saveAutoGetPatente = automovilService.saveAutomovil(automovil4);
        AutomovilEntity getAutoIdTestPatente = automovilService.getAutomovilByPatente(saveAutoGetPatente.getPatente());

        //Then
        assertEquals(automovil4.getPatente(), getAutoIdTestPatente.getPatente());
        automovilService.deleteAutomovil(automovil4.getId());
    }

/*
    @Test
    public void testUpdateAutomovil() throws Exception{
        //Give
        AutomovilEntity automovil5 = new AutomovilEntity();
        automovil5.setPatente("UTNR62");
        automovil5.setMarca("Honda");
        automovil5.setModelo("Accent");
        automovil5.setTipo("Suv");
        automovil5.setAnioFabricacion(2018);
        automovil5.setMotor("Hibrido");
        automovil5.setCantAsientos(5);
        automovil5.setKilometraje(11000);

        AutomovilEntity automovil6 = new AutomovilEntity();
        automovil6.setPatente("AUNT19");
        automovil6.setMarca("Honda");
        automovil6.setModelo("Civic");
        automovil6.setTipo("PickUp");
        automovil6.setAnioFabricacion(2018);
        automovil6.setMotor("Electrico");
        automovil6.setCantAsientos(5);
        automovil6.setKilometraje(11000);


        //When
        AutomovilEntity saveAutoUpdate = automovilService.saveAutomovil(automovil5);



        //Then
        assertEquals(automovil5.getPatente(), automovil6.getPatente());

    }

 */



    @Test
    public void testUpdateAutomovil() throws Exception {
        // Given
        AutomovilEntity automovil5 = new AutomovilEntity();
        automovil5.setPatente("UTNR62");
        automovil5.setMarca("Honda");
        automovil5.setModelo("Accent");
        automovil5.setTipo("Suv");
        automovil5.setAnioFabricacion(2018);
        automovil5.setMotor("Hibrido");
        automovil5.setCantAsientos(5);
        automovil5.setKilometraje(11000);

        // Recuperar el automóvil de la base de datos usando el servicio
        automovilService.saveAutomovil(automovil5);
        AutomovilEntity automovilToUpdate = automovilService.getAutomovilByPatente(automovil5.getPatente());

        // Actualizar los atributos del automóvil
        automovilToUpdate.setMarca("Toyota");
        automovilToUpdate.setModelo("Civic");
        automovilToUpdate.setTipo("Sedan");
        // Actualizar otros atributos según sea necesario

        // When
        AutomovilEntity updatedAutomovil = automovilService.updateAutomovil(automovilToUpdate);

        // Then
        // Verificar que el automóvil actualizado sea el mismo que el recuperado
        assertEquals(automovilToUpdate.getId(), updatedAutomovil.getId());
        assertEquals("Toyota", updatedAutomovil.getMarca());
        assertEquals("Civic", updatedAutomovil.getModelo());
        assertEquals("Sedan", updatedAutomovil.getTipo());
        automovilService.deleteAutomovil(updatedAutomovil.getId());
    }


    @Test
    public void testDeleteAutomovil() throws Exception {
        // Given
        AutomovilEntity automovil6 = new AutomovilEntity();
        automovil6.setPatente("ALRV43");
        automovil6.setMarca("Hyundai");
        automovil6.setModelo("i5");
        automovil6.setTipo("Sedan");
        automovil6.setAnioFabricacion(2017);
        automovil6.setMotor("Gasolina");
        automovil6.setCantAsientos(5);
        automovil6.setKilometraje(12000);

        // Guardar el automóvil en la base de datos
        AutomovilEntity savedAutomovil = automovilService.saveAutomovil(automovil6);

        // When
        // Eliminar el automóvil de la base de datos
        automovilService.deleteAutomovil(savedAutomovil.getId());

        // Then
        // Verificar que el automóvil ya no exista en la base de datos
        assertThrows(NoSuchElementException.class, () -> automovilService.getAutomovilById(savedAutomovil.getId()));
    }

    @Test
    public void testDeleteAutomovilAutomovilNotFound() throws Exception {
        // Given
        AutomovilEntity automovil7 = new AutomovilEntity();
        automovil7.setPatente("ALRV43");
        automovil7.setMarca("Hyundai");
        automovil7.setModelo("i5");
        automovil7.setTipo("Sedan");
        automovil7.setAnioFabricacion(2017);
        automovil7.setMotor("Gasolina");
        automovil7.setCantAsientos(5);
        automovil7.setKilometraje(12000);

        // When
        // Intentar eliminar un automóvil que no existe en la base de datos
        AutomovilEntity savedAutomovil = automovilService.saveAutomovil(automovil7);
        automovilService.deleteAutomovil(automovil7.getId()+1);

        // Then
        //assertThrows(NoSuchElementException.class, () -> automovilService.getAutomovilById(savedAutomovil.getId()));
        assertFalse(automovilRepository.existsById(automovil7.getId()));
        automovilService.deleteAutomovil(automovil7.getId());
    }



}

/*
    @Test
    public void testSaveAutomovil() throws Exception{
        //Give


        //When


        //Then

    }
    */
















