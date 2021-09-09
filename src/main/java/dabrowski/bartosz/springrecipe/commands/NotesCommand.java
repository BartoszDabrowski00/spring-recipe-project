package dabrowski.bartosz.springrecipe.commands;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class NotesCommand {
    private String id;
    private String recipeNotes;
}
