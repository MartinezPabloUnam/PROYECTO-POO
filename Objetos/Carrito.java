package Objetos;

import Procesos.DarAltaProducto;
import java.util.ArrayList;

public class Carrito {
    private ArrayList<Producto> listaCarrito = new ArrayList<>();
    private float precioTotal;
    

    public Carrito() {
    }

    public void agregarProductoCarrito(int id, int cantidad){
        Producto producto = DarAltaProducto.elegirProducto(id);
        if(producto==null){
            return;
        }
        if(producto.getCantidad()<=0){
            System.out.println("Ya no hay elementos disponibles de este producto");
            return;
        }
        if(cantidad<=0 || producto.getCantidad()<cantidad){
            System.out.println("La cantidad ingresada no es valida");
            return;
        }
        for(Producto elementos:listaCarrito){
            if(elementos.getId()==id){
                elementos.setCantidad(elementos.getCantidad()+cantidad);
                producto.setCantidad(producto.getCantidad()-cantidad);
                precioTotal+=(cantidad*producto.getPrecio());
                return;
            }
        }
        Producto productoCarrito = new Producto(producto.getId(), producto.getNombreProducto(), producto.getCategoria(), producto.getPrecio(), cantidad);
        producto.setCantidad(producto.getCantidad()-cantidad);
        precioTotal+=(cantidad*producto.getPrecio());
        listaCarrito.add(productoCarrito);
    }
   
    public void mostrarCarrito(){
        if(listaCarrito.isEmpty()){
            System.out.println("El carrito se encuentra vacío");
            return;
        }
        int i=1;
        for(Producto elemento: listaCarrito){
            System.out.println("Producto"+i);
            System.out.println("Identificador: "+elemento.getId()+" | Nombre del producto: "+elemento.getNombreProducto()+" | Precio: "+elemento.getPrecio()+ " | Cantidad: "+elemento.getCantidad());
            i++;
        }
    }

    public ArrayList<Producto> getListaCarrito() {
        return listaCarrito;
    }

    public void vaciarCarrito(){
        for(Producto elemento:listaCarrito){
            Producto productoOriginal = DarAltaProducto.elegirProducto(elemento.getId());
            productoOriginal.setCantidad(productoOriginal.getCantidad()+elemento.getCantidad());
        }
        listaCarrito.clear();
        precioTotal=0;
        System.out.println("Se vacio el carrito correctamente");
    }

    public float getPrecioTotal() {
        return precioTotal;
    }

    public void setPrecioTotal(float precioTotal) {
        this.precioTotal = precioTotal;
    }
    

}
