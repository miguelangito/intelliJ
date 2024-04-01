package model;

import database.MedicCrud;
import entity.Medic;

import java.util.List;

public class MedicModel implements MedicCrud {

    @Override
    public Medic create(Medic medic) {
        return null;
    }

    @Override
    public List<Medic> findByFilter(String filter, String value) {
        return null;
    }

    @Override
    public void update(Medic medic) {

    }

    @Override
    public void delete(Medic medic) {

    }
}
