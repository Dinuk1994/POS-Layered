package doa;

import java.util.List;

public interface CrudDao<T> {
    boolean save(T entity);
    boolean update(T entity);
    boolean delete(String id);
    List<T> getAll();

}
