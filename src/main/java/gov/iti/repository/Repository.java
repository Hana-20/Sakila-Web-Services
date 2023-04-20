package gov.iti.repository;

import java.util.List;

import gov.iti.models.dtos.SakilaDtos;
import gov.iti.models.entities.SakilaEntities;

public interface Repository<T> {

    public SakilaEntities getById(Integer id);

    public void delete(Integer id);

    public void update(SakilaDtos dto);

    public void insert(SakilaDtos dto);

    public List<SakilaEntities> findAll();
}
