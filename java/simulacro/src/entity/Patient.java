package entity;

import java.util.Date;

public class Patient {
    private int idPatient;
    private String name;
    private String lastName;
    private Date nacDate;
    private int documentNumber;

    public Patient() {
    }

    public Patient(int idPatient, String name, String lastName, Date nacDate, int documentNumber) {
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

    public Date getNacDate() {
        return nacDate;
    }

    public void setNacDate(Date nacDate) {
        this.nacDate = nacDate;
    }

    public int getDocumentNumber() {
        return documentNumber;
    }

    public void setDocumentNumber(int documentNumber) {
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
