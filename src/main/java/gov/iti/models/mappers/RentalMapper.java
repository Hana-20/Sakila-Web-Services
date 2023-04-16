//package gov.iti.models.mappers;
//
//import gov.iti.models.dtos.RentalDto;
//import gov.iti.models.dtos.SakilaDtos;
//import gov.iti.models.entities.Rental;
//import gov.iti.models.entities.SakilaEntities;
//import org.modelmapper.ModelMapper;
//
//public class RentalMapper implements SakilaMapper{
//    private final ModelMapper modelMapper;
//
//    public RentalMapper(ModelMapper modelMapper) {
//        this.modelMapper = modelMapper;
//    }
//
//    @Override
//    public SakilaDtos toDto(SakilaEntities entity) {
//        return modelMapper.map(entity, RentalDto.class);
//    }
//
//    @Override
//    public SakilaEntities toEntity(SakilaDtos dto) {
//        return modelMapper.map(dto, Rental.class);
//    }
//}
