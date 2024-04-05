package entity;

public class Medic {

    private int idMedic;
    private String name;
    private String lastName;
    private Integer idEspeciality;
    private Speciality objEspeciality;

    public Medic() {
    }

    public Medic(String name, String lastName, Integer idEspeciality, Speciality objEspeciality) {
        this.name = name;
        this.lastName = lastName;
        this.idEspeciality = idEspeciality;
        this.objEspeciality = objEspeciality;
    }

    public int getIdMedic() {
        return idMedic;
    }

    public void setIdMedic(int idMedic) {
        this.idMedic = idMedic;
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

    public Integer getIdEspeciality() {
        return idEspeciality;
    }

    public void setIdEspeciality(Integer idEspeciality) {
        this.idEspeciality = idEspeciality;
    }

    public Speciality getObjEspeciality() {
        return objEspeciality;
    }

    public void setObjEspeciality(Speciality objEspeciality) {
        this.objEspeciality = objEspeciality;
    }

    @Override
    public String toString() {
        return "id: " + idMedic + ", name: " + name + ", lastName: " + lastName + '\n' + "id_Especiality: " + idEspeciality + ", Especiality: " + objEspeciality;
    }
}
