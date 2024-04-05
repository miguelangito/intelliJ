package entity;

import java.sql.Time;
import java.util.Date;

public class Appointment {

    private int idCite;
    private Integer idPatient;
    private Patient objPatient;
    private Integer idMedic;
    private Medic objMedic;
    private Date citeDate;
    private Time citeTime;
    private String motive;

    public Appointment() {
    }

    public Appointment(Integer idPatient, String motive, Patient objPatient, Integer idMedic, Medic objMedic, Date citeDate, Time citeTime) {
        this.idPatient = idPatient;
        this.objPatient = objPatient;
        this.idMedic = idMedic;
        this.objMedic = objMedic;
        this.citeDate = citeDate;
        this.citeTime = citeTime;
        this.motive = motive;
    }

    public int getIdCite() {
        return idCite;
    }

    public void setIdCite(int idCite) {
        this.idCite = idCite;
    }

    public Integer getIdPatient() {
        return idPatient;
    }

    public void setIdPatient(Integer idPatient) {
        this.idPatient = idPatient;
    }

    public Patient getObjPatient() {
        return objPatient;
    }

    public void setObjPatient(Patient objPatient) {
        this.objPatient = objPatient;
    }

    public Integer getIdMedic() {
        return idMedic;
    }

    public void setIdMedic(Integer idMedic) {
        this.idMedic = idMedic;
    }

    public Medic getObjMedic() {
        return objMedic;
    }

    public void setObjMedic(Medic objMedic) {
        this.objMedic = objMedic;
    }

    public String getMotive() {
        return motive;
    }

    public void setMotive(String motive) {
        this.motive = motive;
    }

    public java.sql.Date getCiteDate() {
        return (java.sql.Date) citeDate;
    }

    public void setCiteDate(Date citeDate) {
        this.citeDate = citeDate;
    }

    public Time getCiteTime() {
        return citeTime;
    }

    public void setCiteTime(Time citeTime) {
        this.citeTime = citeTime;
    }

    @Override
    public String toString() {
        return "Cite{" + "idCite=" + idCite + ", idPatient=" + idPatient + ", objPatient=" + objPatient + ", idMedic=" + idMedic + ", objMedic=" + objMedic + ", citeDate=" + citeDate + ", citeTime=" + citeTime + '}';
    }
}
