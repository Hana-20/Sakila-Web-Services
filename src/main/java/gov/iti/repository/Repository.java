package gov.iti.repository;

public interface Repository<T> {

    public T getById(Integer id);

}
