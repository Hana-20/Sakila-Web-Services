//package gov.iti.models.mappers;
//
//import gov.iti.models.dtos.PaymentDto;
//import gov.iti.models.dtos.SakilaDtos;
//import gov.iti.models.entities.Payment;
//import gov.iti.models.entities.SakilaEntities;
//import org.modelmapper.ModelMapper;
//
//public class PaymentMapper implements SakilaMapper{
//
//    private final ModelMapper modelMapper;
//
//    public PaymentMapper(ModelMapper modelMapper) {
//        this.modelMapper = modelMapper;
//    }
//
//    @Override
//    public SakilaDtos toDto(SakilaEntities entity) {
//        return modelMapper.map(entity, PaymentDto.class);
//    }
//
//    @Override
//    public SakilaEntities toEntity(SakilaDtos dto) {
//        return modelMapper.map(dto, Payment.class);
//    }
//}
