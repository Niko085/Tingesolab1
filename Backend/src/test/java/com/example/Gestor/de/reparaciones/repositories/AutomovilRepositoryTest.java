package com.example.Gestor.de.reparaciones.repositories;

import com.example.Gestor.de.reparaciones.entities.AutomovilEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ActiveProfiles;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@ActiveProfiles("test")
public class AutomovilRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private AutomovilRepository automovilRepository;

    @Test
    public void whenFindByPatente_thenReturnAutomovil() {
        // Given
        AutomovilEntity automovil = new AutomovilEntity(1L, "QWER13", "Toyota", "Rav3", "Pickup", 2010, "hibrido", 5, 120000);

        // When
        AutomovilEntity savedAutomovil = entityManager.persistAndFlush(automovil); // Guarda y obtiene el automóvil

        // Then
        AutomovilEntity found = automovilRepository.findByPatente(savedAutomovil.getPatente());
        assertThat(found).isEqualTo(savedAutomovil);
    }

}
