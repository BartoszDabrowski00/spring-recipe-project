package dabrowski.bartosz.springrecipe.services;

import dabrowski.bartosz.springrecipe.commands.IngredientCommand;

public interface IngredientService {
    IngredientCommand findByRecipeIdIngredientId(Long recipeId, Long ingredientId);
    IngredientCommand saveIngredientCommand(IngredientCommand command);
    void deleteById(Long recipeId, Long ingredientId);
}
