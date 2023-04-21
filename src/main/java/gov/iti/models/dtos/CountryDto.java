package gov.iti.models.dtos;

import gov.iti.models.entities.Country;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import jakarta.ws.rs.core.Link;
import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.*;

import java.io.Serializable;
import java.sql.Date;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * A DTO for the {@link Country} entity
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Data
@XmlRootElement
public class CountryDto implements Serializable, SakilaDtos {
    private  Integer id;
    @Size(max = 50)
    @NotNull
    private  String country;
    @NotNull
    private  Date lastUpdate;
    @NotNull
    private Set<CityDto> citySet;
    List <Link>links=new ArrayList<>();

}