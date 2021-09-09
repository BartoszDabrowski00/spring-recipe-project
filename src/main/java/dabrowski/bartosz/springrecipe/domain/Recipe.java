package dabrowski.bartosz.springrecipe.domain;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.HashSet;
import java.util.Set;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Document
public class Recipe {

    @Id
    private String id;
    private String description;
    private Integer prepTime;
    private Integer cookTime;
    private Integer servings;
    private String source;
    private String url;
    private String directions;

    @DBRef
    private Set<Category> categories = new HashSet<>();
    private Set<Ingredient> ingredients = new HashSet<>();

    private Byte[] image;
    private Notes notes;
    private Difficulty difficulty;

    public void addIngredient(Ingredient ingredient) {
        this.ingredients.add(ingredient);
    }
}
