package dabrowski.bartosz.springrecipe.services;

import dabrowski.bartosz.springrecipe.commands.UnitOfMeasureCommand;
import dabrowski.bartosz.springrecipe.converters.UnitOfMeasureToUnitOfMeasureCommand;
import dabrowski.bartosz.springrecipe.domain.UnitOfMeasure;
import dabrowski.bartosz.springrecipe.repositories.UnitOfMeasureRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class UnitOfMeasureServiceImplTest {
    UnitOfMeasureToUnitOfMeasureCommand command = new UnitOfMeasureToUnitOfMeasureCommand();
    UnitOfMeasureService service;

    @Mock
    UnitOfMeasureRepository repository;

    @BeforeEach
    void setUp() {
        service = new UnitOfMeasureServiceImpl(repository, command);
    }

    @Test
    void listAllUoms() {
        Set<UnitOfMeasure> unitOfMeasures = new HashSet<>();
        UnitOfMeasure uom1 = new UnitOfMeasure();
        uom1.setId(1L);
        unitOfMeasures.add(uom1);

        UnitOfMeasure uom2 = new UnitOfMeasure();
        uom1.setId(2L);
        unitOfMeasures.add(uom2);

        when(repository.findAll()).thenReturn(unitOfMeasures);

        Set<UnitOfMeasureCommand> commands = service.listAllUoms();

        assertEquals(2, commands.size());
        verify(repository, times(1)).findAll();
    }
}