//package gov.iti.models.mappers;
//
//import gov.iti.models.dtos.FilmActorDto;
//import gov.iti.models.dtos.SakilaDtos;
//import gov.iti.models.entities.FilmActor;
//import gov.iti.models.entities.SakilaEntities;
//import org.modelmapper.ModelMapper;
//
//public class FilmActorMapper implements SakilaMapper{
//
//    private final ModelMapper modelMapper;
//
//    public FilmActorMapper(ModelMapper modelMapper) {
//        this.modelMapper = modelMapper;
//    }
//
//    @Override
//    public SakilaDtos toDto(SakilaEntities entity) {
//        return modelMapper.map(entity, FilmActorDto.class);
//    }
//
//    @Override
//    public SakilaEntities toEntity(SakilaDtos dto) {
//        return modelMapper.map(dto, FilmActor.class);
//    }
//}
