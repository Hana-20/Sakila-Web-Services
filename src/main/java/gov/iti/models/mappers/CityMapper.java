package gov.iti.models.mappers;

import gov.iti.models.dtos.CityDto;
import gov.iti.models.dtos.SakilaDtos;
import gov.iti.models.entities.City;
import gov.iti.models.entities.SakilaEntities;
import org.modelmapper.ModelMapper;

public class CityMapper implements  SakilaMapper {
    private final ModelMapper modelMapper;

    public  CityMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

      @Override
    public SakilaDtos toDto(SakilaEntities entity) {
        return modelMapper.map(entity, CityDto.class);
    }

    @Override
    public SakilaEntities toEntity(SakilaDtos dto) {
        return modelMapper.map(dto, City.class);
    }
}
