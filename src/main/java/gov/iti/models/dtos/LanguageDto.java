package gov.iti.models.dtos;

import gov.iti.models.entities.Language;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.*;

import java.io.Serializable;
import java.time.Instant;

/**
 * A DTO for the {@link Language} entity
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Data
@XmlRootElement
public class LanguageDto implements Serializable, SakilaDtos {
    private  Short id;
    @Size(max = 20)
    @NotNull
    private  String name;
    @NotNull
    private  Instant lastUpdate;
}