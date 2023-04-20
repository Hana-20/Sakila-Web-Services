package gov.iti.models.dtos;

import gov.iti.models.entities.Address;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.*;

import java.io.Serializable;
import java.sql.Date;
import java.time.Instant;

/**
 * A DTO for the {@link Address} entity
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Data
@XmlRootElement
public class AddressDto implements Serializable, SakilaDtos {
    private Integer id;
    @Size(max = 50)
    @NotNull
    private String address;
    @Size(max = 50)
    private String address2;
    @Size(max = 20)
    @NotNull
    private String district;
    // @NotNull
    // private  CityDto city;
    @Size(max = 10)
    private String postalCode;
    @Size(max = 20)
    @NotNull
    private String phone;
    @NotNull
    private Date lastUpdate;
}