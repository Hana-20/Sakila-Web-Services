package gov.iti.models.dtos;

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
 * A DTO for the {@link gov.iti.models.entities.Customer} entity
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Data
@XmlRootElement
public class CustomerDto implements Serializable, SakilaDtos {
    private Integer id;
    // @NotNull
    // private StoreDto store;
    @Size(max = 45)
    @NotNull
    private String firstName;
    @Size(max = 45)
    @NotNull
    private String lastName;
    @Size(max = 50)
    private String email;
    @NotNull
    private AddressDto address;
    @NotNull
    private Boolean active;
    @NotNull
    private Date createDate;
    @NotNull
    private Date lastUpdate;
    @NotNull
    private Set<PaymentDto> paymentSet;
     private Set<RentalDto> rentalSet;
     List <Link>links=new ArrayList<>();


}