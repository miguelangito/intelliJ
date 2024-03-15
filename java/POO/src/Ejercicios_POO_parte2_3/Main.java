package Ejercicios_POO_parte2_3;

public class Main {

    public static void main(String[] args) {
        Inventario objInventario = new Inventario();

        Producto pro1 = new Producto(1, "lapiz", 2000);
        Producto pro2 = new Producto(2, "cuaderno", 2500);

        objInventario.agregarProducto(pro1);
        objInventario.agregarProducto(pro2);

        System.out.println("Lista de productos");
        objInventario.listarProductos();

        objInventario.eliminarProducto(1);
        System.out.println("Lista despues de eliminar el producto");
        objInventario.listarProductos();

        System.out.println(objInventario.buscarPorNombre("cuaderno"));
        objInventario.listarProductos();
    }
}
