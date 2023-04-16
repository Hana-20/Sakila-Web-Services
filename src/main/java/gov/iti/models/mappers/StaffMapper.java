//package gov.iti.models.mappers;
//
//import gov.iti.models.dtos.SakilaDtos;
//import gov.iti.models.dtos.StaffDto;
//import gov.iti.models.entities.SakilaEntities;
//import gov.iti.models.entities.Staff;
//import org.modelmapper.ModelMapper;
//
//public class StaffMapper implements SakilaMapper {
//    private final ModelMapper modelMapper;
//
//    public StaffMapper(ModelMapper modelMapper) {
//        this.modelMapper = modelMapper;
//    }
//
//    @Override
//    public SakilaDtos toDto(SakilaEntities entity) {
//        return modelMapper.map(entity, StaffDto.class);
//    }
//
//    @Override
//    public SakilaEntities toEntity(SakilaDtos dto) {
//        return modelMapper.map(dto, Staff.class);
//    }
//}
