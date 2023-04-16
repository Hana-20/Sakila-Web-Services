package gov.iti.models.mappers;

import gov.iti.models.dtos.RentalDto;
import gov.iti.models.dtos.SakilaDtos;
import gov.iti.models.entities.Rental;
import gov.iti.models.entities.SakilaEntities;

import org.modelmapper.ModelMapper;

public class SakilaMapper<T extends SakilaDtos ,A extends SakilaEntities>  {

    private final ModelMapper modelMapper;

    public SakilaMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
        
    }

    public SakilaDtos toDto(SakilaEntities entity,Class<T> dtoClass) {
        return modelMapper.map(entity, dtoClass);
    }

    public SakilaEntities toEntity(SakilaDtos dto,Class<A> entityClass) {
        return modelMapper.map(dto, entityClass);
    }
}
