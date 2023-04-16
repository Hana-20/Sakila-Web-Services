//package gov.iti.models.mappers;
//
//import gov.iti.models.dtos.LanguageDto;
//import gov.iti.models.dtos.SakilaDtos;
//import gov.iti.models.entities.Language;
//import gov.iti.models.entities.SakilaEntities;
//import org.modelmapper.ModelMapper;
//
//public class LanguageMapper implements SakilaMapper{
//    private final ModelMapper modelMapper;
//
//    public LanguageMapper(ModelMapper modelMapper) {
//        this.modelMapper = modelMapper;
//    }
//
//    @Override
//    public SakilaDtos toDto(SakilaEntities entity) {
//        return modelMapper.map(entity, LanguageDto.class);
//    }
//
//    @Override
//    public SakilaEntities toEntity(SakilaDtos dto) {
//        return modelMapper.map(dto, Language.class);
//    }
//}
