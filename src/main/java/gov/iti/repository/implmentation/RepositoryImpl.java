package gov.iti.repository.implmentation;

import java.util.List;

import org.modelmapper.ModelMapper;

import gov.iti.models.dtos.SakilaDtos;
import gov.iti.models.entities.EntityFactory;
import gov.iti.models.entities.SakilaEntities;
import gov.iti.models.mappers.SakilaMapper;
import gov.iti.repository.Repository;
import gov.iti.repository.connection.ConnectionManager;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;

public class RepositoryImpl<T extends SakilaEntities> implements Repository<T> {
    static EntityManagerFactory emf = ConnectionManager.getInstance().getEntityManagerFactory();

    private final Class<T> entityClass;

    public RepositoryImpl(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    @Override
    public SakilaEntities getById(Integer id) {
        EntityManager em = emf.createEntityManager();
        T obj = em.find(entityClass, id);
        em.close();
        return obj;
    }

    @Override
    public void delete(Integer id) {
        EntityManager em = emf.createEntityManager();
        // String jpql = "DELETE FROM " + entityClass.getSimpleName() + " e WHERE e.id =
        // :id";
        // Query query = em.createQuery(jpql);
        // query.setParameter("id", id);

        em.getTransaction().begin();
        // int deletedCount = query.executeUpdate();
        T obj = em.find(entityClass, id);
        if (obj != null) {
            em.remove(obj);
            em.getTransaction().commit();
        }
        // System.out.println(deletedCount);
        em.close();

    }

    @Override
    public void update(SakilaDtos dto) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        T entity = (T) new SakilaMapper(new ModelMapper()).toEntity(dto, entityClass);
        T updatedEntity = em.merge(entity);
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public void insert(SakilaDtos dto) {
        EntityManager em = emf.createEntityManager();
        T entity = (T) new SakilaMapper(new ModelMapper()).toEntity(dto, entityClass);
        em.getTransaction().begin();
        em.merge(entity);
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public List<SakilaEntities> findAll() {
        EntityManager em = emf.createEntityManager();
        List<SakilaEntities> entities = em.createQuery("select e from " + entityClass.getSimpleName() + " e")
                .getResultList();
        return entities;
    }
}
