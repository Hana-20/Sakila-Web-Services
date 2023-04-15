package gov.iti.services.rest;

import gov.iti.models.dtos.SakilaDtos;
import gov.iti.models.entities.EntityFactory;
import gov.iti.models.entities.SakilaEntities;
import gov.iti.models.mappers.MapperFactory;
import gov.iti.repository.implmentation.RepositoryImpl;

public class CrudServices<T extends SakilaDtos> {
    private Class<T> dtoClass;

    public CrudServices(Class<T> dtoClass){
        this.dtoClass=dtoClass;
    }

public SakilaDtos getdtoById(Integer id){
       Class<?extends SakilaEntities> entityClass= EntityFactory.createEntity(dtoClass);
       var entityRepository =new RepositoryImpl<>(entityClass);
       var entityMapper= MapperFactory.createMapper(dtoClass);
       return  entityMapper.toDto(entityRepository.getById(id));
}
}
