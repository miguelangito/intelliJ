package database;

import entity.Speciality;

import java.util.List;

public interface SpecialityCrud {

    Speciality create(Speciality speciality);

    List<Speciality> findByFilter(String filter, String value);

    boolean update(Speciality speciality);

    boolean delete(Speciality speciality);

    List<Object> listAll();

    Object findById(int id);
}
