package gov.iti.models.dtos;

import jakarta.validation.constraints.NotNull;
import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.*;

import java.io.Serializable;
import java.time.Instant;

/**
 * A DTO for the {@link gov.iti.models.entities.Inventory} entity
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Data
@XmlRootElement
public class InventoryDto implements Serializable, SakilaDtos {
    private Integer id;
    @NotNull
    private FilmDto film;
    @NotNull
    private StoreDto store;
    @NotNull
    private  Instant lastUpdate;
}