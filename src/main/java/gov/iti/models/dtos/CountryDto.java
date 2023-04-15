package gov.iti.models.dtos;

import gov.iti.models.entities.Country;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.io.Serializable;
import java.time.Instant;

/**
 * A DTO for the {@link Country} entity
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Data
public class CountryDto implements Serializable, SakilaDtos {
    private  Integer id;
    @Size(max = 50)
    @NotNull
    private  String country;
    @NotNull
    private  Instant lastUpdate;
}