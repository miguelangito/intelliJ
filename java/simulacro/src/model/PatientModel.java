package model;

import database.PatientCrud;
import entity.Patient;

import java.util.List;

public class PatientModel implements PatientCrud {

    @Override
    public Patient create(Patient patient) {
        return null;
    }

    @Override
    public List<Patient> findByFilter(String filter, String value) {
        return null;
    }

    @Override
    public void update(Patient patient) {

    }

    @Override
    public void delete(Patient patient) {

    }
}
