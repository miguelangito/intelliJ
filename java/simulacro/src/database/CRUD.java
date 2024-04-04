package database;

import entity.Patient;

import java.util.List;
import java.util.Objects;

public interface CRUD {

    Object create(Object object);

    List<Object> findByFilter(String filter, String value);

    boolean update(Object object);

    boolean delete(Object object);


    Object findById(int id);

    List<Object> listAll();
}