package gov.iti.models.dtos;

import gov.iti.models.entities.Address;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import jakarta.ws.rs.core.Link;
import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.*;

import java.io.Serializable;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
    private Integer addressId;
    @Size(max = 50)
    @NotNull
    private String address;
    @Size(max = 50)
    private String address2;
    @Size(max = 20)
    @NotNull
    private String district;
    @NotNull
    private  Integer cityId;
    @NotNull
    private byte[] location;
    @Size(max = 10)
    private String postalCode;
    @Size(max = 20)
    @NotNull
    private String phone;
    @NotNull
    private Date lastUpdate;
    List <Link>links=new ArrayList<>();
}