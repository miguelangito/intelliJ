package Ejercicios_POO_parte2_1;

public class Stock {
    private String descripcion;
    private int id;
    private int cantidadStock;

    public Stock(String descripcion, int id, int cantidadStock) {
        this.descripcion = descripcion;
        this.id = id;
        this.cantidadStock = cantidadStock;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCantidadStock() {
        return cantidadStock;
    }

    public void setCantidadStock(int cantidadStock) {
        this.cantidadStock = cantidadStock;
    }

    public void agregarProducto(String nombre,int cantidad){

    }

    @Override
    public String toString() {
        return "Ejercicios_POO_parte2_1.Stock{" +
                "descripcion='" + descripcion + '\'' +
                ", id=" + id +
                ", cantidadStock=" + cantidadStock +
                '}';
    }
}
