//package gov.iti.models.mappers;
//
//import gov.iti.models.dtos.CategoryDto;
//import gov.iti.models.dtos.SakilaDtos;
//import gov.iti.models.entities.Category;
//import gov.iti.models.entities.SakilaEntities;
//import org.modelmapper.ModelMapper;
//
//public class CategoryMapper implements  SakilaMapper{
//
//    private final ModelMapper modelMapper;
//
//    public  CategoryMapper (ModelMapper modelMapper) {
//        this.modelMapper = modelMapper;
//    }
//
//    @Override
//    public SakilaDtos toDto(SakilaEntities entity) {
//        return modelMapper.map(entity, CategoryDto.class);
//    }
//
//    @Override
//    public SakilaEntities toEntity(SakilaDtos dto) {
//        return modelMapper.map( dto,  Category.class);
//    }
//}
