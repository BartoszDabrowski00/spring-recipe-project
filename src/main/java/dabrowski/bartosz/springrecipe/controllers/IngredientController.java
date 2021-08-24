package dabrowski.bartosz.springrecipe.controllers;

import dabrowski.bartosz.springrecipe.services.RecipeService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Slf4j
@AllArgsConstructor
public class IngredientController {
    private final RecipeService recipeService;

    @GetMapping
    @RequestMapping("/recipe/{recipeId}/ingredients")
    public String listIngredients(@PathVariable String recipeId, Model model){
        log.debug("Listing ingredients for recipe id: " + recipeId);

        model.addAttribute("recipe", recipeService.findCommandById(Long.valueOf(recipeId)));

        return "recipe/ingredients/list";
    }
}
