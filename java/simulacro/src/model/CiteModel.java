package model;

import database.CRUD;

import java.util.List;

public class CiteModel implements CRUD {

    @Override
    public Object create(Object object) {
        return null;
    }

    @Override
    public List<Object> findByFilter(String filter, String value) {
        return null;
    }

    @Override
    public boolean update(Object object) {
        return false;
    }

    @Override
    public boolean delete(Object object) {
        return false;
    }

    @Override
    public Object findById(int id) {
        return null;
    }

    @Override
    public List<Object> listAll() {
        return null;
    }
}
