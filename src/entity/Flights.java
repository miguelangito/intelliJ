package entity;

import java.sql.Time;

public class Flights {

    public int id;
    public java.sql.Date dep_date;
    public Time dep_time;
    public String destiny;
    public Integer id_plane;
    public Airplanes objAirplane;

    public Flights() {
    }

    public Flights(int id, java.sql.Date dep_date, Time dep_time, String destiny, Integer id_plane, Airplanes objAirplane) {
        this.id = id;
        this.dep_date = dep_date;
        this.dep_time = dep_time;
        this.destiny = destiny;
        this.id_plane = id_plane;
        this.objAirplane = objAirplane;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public java.sql.Date getDep_date() {
        return dep_date;
    }

    public void setDep_date(java.sql.Date dep_date) {
        this.dep_date = dep_date;
    }

    public Time getDep_time() {
        return dep_time;
    }

    public void setDep_time(Time dep_time) {
        this.dep_time = dep_time;
    }

    public String getDestiny() {
        return destiny;
    }

    public void setDestiny(String destiny) {
        this.destiny = destiny;
    }

    public Integer getId_plane() {
        return id_plane;
    }

    public void setId_plane(Integer id_plane) {
        this.id_plane = id_plane;
    }

    public Airplanes getObjAirplane() {
        return objAirplane;
    }

    public void setObjAirplane(Airplanes objAirplane) {
        this.objAirplane = objAirplane;
    }

    @Override
    public String toString() {
        return  "id: " + id +
                ", dep_date: " + dep_date +
                ", dep_time: " + dep_time +
                ", destiny: " + destiny + '\n' +
                ", id_plane: " + id_plane +
                ", objAirplane: " + objAirplane;
    }
}
