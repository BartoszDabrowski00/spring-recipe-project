package dabrowski.bartosz.springrecipe.domain;

import lombok.*;

import javax.persistence.*;

@Entity
@Data
@EqualsAndHashCode(exclude = {"recipe"})
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Notes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private Recipe recipe;

    @Lob
    private String recipeNotes;
}
