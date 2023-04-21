package gov.iti.models.dtos;

import gov.iti.models.entities.City;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import jakarta.ws.rs.core.Link;
import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.*;

import java.io.Serializable;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * A DTO for the {@link City} entity
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Data
@XmlRootElement
public class CityDto implements Serializable, SakilaDtos {
    private  Integer id;
    @Size(max = 50)
    @NotNull
    private String city;
    // @NotNull
    // private  CountryDto country;
    @NotNull
    private  Instant lastUpdate;   

    @NotNull
    private Set<AddressDto> addressSet;
    List <Link>links=new ArrayList<>();

}