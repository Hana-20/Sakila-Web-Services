package gov.iti.repository.connection;


import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class ConnectionManager {

    private static  EntityManagerFactory entityManagerFactory ;
    private static ConnectionManager instance;

    private ConnectionManager() {
        entityManagerFactory = Persistence.createEntityManagerFactory("HAM");
    }

    public  static ConnectionManager getInstance() {
        synchronized (ConnectionManager.class) {
            if (instance == null) {
                instance = new ConnectionManager();
            }
        }

        return instance;
    }

    public EntityManagerFactory getEntityManagerFactory() {
        return entityManagerFactory;
    }

    public void shutdown() {
        entityManagerFactory.close();
    }
}
