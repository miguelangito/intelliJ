package entity;

import java.sql.Date;
import java.sql.Time;

public class Reservations {

    public int id;
    public Date reserv_date;
    public String seat;
    public Integer id_passenger;
    public Passengers objPassenger;
    public Integer id_flight;
    public Flights objFlight;

    public Reservations() {
    }

    public Reservations(int id, Date reserv_date, String seat, Integer id_passenger, Passengers objPassenger, Integer id_flight, Flights objFlight) {
        this.id = id;
        this.reserv_date = reserv_date;
        this.seat = seat;
        this.id_passenger = id_passenger;
        this.objPassenger = objPassenger;
        this.id_flight = id_flight;
        this.objFlight = objFlight;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getReserv_date() {
        return reserv_date;
    }

    public void setReserv_date(Date reserv_date) {
        this.reserv_date = reserv_date;
    }

    public String getSeat() {
        return seat;
    }

    public void setSeat(String seat) {
        this.seat = seat;
    }

    public Integer getId_passenger() {
        return id_passenger;
    }

    public void setId_passenger(Integer id_passenger) {
        this.id_passenger = id_passenger;
    }

    public Passengers getObjPassenger() {
        return objPassenger;
    }

    public void setObjPassenger(Passengers objPassenger) {
        this.objPassenger = objPassenger;
    }

    public Integer getId_flight() {
        return id_flight;
    }

    public void setId_flight(Integer id_flight) {
        this.id_flight = id_flight;
    }

    public Flights getObjFlight() {
        return objFlight;
    }

    public void setObjFlight(Flights objFlight) {
        this.objFlight = objFlight;
    }

    @Override
    public String toString() {
        return  "id: " + id +
                ", reserv_date: " + reserv_date +
                ", seat: " + seat + '\n' +
                ", id_passenger: " + id_passenger +
                ", objPassenger: " + objPassenger +
                ", id_flight: " + id_flight +
                ", objFlight: " + objFlight;
    }
}
