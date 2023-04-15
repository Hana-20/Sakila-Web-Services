package gov.iti.models.dtos;

import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.io.Serializable;
import java.time.Instant;

/**
 * A DTO for the {@link gov.iti.models.entities.Rental} entity
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Data
public class RentalDto implements Serializable, SakilaDtos {
    private  Integer id;
    @NotNull
    private  Instant rentalDate;
    @NotNull
    private  InventoryDto inventory;
    @NotNull
    private  CustomerDto customer;
    private  Instant returnDate;
    @NotNull
    private  StaffDto staff;
    @NotNull
    private  Instant lastUpdate;
}