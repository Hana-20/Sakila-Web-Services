package gov.iti.models.dtos;

import gov.iti.models.entities.Film;
import gov.iti.models.entities.FilmActor;
import jakarta.validation.constraints.NotNull;
import jakarta.ws.rs.core.Link;
import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.*;

import java.io.Serializable;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

/**
 * A DTO for the {@link FilmActor} entity
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Data
@XmlRootElement
public class FilmActorDto implements Serializable, SakilaDtos {
    private  FilmActorIdDto id;
    @NotNull
    private  Instant lastUpdate;
    private FilmDto film;
    List <Link>links=new ArrayList<>();

}