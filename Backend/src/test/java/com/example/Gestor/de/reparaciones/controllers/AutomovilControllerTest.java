package com.example.Gestor.de.reparaciones.controllers;

import com.example.Gestor.de.reparaciones.entities.AutomovilEntity;
import com.example.Gestor.de.reparaciones.services.AutomovilService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.awaitility.Awaitility.given;
import static org.mockito.BDDMockito.given;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


//@WebMvcTest(AutomovilControllerTest.class)
public class AutomovilControllerTest {
  //  @Autowired
    private MockMvc mockMvc;

    //@MockBean
    private AutomovilService automovilService;


    //@Test
    public void listaAutos_DebeRetornarAutos() throws Exception{
        AutomovilEntity automovil1 = new AutomovilEntity(1L,"QWER13","Toyota","Rav3", "Pickup",2010,"hibrido",5,120000);
        AutomovilEntity automovil2 = new AutomovilEntity(2L,"QWER12", "Toyota","Rav4", "Furgoneta",2020, "Gasolina", 5, 120000);

        List<AutomovilEntity> automovilList = new ArrayList<>(Arrays.asList(automovil1,automovil2));

        given(automovilService.getAutomoviles()).willReturn((ArrayList<AutomovilEntity>) automovilList);

        mockMvc.perform(get("/api/automoviles/"))
                .andExpect(status().isOk()) //Espero que el status esté ok
                .andExpect(content().contentType(MediaType.APPLICATION_JSON)) //Espero que esté en formato JSON
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[0].patente", is("QWER13")))
                .andExpect(jsonPath("$[1].patente", is("QWER12")));
    }



}


