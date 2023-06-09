package gov.iti.models.dtos;

import gov.iti.models.entities.FilmText;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import jakarta.ws.rs.core.Link;
import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * A DTO for the {@link FilmText} entity
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Data
@XmlRootElement
public class FilmTextDto implements Serializable, SakilaDtos {
    private  Short id;
    @Size(max = 255)
    @NotNull
    private  String title;
    private  String description;
    List <Link>links=new ArrayList<>();

}