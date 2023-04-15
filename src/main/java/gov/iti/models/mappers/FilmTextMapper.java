package gov.iti.models.mappers;

import gov.iti.models.dtos.FilmTextDto;
import gov.iti.models.dtos.SakilaDtos;
import gov.iti.models.entities.FilmText;
import gov.iti.models.entities.SakilaEntities;
import org.modelmapper.ModelMapper;

public class FilmTextMapper implements SakilaMapper{
    private final ModelMapper modelMapper;

    public  FilmTextMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public SakilaDtos toDto(SakilaEntities entity) {
        return modelMapper.map(entity, FilmTextDto.class);
    }

    @Override
    public SakilaEntities toEntity(SakilaDtos dto) {
        return modelMapper.map(dto, FilmText.class);
    }
}
