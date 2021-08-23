package dabrowski.bartosz.springrecipe.services;

import dabrowski.bartosz.springrecipe.commands.RecipeCommand;
import dabrowski.bartosz.springrecipe.converters.RecipeCommandToRecipe;
import dabrowski.bartosz.springrecipe.converters.RecipeToRecipeCommand;
import dabrowski.bartosz.springrecipe.domain.Recipe;
import dabrowski.bartosz.springrecipe.repositories.RecipeRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
@Slf4j
@AllArgsConstructor
public class RecipeServiceImpl implements RecipeService{

    private final RecipeRepository recipeRepository;
    private final RecipeCommandToRecipe recipeCommandToRecipe;
    private final RecipeToRecipeCommand recipeToRecipeCommand;

    @Override
    public Set<Recipe> getRecipes() {
        log.debug("I'm in the service");

        Set<Recipe> recipeSet = new HashSet<>();
        recipeRepository.findAll().iterator().forEachRemaining(recipeSet::add);
        return recipeSet;
    }

    @Override
    public Recipe findById(Long l) {
        return recipeRepository.findById(l).orElseThrow(()->new RuntimeException("Recipe not found"));
    }

    @Override
    @Transactional
    public RecipeCommand saveRecipeCommand(RecipeCommand recipeCommand){
        Recipe savedRecipe = recipeRepository.save(recipeCommandToRecipe.convert(recipeCommand));
        log.debug("Saved RecipeID: " + savedRecipe.getId());
        return recipeToRecipeCommand.convert(savedRecipe);
    }
}
