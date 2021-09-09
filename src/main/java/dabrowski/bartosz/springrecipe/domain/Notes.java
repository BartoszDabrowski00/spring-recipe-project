package dabrowski.bartosz.springrecipe.domain;

import lombok.*;

import java.util.UUID;

@Data
@EqualsAndHashCode(exclude = {"recipe"})
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Notes {

    private String id = UUID.randomUUID().toString();
    private String recipeNotes;
}
