package database;

import entity.Speciality;

import java.util.List;

public interface SpecialityCrud {

    Speciality create(Speciality speciality);

    List<Speciality> findByFilter(String filter, String value);

    void update(Speciality speciality);

    void delete(Speciality speciality);


}
