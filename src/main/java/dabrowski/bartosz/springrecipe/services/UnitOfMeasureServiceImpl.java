package dabrowski.bartosz.springrecipe.services;

import dabrowski.bartosz.springrecipe.commands.UnitOfMeasureCommand;
import dabrowski.bartosz.springrecipe.converters.UnitOfMeasureToUnitOfMeasureCommand;
import dabrowski.bartosz.springrecipe.repositories.UnitOfMeasureRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@Slf4j
@AllArgsConstructor
public class UnitOfMeasureServiceImpl implements UnitOfMeasureService {
    private final UnitOfMeasureRepository repository;
    private final UnitOfMeasureToUnitOfMeasureCommand command;

    @Override
    public Set<UnitOfMeasureCommand> listAllUoms() {
        return StreamSupport.stream(repository.findAll()
                .spliterator(), false)
                .map(command::convert)
                .collect(Collectors.toSet());
    }
}
