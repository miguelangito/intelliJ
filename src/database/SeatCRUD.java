package database;

import entity.Seat;

import java.util.List;

public interface SeatCRUD {


    Seat create(Seat seat);

    void update(Seat seat);

    void delete(Integer id);

}

