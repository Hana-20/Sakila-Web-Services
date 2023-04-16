//package gov.iti.models.mappers;
//
//import gov.iti.models.dtos.FilmDto;
//import gov.iti.models.dtos.SakilaDtos;
//import gov.iti.models.entities.Film;
//import gov.iti.models.entities.SakilaEntities;
//import org.modelmapper.ModelMapper;
//
//public class FilmMapper implements SakilaMapper{
//    private final ModelMapper modelMapper;
//
//    public  FilmMapper(ModelMapper modelMapper) {
//        this.modelMapper = modelMapper;
//    }
//
//    @Override
//    public SakilaDtos toDto(SakilaEntities entity) {
//        return modelMapper.map(entity, FilmDto.class);
//    }
//
//    @Override
//    public SakilaEntities toEntity(SakilaDtos dto) {
//        return modelMapper.map(dto, Film.class);
//    }
//}
