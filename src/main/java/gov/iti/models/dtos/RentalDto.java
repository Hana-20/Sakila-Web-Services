package gov.iti.models.dtos;

import jakarta.validation.constraints.NotNull;
import jakarta.xml.bind.annotation.XmlRootElement;
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
@XmlRootElement
public class RentalDto implements Serializable, SakilaDtos {
    private  Integer id;
    @NotNull
    private  Instant rentalDate;
    @NotNull
    private  Integer inventoryId;
    @NotNull
    private  Integer customerId;
    private  Instant returnDate;
    @NotNull
    private  Integer staffId;
    @NotNull
    private  Instant lastUpdate;
}