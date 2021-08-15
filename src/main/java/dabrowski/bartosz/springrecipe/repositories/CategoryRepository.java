package dabrowski.bartosz.springrecipe.repositories;

import dabrowski.bartosz.springrecipe.domain.Category;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface CategoryRepository extends CrudRepository<Category, Long> {

    Optional<Category> findCategoriesByDescription(String description);
}
