package gov.iti.models.dtos;

import gov.iti.models.entities.Actor;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.io.Serializable;
import java.time.Instant;

/**
 * A DTO for the {@link Actor} entity
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Data
public class ActorDto implements Serializable , SakilaDtos {
    private  Integer id;
    @Size(max = 45)
    @NotNull
    private String firstName;
    @Size(max = 45)
    @NotNull
    private String lastName;
    @NotNull
    private  Instant lastUpdate;

    @NotNull
    private  final Class entityClass=Actor.class;
}