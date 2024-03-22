package entity;

public class Autor {

    private int autorId;
    private String nombre;
    private String nacionalidad;

    public Autor(int id, String nombre, String nacionalidad) {
        this.autorId = id;
        this.nombre = nombre;
        this.nacionalidad = nacionalidad;
    }

    public Autor() {
    }

    public int getAutorId() {
        return autorId;
    }

    public void setAutorId(int autorId) {
        this.autorId = autorId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    @Override
    public String toString() {
        return "Autor = " +
                "id: " + autorId +
                ", nombre: '" + nombre + '\'' +
                ", nacionalidad: '" + nacionalidad + '\'' ;
    }
}
