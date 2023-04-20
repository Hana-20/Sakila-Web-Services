// package gov.iti.models.mappers;

// import org.hibernate.cfg.Configuration;
// import org.modelmapper.ModelMapper;

// public class SakilaMapper<T extends SakilaDtos ,A extends SakilaEntities>  {

//     private final ModelMapper modelMapper;

//     public SakilaMapper(ModelMapper modelMapper) {
//         this.modelMapper = modelMapper;
        
//         // Add custom configuration to ignore lazy-loaded properties
//         modelMapper.getConfiguration()
//                 .setPropertyCondition(Conditions.isNotNull())
//                 .setSkipNullEnabled(true)
//                 .setMatchingStrategy(MatchingStrategies.STRICT)
//                 .setAmbiguityIgnored(true)
//                 .setDeepCopyEnabled(true)
//                 .setFieldMatchingEnabled(true)
//                 .setMethodAccessLevel(AccessLevel.PROTECTED);
//     }

//     public SakilaDtos toDto(SakilaEntities entity,Class<T> dtoClass) {
//         return modelMapper.map(entity, dtoClass);
//     }

//     public SakilaEntities toEntity(SakilaDtos dto,Class<A> entityClass) {
//         return modelMapper.map(dto, entityClass);
//     }
// }

