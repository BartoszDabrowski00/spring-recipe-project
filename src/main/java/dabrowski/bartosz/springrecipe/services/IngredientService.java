package dabrowski.bartosz.springrecipe.services;

import dabrowski.bartosz.springrecipe.commands.IngredientCommand;

public interface IngredientService {
    IngredientCommand findByRecipeIdIngredientId(String recipeId, String ingredientId);
    IngredientCommand saveIngredientCommand(IngredientCommand command);
    void deleteById(String recipeId, String ingredientId);
}
