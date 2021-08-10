package dabrowski.bartosz.springrecipe.repositories;

import dabrowski.bartosz.springrecipe.domain.Recipe;
import org.springframework.data.repository.CrudRepository;


public interface RecipeRepository extends CrudRepository<Recipe, Long> {
}
