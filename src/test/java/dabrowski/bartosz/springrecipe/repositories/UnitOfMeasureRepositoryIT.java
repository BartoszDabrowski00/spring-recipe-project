package dabrowski.bartosz.springrecipe.repositories;

import dabrowski.bartosz.springrecipe.domain.UnitOfMeasure;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@ExtendWith(MockitoExtension.class)
@DataJpaTest
class UnitOfMeasureRepositoryIT {

    @Autowired
    UnitOfMeasureRepository unitOfMeasureRepository;

    @BeforeEach
    void setUp() {
    }

    @Test
    void findUnitOfMeasuresByDescription() {
        Optional<UnitOfMeasure> uom = unitOfMeasureRepository.findUnitOfMeasuresByDescription("Teaspoon");
        assertEquals("Teaspoon", uom.get().getDescription());
    }
    @Test
    void findByDescriptionCup() {
        Optional<UnitOfMeasure> uom = unitOfMeasureRepository.findUnitOfMeasuresByDescription("Cup");
        assertEquals("Cup", uom.get().getDescription());
    }
}