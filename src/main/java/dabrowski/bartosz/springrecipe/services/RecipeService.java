package dabrowski.bartosz.springrecipe.services;

import dabrowski.bartosz.springrecipe.commands.RecipeCommand;
import dabrowski.bartosz.springrecipe.domain.Recipe;

import java.util.Set;

public interface RecipeService {
    Set<Recipe> getRecipes();
    Recipe findById(String l);
    RecipeCommand saveRecipeCommand(RecipeCommand command);
    RecipeCommand findCommandById(String l);
    void deleteById(String l);
}
