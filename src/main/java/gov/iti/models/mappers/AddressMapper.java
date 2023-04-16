//
//package gov.iti.models.mappers;
//
//
//import gov.iti.models.dtos.AddressDto;
//import gov.iti.models.dtos.SakilaDtos;
//import gov.iti.models.entities.Address;
//import gov.iti.models.entities.SakilaEntities;
//import org.modelmapper.ModelMapper;
//
//public class AddressMapper implements SakilaMapper {
//
//    private final ModelMapper modelMapper;
//
//    public AddressMapper (ModelMapper modelMapper) {
//        this.modelMapper = modelMapper;
//    }
//
//      @Override
//    public SakilaDtos toDto(SakilaEntities entity) {
//        return modelMapper.map(entity,AddressDto.class);
//    }
//
//    @Override
//    public SakilaEntities toEntity(SakilaDtos dto) {
//        return modelMapper.map(dto, Address.class);
//    }
//}
