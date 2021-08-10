package dabrowski.bartosz.springrecipe.repositories;

import dabrowski.bartosz.springrecipe.domain.Category;
import org.springframework.data.repository.CrudRepository;

public interface CategoryRepository extends CrudRepository<Category, Long> {
}
