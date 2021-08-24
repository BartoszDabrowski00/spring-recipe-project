package dabrowski.bartosz.springrecipe.services;

import dabrowski.bartosz.springrecipe.commands.IngredientCommand;
import dabrowski.bartosz.springrecipe.converters.IngredientToIngredientCommand;
import dabrowski.bartosz.springrecipe.domain.Recipe;
import dabrowski.bartosz.springrecipe.repositories.RecipeRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
@AllArgsConstructor
public class IngredientServiceImpl implements IngredientService {

    private final IngredientToIngredientCommand ingredientCommand;
    private final RecipeRepository recipeRepository;

    @Override
    public IngredientCommand findByRecipeIdIngredientId(Long recipeId, Long ingredientId) {
        Recipe recipe = recipeRepository.findById(recipeId).orElseThrow(()-> new RuntimeException("Error "));
        Optional<IngredientCommand> ingredientCommandOptional = recipe.getIngredients().stream()
                .filter(ingredient -> ingredient.getId().equals(ingredientId))
                .map(ingredientCommand::convert).findFirst();
        return ingredientCommandOptional.orElseThrow(()->new RuntimeException("Error"));
    }
}
