package entity;

public class Libro extends Autor{

    private int id;
    private String titulo;
    private int añoPublicaion;
    private int precio;

    public Libro(int id, String titulo, int añoPublicaion, int precio, int autorId, String nombre, String nacionalidad) {
        super(autorId, nombre, nacionalidad);
        this.id = id;
        this.titulo = titulo;
        this.añoPublicaion = añoPublicaion;
        this.precio = precio;
    }

    public Libro() {
    }

    public int getAutorId() {
        return id;
    }

    public void setAutorId(int autorId) {
        this.id = autorId;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getAñoPublicaion() {
        return añoPublicaion;
    }

    public void setAñoPublicaion(int añoPublicaion) {
        this.añoPublicaion = añoPublicaion;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "Libro{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", añoPublicaion=" + añoPublicaion +
                ", precio=" + precio +
                '}';
    }
}
