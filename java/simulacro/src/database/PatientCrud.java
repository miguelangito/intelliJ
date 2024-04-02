package database;

import entity.Patient;

import java.util.List;
import java.util.Objects;

public interface PatientCrud {

    Patient create(Patient patient);

    List<Patient> findByFilter(String filter, String value);

    void update(Patient patient);

    void delete(Patient patient);


    Object findById(int id);

    List<Object> listAll();
}