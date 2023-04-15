package gov.iti.models.dtos;

import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.io.Serializable;
import java.time.Instant;

/**
 * A DTO for the {@link gov.iti.models.entities.Store} entity
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Data
public class StoreDto implements Serializable , SakilaDtos {
    private  Short id;
    @NotNull
    private  StaffDto managerStaff;
    @NotNull
    private  AddressDto address;
    @NotNull
    private  Instant lastUpdate;
}