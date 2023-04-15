package gov.iti.models.dtos;

import gov.iti.models.entities.City;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.io.Serializable;
import java.time.Instant;

/**
 * A DTO for the {@link City} entity
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Data
public class CityDto implements Serializable, SakilaDtos {
    private  Integer id;
    @Size(max = 50)
    @NotNull
    private String city;
    @NotNull
    private  CountryDto country;
    @NotNull
    private  Instant lastUpdate;
}