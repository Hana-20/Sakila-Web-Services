//package gov.iti.models.mappers;
//
//import gov.iti.models.dtos.CountryDto;
//import gov.iti.models.dtos.SakilaDtos;
//import gov.iti.models.entities.Country;
//import gov.iti.models.entities.SakilaEntities;
//import org.modelmapper.ModelMapper;
//
//public class CountryMapper implements SakilaMapper{
//    private final ModelMapper modelMapper;
//
//    public  CountryMapper(ModelMapper modelMapper) {
//        this.modelMapper = modelMapper;
//    }
//
//    @Override
//    public SakilaDtos toDto(SakilaEntities entity) {
//        return modelMapper.map(entity, CountryDto.class);
//    }
//
//    @Override
//    public SakilaEntities toEntity(SakilaDtos dto) {
//        return modelMapper.map(dto, Country.class);
//    }
//}
