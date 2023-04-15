package gov.iti.models.dtos;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.io.Serializable;
import java.time.Instant;

/**
 * A DTO for the {@link gov.iti.models.entities.Customer} entity
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Data
public class CustomerDto implements Serializable, SakilaDtos {
    private  Integer id;
    @NotNull
    private  StoreDto store;
    @Size(max = 45)
    @NotNull
    private  String firstName;
    @Size(max = 45)
    @NotNull
    private  String lastName;
    @Size(max = 50)
    private  String email;
    @NotNull
    private  AddressDto address;
    @NotNull
    private  Boolean active;
    @NotNull
    private  Instant createDate;
    private  Instant lastUpdate;
}