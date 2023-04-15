package gov.iti.models.dtos;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.io.Serializable;
import java.time.Instant;

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
    @NotNull
    private AddressDto address;
    private  byte[] picture;
    @Size(max = 50)
    private  String email;
    @NotNull
    private  StoreDto store;
    @NotNull
    private  Boolean active;
    @Size(max = 16)
    @NotNull
    private  String username;
    @Size(max = 40)
    private  String password;
    @NotNull
    private  Instant lastUpdate;
}