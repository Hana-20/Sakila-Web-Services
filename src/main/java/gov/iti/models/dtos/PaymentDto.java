package gov.iti.models.dtos;

import jakarta.validation.constraints.NotNull;
import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.Instant;

/**
 * A DTO for the {@link gov.iti.models.entities.Payment} entity
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Data
@XmlRootElement
public class PaymentDto implements Serializable, SakilaDtos {
    private  Integer id;
    @NotNull
    private  CustomerDto customer;
    @NotNull
    private  StaffDto staff;
    private  RentalDto rental;
    @NotNull
    private  BigDecimal amount;
    @NotNull
    private  Instant paymentDate;
    private  Instant lastUpdate;
}