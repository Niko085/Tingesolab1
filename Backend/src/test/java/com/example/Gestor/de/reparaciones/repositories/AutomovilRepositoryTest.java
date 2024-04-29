package com.example.Gestor.de.reparaciones.repositories;
import com.example.Gestor.de.reparaciones.entities.AutomovilEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@ActiveProfiles("test")
public class AutomovilRepositoryTest {
    @Autowired
    private TestEntityManager entityManager;
    
    @Autowired
    private AutomovilRepository automovilRepository;
    
    @Test
    public void WhenfindByPatente_theReturnAutomovil(){
        //Given
        AutomovilEntity automovil = new AutomovilEntity(1L,"QWER13","Toyota","Rav3", "Pickup",2010,"hibrido",5,120000);
        entityManager.persistAndFlush(automovil); //Graba un auto
        
        //When
        AutomovilEntity found = automovilRepository.findByPatente(automovil.getPatente());//Busca el auto
        
        //Then
        assertThat(found.getPatente()).isEqualTo(automovil.getPatente());
        //Assert es como "verifica que"

    }


}
