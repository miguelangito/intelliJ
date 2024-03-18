package Ejercicios_POO_parte2_3;

import java.util.ArrayList;

public class Inventario {
    private ArrayList<Producto> ListaProductos;

    public Inventario(){
        this.ListaProductos = new ArrayList<>();
    }

    //Metodos

    public void agregarProducto(Producto producto){
        this.ListaProductos.add(producto);
    }

    public boolean eliminarProducto(int id){
        return ListaProductos.removeIf(producto -> producto.getId() == id);
    }

    public Producto buscarPorNombre(String nombreBuscar){
        for (Producto objProducto: this.ListaProductos ){
            if (objProducto.getNombre().equalsIgnoreCase(nombreBuscar)) {
                return objProducto;
            }
        }
        return null;
    }

    public void listarProductos(){
        for (Producto producto: this.ListaProductos){
            System.out.println("Id: " + producto.getId()+ " " + "Nombre: "+ producto.getNombre()+ " " + "Precio: " + producto.getPrecio());
        }
    }
}
