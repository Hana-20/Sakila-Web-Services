package gov.iti.models.dtos;

import gov.iti.models.entities.Film;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import jakarta.ws.rs.core.Link;
import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

/**
 * A DTO for the {@link Film} entity
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Data
@XmlRootElement
public class FilmDto implements Serializable, SakilaDtos {
    private  Integer id;
    @Size(max = 128)
    @NotNull
    private  String title;
    private  String description;
    private  Integer releaseYear;
    @NotNull
    private  LanguageDto language;
    private  LanguageDto originalLanguage;
    private  Short rentalDuration;
    @NotNull
    private  BigDecimal rentalRate;
    private  Integer length;
    @NotNull
    private  BigDecimal replacementCost;
    @Size(max = 5)
    private  String rating;
    @Size(max = 54)
    private  String specialFeatures;
    @NotNull
    private  Date lastUpdate;
    private Set<FilmCategoryDto> filmCategorySet;
    List <Link>links=new ArrayList<>();

    // private Set<FilmActorDto> filmActorSet;
}