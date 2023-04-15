package gov.iti.models.dtos;

import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.io.Serializable;
import java.time.Instant;

/**
 * A DTO for the {@link gov.iti.models.entities.FilmCategory} entity
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Data
public class FilmCategoryDto implements Serializable, SakilaDtos {
    private  FilmCategoryIdDto id;
    private  FilmDto film;
    private  CategoryDto category;
    @NotNull
    private  Instant lastUpdate;
}