package com.example.Gestor.de.reparaciones.services;

import com.example.Gestor.de.reparaciones.entities.DatosBonosEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
@ActiveProfiles("test")
public class DatosBonosServiceTest {
    @Autowired
    DatosBonosService datosBonosService;


    @Test
    public void testGetBonosList() throws Exception {
        //Give
        DatosBonosEntity datosBonos1 = new DatosBonosEntity();
        datosBonos1.setMarcaAutomovil("Hyundai");
        datosBonos1.setCantidadBonos(4);
        datosBonos1.setMontoBono(30000);

        DatosBonosEntity datosBonos2 = new DatosBonosEntity();
        datosBonos2.setMarcaAutomovil("Honda");
        datosBonos2.setCantidadBonos(5);
        datosBonos2.setMontoBono(40000);

        datosBonosService.saveDatosBonos(datosBonos1);
        datosBonosService.saveDatosBonos(datosBonos2);

        List<DatosBonosEntity> bonos = new ArrayList<>();
        bonos.add(datosBonos1);
        bonos.add(datosBonos2);

        //When
        List<DatosBonosEntity> bonosTest = datosBonosService.getDatosBonos();


        //Then
        assertEquals(bonos.get(0).getMarcaAutomovil(), bonosTest.get(0).getMarcaAutomovil());
        assertEquals(bonos.get(1).getCantidadBonos(), bonosTest.get(1).getCantidadBonos());

        datosBonosService.deleteDatosBonos(datosBonos1.getId());
        datosBonosService.deleteDatosBonos(datosBonos1.getId());
    }

    @Test
    public void testSaveDatosBono() throws Exception {
        //Give
        DatosBonosEntity datosBonos3 = new DatosBonosEntity();
        datosBonos3.setMarcaAutomovil("Toyota");
        datosBonos3.setCantidadBonos(7);
        datosBonos3.setMontoBono(35000);

        //When
        DatosBonosEntity bonoTest = datosBonosService.saveDatosBonos(datosBonos3);

        //Then
        assertEquals(datosBonos3, bonoTest);
        datosBonosService.deleteDatosBonos(datosBonos3.getId());
    }

    @Test
    public void testGetDatosBonoById() throws Exception{
        //Give
        DatosBonosEntity datosBonos4 = new DatosBonosEntity();
        datosBonos4.setMarcaAutomovil("Hyundai");
        datosBonos4.setCantidadBonos(5);
        datosBonos4.setMontoBono(35000);

        //When
        datosBonosService.saveDatosBonos(datosBonos4);
        DatosBonosEntity getBonoIdTestId = datosBonosService.getDatosBonosById(datosBonos4.getId());

        //Then
        assertEquals(datosBonos4.getMarcaAutomovil(), getBonoIdTestId.getMarcaAutomovil());
        datosBonosService.deleteDatosBonos(datosBonos4.getId());
    }


    @Test
    public void testGetDatosBonoByMarca() throws Exception{
        //Give
        DatosBonosEntity datosBonos5 = new DatosBonosEntity();
        datosBonos5.setMarcaAutomovil("Hyundai");
        datosBonos5.setCantidadBonos(5);
        datosBonos5.setMontoBono(35000);

        //When
        datosBonosService.saveDatosBonos(datosBonos5);
        DatosBonosEntity getBonoIdTestId = datosBonosService.getDatosBonosByMarca(datosBonos5.getMarcaAutomovil());

        //Then
        assertEquals(datosBonos5.getMarcaAutomovil(), getBonoIdTestId.getMarcaAutomovil());
        datosBonosService.deleteDatosBonos(datosBonos5.getId());
    }



    @Test
    public void testUpdateBono() throws Exception {
        // Given
        DatosBonosEntity datosBonos6 = new DatosBonosEntity();
        datosBonos6.setMarcaAutomovil("Hyundai");
        datosBonos6.setCantidadBonos(4);
        datosBonos6.setMontoBono(45000);

        datosBonosService.saveDatosBonos(datosBonos6);
        DatosBonosEntity BonoToUpdate = datosBonosService.getDatosBonosById(datosBonos6.getId());

        BonoToUpdate.setMontoBono(50000);
        BonoToUpdate.setCantidadBonos(6);
        BonoToUpdate.setMarcaAutomovil("Honda");

        // When
        DatosBonosEntity updatedBono = datosBonosService.updateDatosBonos(BonoToUpdate);

        // Then
        assertEquals(BonoToUpdate.getId(), updatedBono.getId());
        assertEquals("Honda", updatedBono.getMarcaAutomovil());
        assertEquals(6, updatedBono.getCantidadBonos());
        assertEquals(50000, updatedBono.getMontoBono());
        datosBonosService.deleteDatosBonos(updatedBono.getId());
    }




    @Test
    public void testDeleteBono() throws Exception {
        // Given
        DatosBonosEntity datosBonos7 = new DatosBonosEntity();
        datosBonos7.setMarcaAutomovil("Hyundai");
        datosBonos7.setCantidadBonos(5);
        datosBonos7.setMontoBono(45000);

        DatosBonosEntity savedBono = datosBonosService.saveDatosBonos(datosBonos7);

        // When
        // Eliminar el automóvil de la base de datos
        datosBonosService.deleteDatosBonos(savedBono.getId());

        // Then
        // Verificar que el automóvil ya no exista en la base de datos
        assertThrows(NoSuchElementException.class, () -> datosBonosService.getDatosBonosById(savedBono.getId()));
    }
}
