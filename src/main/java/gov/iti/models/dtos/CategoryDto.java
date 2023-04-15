package gov.iti.models.dtos;

import gov.iti.models.entities.Category;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.io.Serializable;
import java.time.Instant;

/**
 * A DTO for the {@link Category} entity
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Data
public class CategoryDto implements Serializable , SakilaDtos {
    private int id;
    @Size(max = 25)
    @NotNull
    private  String name;
    @NotNull
    private  Instant lastUpdate;
}