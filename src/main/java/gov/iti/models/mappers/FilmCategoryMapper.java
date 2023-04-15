package gov.iti.models.mappers;

import gov.iti.models.dtos.FilmCategoryDto;
import gov.iti.models.dtos.SakilaDtos;
import gov.iti.models.entities.FilmCategory;
import gov.iti.models.entities.SakilaEntities;
import org.modelmapper.ModelMapper;

public class FilmCategoryMapper implements SakilaMapper{
    private final ModelMapper modelMapper;

    public FilmCategoryMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public SakilaDtos toDto(SakilaEntities entity) {
        return modelMapper.map(entity, FilmCategoryDto.class);
    }

    @Override
    public SakilaEntities toEntity(SakilaDtos dto) {
        return modelMapper.map(dto, FilmCategory.class);
    }
}
