package database;

import entity.Patient;

import java.util.List;

public interface PatientCrud {

    Patient create(Patient patient);

    List<Patient> findByFilter(String filter, String value);

    void update(Patient patient);

    void delete(Patient patient);


}