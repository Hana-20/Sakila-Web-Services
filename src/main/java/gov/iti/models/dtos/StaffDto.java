package gov.iti.models.dtos;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import jakarta.ws.rs.core.Link;
import lombok.*;

import java.io.Serializable;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * A DTO for the {@link gov.iti.models.entities.Staff} entity
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Data
public class StaffDto implements Serializable, SakilaDtos {
    private  Short id;
    @Size(max = 45)
    @NotNull
    private  String firstName;
    @Size(max = 45)
    @NotNull
    private  String lastName;
    // @NotNull
    // private AddressDto address;
    private  byte[] picture;
    @Size(max = 50)
    private  String email;
    @NotNull
    private  Integer storeId;
    @NotNull
    private  Boolean active;
    @Size(max = 16)
    @NotNull
    private  String username;
    @Size(max = 40)
    private  String password;
    @NotNull
    private  Instant lastUpdate;
    @NotNull
    private Set<RentalDto> rentalSet;
    @NotNull
    private Set<PaymentDto> paymentSet;
    List <Link>links=new ArrayList<>();


}