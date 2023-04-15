package gov.iti.repository.implmentation;

import gov.iti.models.entities.SakilaEntities;
import gov.iti.repository.Repository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class RepositoryImpl<T extends SakilaEntities> implements Repository<T> {
    // private final EntityManager em;
    static EntityManagerFactory emf = Persistence.createEntityManagerFactory("HAM");
    private final Class<T> entityClass;

    public RepositoryImpl( Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    @Override
    public T getById(Integer id) {
        EntityManager em = emf.createEntityManager();
        T obj = em.find(entityClass, id);
        em.close();
        return obj;
    }
}
