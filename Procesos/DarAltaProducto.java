package Procesos;

import Objetos.Producto;
import java.util.HashMap;

public class DarAltaProducto {
   private static HashMap<Integer,Producto> listaProductos = new HashMap<>();

    public static void darAltaProducto(float precio,int id, String nombre,String categoria,int cantidad){
        if(precio>0 && cantidad>0){
            if(listaProductos.isEmpty()){
                Producto producto = new Producto(id,nombre,categoria,precio,cantidad);
                listaProductos.put(id, producto);
                System.out.println("El producto se registro correctamente");
            }
            else{       
                if(listaProductos.containsKey(id)){
                    System.out.println("El id ya existe");
                    return;
                }
                Producto producto = new Producto(id,nombre,categoria,precio,cantidad);
                listaProductos.put(id,producto);
                System.out.println("El producto se registro correctamente");
            }
        }
        else{
            System.out.println("El precio o la cantidad ingresado no es valido");
        }
        

    }

    public static void mostrarProductos(){
        if(listaProductos.isEmpty()){
            System.out.println("No hay productos registrados");
            return;
        }
        int i=1;
        for(Producto elemento:listaProductos.values()){
            System.out.println("Producto"+i);
            System.out.println("Identificador: "+elemento.getId()+" | Nombre del producto: "+elemento.getNombreProducto()+" | Precio: "+elemento.getPrecio()+" | Cantidad Disponible: "+elemento.getCantidad());
            i++;
        }
    }

    public static void modificarPrecio(int id,float precio){
        if(listaProductos.containsKey(id) && precio>0){
            Producto producto = listaProductos.get(id);
            producto.setPrecio(precio);
            System.out.println("El precio se modifico correctamente");
            return;
        }
        System.out.println("El id o el precio ingresado no son válidos");
    }
    
    public static Producto elegirProducto(int id){
        if(!listaProductos.containsKey(id)){
            System.out.println("El producto no existe");
            return null;
        }
        return listaProductos.get(id);
    }

    public static HashMap<Integer, Producto> getListaProductos() {
        return listaProductos;
    }

    
}
