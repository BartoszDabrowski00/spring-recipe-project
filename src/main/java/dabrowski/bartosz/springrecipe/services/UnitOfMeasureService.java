package dabrowski.bartosz.springrecipe.services;

import dabrowski.bartosz.springrecipe.commands.UnitOfMeasureCommand;

import java.util.Set;

public interface UnitOfMeasureService {
    Set<UnitOfMeasureCommand> listAllUoms();
}
