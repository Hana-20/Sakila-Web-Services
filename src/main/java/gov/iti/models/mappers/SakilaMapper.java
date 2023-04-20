package gov.iti.models.mappers;

import gov.iti.models.dtos.ActorDto;
import gov.iti.models.dtos.RentalDto;
import gov.iti.models.dtos.SakilaDtos;
import gov.iti.models.entities.Actor;
import gov.iti.models.entities.Rental;
import gov.iti.models.entities.SakilaEntities;

import org.modelmapper.Conditions;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;
import org.modelmapper.config.Configuration.AccessLevel;
import org.modelmapper.convention.MatchingStrategies;
import org.modelmapper.Condition;
import org.modelmapper.Conditions;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.modelmapper.spi.MappingContext;

public class SakilaMapper<T extends SakilaDtos ,A extends SakilaEntities>  {

    private final ModelMapper modelMapper;

    public SakilaMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
        modelMapper.getConfiguration().setSkipNullEnabled(true);

    }
    

    public SakilaDtos toDto(SakilaEntities entity,Class<T> dtoClass) {
        return modelMapper.map(entity, dtoClass);
    }

    public SakilaEntities toEntity(SakilaDtos dto,Class<A> entityClass) {
        return modelMapper.map(dto, entityClass);
    }
}

