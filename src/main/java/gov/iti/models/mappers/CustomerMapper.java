//package gov.iti.models.mappers;
//
//import gov.iti.models.dtos.CustomerDto;
//import gov.iti.models.dtos.SakilaDtos;
//import gov.iti.models.entities.Customer;
//import gov.iti.models.entities.SakilaEntities;
//import org.modelmapper.ModelMapper;
//
//public class CustomerMapper implements SakilaMapper {
//    private final ModelMapper modelMapper;
//
//    public CustomerMapper(ModelMapper modelMapper) {
//        this.modelMapper = modelMapper;
//    }
//
//    @Override
//    public SakilaDtos toDto(SakilaEntities entity) {
//        return modelMapper.map(entity, CustomerDto.class);
//    }
//
//    @Override
//    public SakilaEntities toEntity(SakilaDtos dto) {
//        return modelMapper.map(dto, Customer.class);
//    }
//}