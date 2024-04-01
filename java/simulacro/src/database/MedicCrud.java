package database;

import entity.Cite;
import entity.Medic;

import java.util.List;

public interface MedicCrud {

    Medic create(Medic medic);

    List<Medic> findByFilter(String filter, String value);

    void update(Medic medic);

    void delete(Medic medic);


}