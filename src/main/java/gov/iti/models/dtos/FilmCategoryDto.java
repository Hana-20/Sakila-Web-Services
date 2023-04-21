package gov.iti.models.dtos;

import jakarta.validation.constraints.NotNull;
import jakarta.ws.rs.core.Link;
import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.*;

import java.io.Serializable;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

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
    List <Link>links=new ArrayList<>();

}