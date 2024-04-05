package entity;

public class Speciality {

    public int idEspeciality;
    private String name;
    private String description;
    public Speciality() {
    }

    public Speciality(int idEspeciality, String name, String description) {
        this.idEspeciality = idEspeciality;
        this.name = name;
        this.description = description;
    }

    public int getIdEspeciality() {
        return idEspeciality;
    }

    public void setIdEspeciality(int idEspeciality) {
        this.idEspeciality = idEspeciality;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return " id: " + idEspeciality + ", name: " + name + ", " + "\n" + "description: " + description;
    }
}
