package gov.iti.models.dtos;

import gov.iti.models.entities.FilmActorId;
import jakarta.ws.rs.core.Link;
import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * A DTO for the {@link FilmActorId} entity
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Data
@XmlRootElement
public class FilmActorIdDto implements Serializable, SakilaDtos {
    private  Integer actorId;
    private  Integer filmId;
    List <Link>links=new ArrayList<>();

}