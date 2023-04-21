package gov.iti.models.dtos;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import jakarta.ws.rs.core.Link;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

/**
 * A DTO for the {@link Actor} entity
 */
@Data
@AllArgsConstructor
@NoArgsConstructor

public class ActorDto implements Serializable, SakilaDtos {
    private Integer id;
    @Size(max = 45)
    @NotNull
    private String firstName;
    @Size(max = 45)
    @NotNull
    private String lastName;
    @NotNull
    private Date lastUpdate;
    @NotNull
    private Set<FilmActorDto> filmActorSet;
    List <Link>links=new ArrayList<>();
}