package database;

import entity.Cite;

import java.util.List;

public interface CiteCrud {

    Cite create(Cite cite);

    List<Cite> findByFilter(String filter, String value);

    void update(Cite cite);

    void delete(Cite cite);


}