package gov.iti.models.mappers;

import gov.iti.models.dtos.SakilaDtos;
import gov.iti.models.entities.SakilaEntities;

public interface SakilaMapper {

    public SakilaDtos toDto(SakilaEntities entity);
    public SakilaEntities toEntity(SakilaDtos dto);
}
