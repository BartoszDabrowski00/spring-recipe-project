package dabrowski.bartosz.springrecipe.services;

import dabrowski.bartosz.springrecipe.commands.RecipeCommand;
import dabrowski.bartosz.springrecipe.converters.RecipeCommandToRecipe;
import dabrowski.bartosz.springrecipe.converters.RecipeToRecipeCommand;
import dabrowski.bartosz.springrecipe.domain.Recipe;
import dabrowski.bartosz.springrecipe.exceptions.NotFoundException;
import dabrowski.bartosz.springrecipe.repositories.RecipeRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;

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
    public Recipe findById(String l) {
        Optional<Recipe> recipeOptional = recipeRepository.findById(l);
        if(recipeOptional.isEmpty()){
            throw new NotFoundException("Recipe not found for id: " + l);
        }
        return recipeOptional.get();
    }

    @Override
    public RecipeCommand saveRecipeCommand(RecipeCommand recipeCommand){
        Recipe detachedRecipe = recipeCommandToRecipe.convert(recipeCommand);
        detachedRecipe.setId(UUID.randomUUID().toString());

        Recipe savedRecipe = recipeRepository.save(detachedRecipe);
        log.debug("Saved RecipeId:" + savedRecipe.getId());
        return recipeToRecipeCommand.convert(savedRecipe);
    }

    @Override
    public RecipeCommand findCommandById(String l) {
        return recipeToRecipeCommand.convert(findById(l));
    }

    @Override
    public void deleteById(String l) {
        recipeRepository.deleteById(l);
    }
}
