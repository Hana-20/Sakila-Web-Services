//package gov.iti.models.mappers;
//
//import gov.iti.models.dtos.SakilaDtos;
//import gov.iti.models.entities.SakilaEntities;
//import org.modelmapper.ModelMapper;
//
//import gov.iti.models.dtos.ActorDto;
//import gov.iti.models.entities.Actor;
//
//public class ActorMapper extends SakilaMapper{
//
//    private final ModelMapper modelMapper;
//
//    public ActorMapper(ModelMapper modelMapper) {
//        super(modelMapper);
//
//    }
//
//    @Override
//    public SakilaDtos toDto(SakilaEntities entity) {
//        return modelMapper.map(entity, ActorDto.class);
//    }
//
//    @Override
//    public SakilaEntities toEntity(SakilaDtos dto) {
//        return modelMapper.map(dto, Actor.class);
//    }
//}
