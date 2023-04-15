package gov.iti.models.dtos;

import lombok.*;

import java.io.Serializable;

/**
 * A DTO for the {@link gov.iti.models.entities.FilmCategoryId} entity
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Data
public class FilmCategoryIdDto implements Serializable , SakilaDtos {
    private  Integer filmId;
    private  Short categoryId;
}