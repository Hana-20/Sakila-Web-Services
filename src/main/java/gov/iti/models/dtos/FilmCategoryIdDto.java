package gov.iti.models.dtos;

import lombok.*;

import java.io.Serializable;

import jakarta.xml.bind.annotation.XmlRootElement;

/**
 * A DTO for the {@link gov.iti.models.entities.FilmCategoryId} entity
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Data
@XmlRootElement
public class FilmCategoryIdDto implements Serializable , SakilaDtos {
    private  Integer filmId;
    private  Short categoryId;
}