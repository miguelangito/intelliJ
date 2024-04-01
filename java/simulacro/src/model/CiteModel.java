package model;

import database.CiteCrud;
import entity.Cite;

import java.util.List;

public class CiteModel implements CiteCrud {

    @Override
    public Cite create(Cite cite) {
        return null;
    }

    @Override
    public List<Cite> findByFilter(String filter, String value) {
        return null;
    }

    @Override
    public void update(Cite cite) {

    }

    @Override
    public void delete(Cite cite) {

    }
}
