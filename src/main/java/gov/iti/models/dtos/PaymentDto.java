package gov.iti.models.dtos;

import jakarta.validation.constraints.NotNull;
import jakarta.ws.rs.core.Link;
import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

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
    private  Integer customerId;
    @NotNull
    private  Integer staffId;
    private Integer rental;
    @NotNull
    private  BigDecimal amount;
    @NotNull
    private  Instant paymentDate;
    @NotNull
    private  Instant lastUpdate;
    List <Link>links=new ArrayList<>();

}