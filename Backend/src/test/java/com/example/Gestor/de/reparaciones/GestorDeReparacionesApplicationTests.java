package com.example.Gestor.de.reparaciones;

import com.example.Gestor.de.reparaciones.entities.AutomovilEntity;
import com.example.Gestor.de.reparaciones.services.AutomovilService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@ActiveProfiles("test")
class GestorDeReparacionesApplicationTests {
	@InjectMocks
	AutomovilService automovilService;

	@Test
	public void testSaveAutomovil(){
		AutomovilEntity automovil1 = new AutomovilEntity();
		automovil1.setPatente("ASDF17");
		automovil1.setMarca("Hyundai");
		automovil1.setModelo("i9");
		automovil1.setTipo("Sedan");
		automovil1.setAnioFabricacion(2017);
		automovil1.setMotor("Electrico");
		automovil1.setCantAsientos(5);
		automovil1.setKilometraje(12000);

		AutomovilEntity autoTest = automovilService.saveAutomovil(automovil1);
		//assertEquals()
		System.out.println(autoTest.getPatente());
	}



}
