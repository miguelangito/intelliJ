package entity;

public class Coder {
    private int id;
    private String nombre;
    private int age;
    private String clan;


    public Coder(int id, String nombre, int age, String clan) {
        this.id = id;
        this.nombre = nombre;
        this.age = age;
        this.clan = clan;
    }

    public Coder() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getClan() {
        return clan;
    }

    public void setClan(String clan) {
        this.clan = clan;
    }

    @Override
    public String toString() {
        return "Coder{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", age=" + age +
                ", clan='" + clan + '\'' +
                '}';
    }
}
