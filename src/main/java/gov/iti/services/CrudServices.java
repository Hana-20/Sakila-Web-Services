package gov.iti.services;

import gov.iti.models.dtos.SakilaDtos;
import gov.iti.models.entities.EntityFactory;
import gov.iti.models.entities.SakilaEntities;
import gov.iti.models.mappers.SakilaMapper;
import gov.iti.repository.implmentation.RepositoryImpl;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;

public class CrudServices<T extends SakilaDtos> {
    private Class<T> dtoClass;
    private RepositoryImpl repositoryImpl;
    private Class<? extends SakilaEntities> entityClass;
    private SakilaMapper sakilaMapper = new SakilaMapper(new ModelMapper());

    public CrudServices(Class<T> dtoClass) {
        this.dtoClass = dtoClass;
        entityClass = EntityFactory.createEntity(dtoClass);
        this.repositoryImpl = new RepositoryImpl<>(entityClass);

    }

    public SakilaDtos getdtoById(Integer id) {
        return sakilaMapper.toDto(repositoryImpl.getById(id), dtoClass);
    }

    public void delete(Integer id) {

        repositoryImpl.delete(id);
    }

    public void update(SakilaDtos dto) {

        repositoryImpl.update(dto);
    }

    public void add(SakilaDtos dto) {
       
        repositoryImpl.insert(dto);
    }

    public List<SakilaDtos>findAll(){
        List<SakilaEntities>entities=repositoryImpl.findAll();
        List<SakilaDtos>dtos=new ArrayList<SakilaDtos>();
        entities.forEach(e->dtos.add(sakilaMapper.toDto(e,dtoClass )));
        return dtos;
    }
}
