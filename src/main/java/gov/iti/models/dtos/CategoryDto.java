package gov.iti.models.dtos;

import gov.iti.models.entities.Category;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import jakarta.ws.rs.core.Link;
import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.*;

import java.io.Serializable;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

/**
 * A DTO for the {@link Category} entity
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Data
@XmlRootElement
public class CategoryDto implements Serializable , SakilaDtos {
    private int id;
    @Size(max = 25)
    @NotNull
    private  String name;
    @NotNull
    private  Instant lastUpdate;
    List <Link>links=new ArrayList<>();

}