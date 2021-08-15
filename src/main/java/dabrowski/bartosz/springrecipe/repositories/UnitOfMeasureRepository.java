package dabrowski.bartosz.springrecipe.repositories;

import dabrowski.bartosz.springrecipe.domain.UnitOfMeasure;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UnitOfMeasureRepository extends CrudRepository<UnitOfMeasure, Long> {

    Optional<UnitOfMeasure> findUnitOfMeasuresByDescription(String description);
}
