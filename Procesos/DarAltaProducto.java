package Procesos;

import Objetos.Producto;
import java.util.HashMap;
/**
 * @author Francisco Javier Montiel Montejano, Pablo Issac Martinez Giles,Angel Uriel Gutierrez Contreras
 * DarAltaProducto
 */
public class DarAltaProducto {

    private static HashMap<Integer, Producto> listaProductos = new HashMap<>();
    private static Producto producto1 = new Producto(12345, "GTA VI", "Videojuegos", 1230, 200);
    private static Producto producto2 = new Producto(67890, "Audifonos", "Aparatos electronicos", 500, 500);
    private static Producto producto3 = new Producto(16254, "Zapato", "Ropa", 850, 1500);
    private static Producto producto4 = new Producto(89102, "Playstation 5", "Videojuegos", 9000, 100);
    private static Producto producto5 = new Producto(75468, "Denver Nuggets Jersey", "Deportes", 2400, 320);
    private static boolean inicializar = false;

    /**
     * metodo estatico que inicializa los productos agregandolos en un Hashmap
     */
    public static void inicializarProductos() {
        if (!inicializar) {
            listaProductos.put(producto1.getId(), producto1);
            listaProductos.put(producto2.getId(), producto2);
            listaProductos.put(producto3.getId(), producto3);
            listaProductos.put(producto4.getId(), producto4);
            listaProductos.put(producto5.getId(), producto5);
            inicializar = true;
        }

    }

    /**
     * Metodo estatico para dar de alta un producto
     * @param precio recibe el precio del producto
     * @param id recibe el id del producto
     * @param nombre recib el nombre del producto
     * @param categoria recibe la categoria del producto
     * @param cantidad recibe la cantidad del producto
     */
    public static void darAltaProducto(float precio, int id, String nombre, String categoria, int cantidad) {
        if (precio > 0 && cantidad > 0) {
            
            if (listaProductos.containsKey(id)) {
                System.out.println("El id ya existe");
                return;
            }
            Producto producto = new Producto(id, nombre, categoria, precio, cantidad);
            listaProductos.put(id, producto);
            System.out.println("El producto se registro correctamente");
            
        } else {
            System.out.println("El precio o la cantidad ingresado no es valido");
        }

    }

    /**
     * Metodo estatico booleano que muestra los productos de la lista
     * @return retorna un valor booleano para confirmar si hay productos o no hay productos en la lista
     */
    public static boolean mostrarProductos() {
        if (listaProductos.isEmpty()) {
            System.out.println("No hay productos registrados");
            return false;
        }
        int i = 1;
        for (Producto elemento : listaProductos.values()) {
            System.out.println("Producto" + i);
            System.out.println("Identificador: " + elemento.getId() + " | Nombre del producto: " + elemento.getNombreProducto() + " | Precio: " + elemento.getPrecio() + " | Cantidad Disponible: " + elemento.getCantidad());
            i++;
        }
        return true;
    }

    /**
     * Metodo estatico que sirve para modificar el precio 
     * @param id recibe el id del producto a modificar su precio
     * @param precio recibe el nuevo precio del producto
     */
    public static void modificarPrecio(int id, float precio) {
        if (listaProductos.containsKey(id) && precio > 0) {
            Producto producto = listaProductos.get(id);
            producto.setPrecio(precio);
            System.out.println("El precio se modifico correctamente");
            return;
        }
        System.out.println("El id o el precio ingresado no son válidos");
    }

    /**
     * Metodo estatico que sirve para seleccionar un producto
     * @param id recibe el id del producto a seleccionar
     * @return retorna el producto a seleccionar o nulo si no encuentra nada
     */
    public static Producto elegirProducto(int id) {
        if (!listaProductos.containsKey(id)) {
            System.out.println("El producto no existe");
            return null;
        }
        return listaProductos.get(id);
    }

    /**
     * getter de la lista de productos
     * @return retorna la listas de productos y sus claves (HashMap)
     */
    public static HashMap<Integer, Producto> getListaProductos() {
        return listaProductos;
    }

}
