package gov.iti.models.dtos;

import jakarta.validation.constraints.NotNull;
import jakarta.xml.bind.annotation.XmlRootElement;
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
@XmlRootElement
public class FilmCategoryDto implements Serializable, SakilaDtos {
    private  FilmCategoryIdDto id;
    private  CategoryDto category;
    @NotNull
    private  Instant lastUpdate;
}