package gov.iti.models.dtos;

import jakarta.validation.constraints.NotNull;
import jakarta.ws.rs.core.Link;
import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.*;

import java.io.Serializable;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

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
    // @NotNull
    // private StoreDto store;
    @NotNull
    private  Instant lastUpdate;
    List <Link>links=new ArrayList<>();

}