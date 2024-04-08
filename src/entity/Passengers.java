package entity;

public class Passengers {

    public int id;
    public String name;
    public String lastName;
    public String documentNumber;

    public Passengers() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getDocumentNumber() {
        return documentNumber;
    }

    public void setDocumentNumber(String documentNumber) {
        this.documentNumber = documentNumber;
    }

    @Override
    public String toString() {
        return  "id: " + id +
                ", name: " + name +
                ", lastName: " + lastName +
                ", documentNumber: " + documentNumber;
    }
}
