package database;

import java.util.List;

public interface CRUD {

    Object create(Object object);

    List<Object> listAll();

    boolean update(Object object);

    boolean delete(Object object);

    List<Object> filter(String filter, String value);

    Object findById(int id);

}
