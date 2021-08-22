package dabrowski.bartosz.springrecipe.services;

import dabrowski.bartosz.springrecipe.domain.Recipe;

import java.util.Set;

public interface RecipeService {
    Set<Recipe> getRecipes();
    Recipe findById(Long l);
}
