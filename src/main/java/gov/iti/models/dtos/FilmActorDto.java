package gov.iti.models.dtos;

import gov.iti.models.entities.FilmActor;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.io.Serializable;
import java.time.Instant;

/**
 * A DTO for the {@link FilmActor} entity
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Data
public class FilmActorDto implements Serializable, SakilaDtos {
    private  FilmActorIdDto id;
    private  ActorDto actor;
    private  FilmDto film;
    @NotNull
    private  Instant lastUpdate;
}