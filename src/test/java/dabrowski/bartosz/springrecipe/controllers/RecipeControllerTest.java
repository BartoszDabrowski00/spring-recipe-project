package dabrowski.bartosz.springrecipe.controllers;

import dabrowski.bartosz.springrecipe.commands.RecipeCommand;
import dabrowski.bartosz.springrecipe.domain.Recipe;
import dabrowski.bartosz.springrecipe.exceptions.NotFoundException;
import dabrowski.bartosz.springrecipe.repositories.RecipeRepository;
import dabrowski.bartosz.springrecipe.services.RecipeService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(MockitoExtension.class)
class RecipeControllerTest {

    @Mock
    RecipeService recipeService;

    @Mock
    RecipeRepository recipeRepository;

    RecipeController controller;

    @BeforeEach
    void setUp() {
        controller = new RecipeController(recipeService);
    }

    @Test
    void testGetRecipe() throws Exception {
        Recipe recipe = Recipe.builder().id("1").build();

        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(controller).build();

        when(recipeService.findById(anyString())).thenReturn(recipe);

        mockMvc.perform(get("/recipe/1/show"))
                .andExpect(status().isOk())
                .andExpect(view().name("recipe/show"))
                .andExpect(model().attributeExists("recipe"));
    }

    @Test
    void testGetNewRecipeForm() throws Exception {
        MockMvcBuilders.standaloneSetup(controller).build()
                .perform(get("/recipe/new"))
                .andExpect(status().isOk())
                .andExpect(view().name("recipe/recipeform"))
                .andExpect(model().attributeExists("recipe"));
    }

    @Test
    void testPostNewRecipeForm() throws Exception {
        RecipeCommand command = new RecipeCommand();
        command.setId("2");

        when(recipeService.saveRecipeCommand(any())).thenReturn(command);

        MockMvcBuilders.standaloneSetup(controller).build()
                .perform(post("/recipe")
                        .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                        .param("id", "")
                        .param("description", "some string")
                        .param("directions", "some string"))
                .andExpect(status().is3xxRedirection())
                .andExpect(view().name("redirect:/recipe/2/show"));
    }

    @Test
    void testDeleteAction() throws Exception {
        MockMvcBuilders.standaloneSetup(controller).build()
                .perform(get("/recipe/1/delete"))
                .andExpect(status().is3xxRedirection())
                .andExpect(view().name("redirect:/"));
        verify(recipeService, times(1)).deleteById(anyString());
    }

    @Test
    void getRecipeByIdTestNotFound() throws Exception {
        when(recipeService.findById(anyString())).thenThrow(NotFoundException.class);

        MockMvcBuilders.standaloneSetup(controller).build()
                .perform(get("/recipe/1/show"))
                .andExpect(status().isNotFound());
    }

    @Test
    void testGetRecipeNotFound() throws Exception{
        when(recipeService.findById(anyString())).thenThrow(NotFoundException.class);

        MockMvcBuilders.standaloneSetup(controller).build()
                .perform(get("/recipe/5/show"))
                .andExpect(status().isNotFound())
                .andExpect(view().name("404error"));
    }

    @Test
    void test400Error() throws Exception{
        MockMvcBuilders.standaloneSetup(controller).setControllerAdvice(new ExceptionHandlerController()).build()
                .perform(get("/recipe/asd/show"))
                .andExpect(status().isNotFound())
                .andExpect(view().name("404error"));
    }

}