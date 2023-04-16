//package gov.iti.models.mappers;
//
//import gov.iti.models.dtos.SakilaDtos;
//import gov.iti.models.dtos.StoreDto;
//import gov.iti.models.entities.SakilaEntities;
//import gov.iti.models.entities.Store;
//import org.modelmapper.ModelMapper;
//
//public class StoreMapper implements SakilaMapper{
//    private final ModelMapper modelMapper;
//
//    public StoreMapper(ModelMapper modelMapper) {
//        this.modelMapper = modelMapper;
//    }
//
//    @Override
//    public SakilaDtos toDto(SakilaEntities entity) {
//        return modelMapper.map(entity, StoreDto.class);
//    }
//
//    @Override
//    public SakilaEntities toEntity(SakilaDtos dto) {
//        return modelMapper.map(dto, Store.class);
//    }
//}
