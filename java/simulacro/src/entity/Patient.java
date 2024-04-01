package entity;

import java.util.Date;

public class Patient {
    private int idPatient;
    private String name;
    private String lastName;
    private Date nacDate;
    private String documentNumber;

    public Patient() {
    }

    public Patient(int idPatient, String name, String lastName, Date nacDate, String documentNumber) {
        this.idPatient = idPatient;
        this.name = name;
        this.lastName = lastName;
        this.nacDate = nacDate;
        this.documentNumber = documentNumber;
    }

    public int getIdPatient() {
        return idPatient;
    }

    public void setIdPatient(int idPatient) {
        this.idPatient = idPatient;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public java.sql.Date getNacDate() {
        return (java.sql.Date) nacDate;
    }

    public void setNacDate(Date nacDate) {
        this.nacDate = nacDate;
    }

    public String getDocumentNumber() {
        return documentNumber;
    }

    public void setDocumentNumber(String documentNumber) {
        this.documentNumber = documentNumber;
    }

    @Override
    public String toString() {
        return "Patient{" +
                "idPatient=" + idPatient +
                ", name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", nacDate=" + nacDate +
                ", documentNumber=" + documentNumber +
                '}';
    }
}
