package Objetos;

import Procesos.DarAltaProducto;
import java.util.ArrayList;
/**
 * @author Francisco Javier Montiel Montejano, Pablo Issac Martinez Giles,Angel Uriel Gutierrez Contreras 
 * Carrito
 */
public class Carrito {
    private ArrayList<Producto> listaCarrito = new ArrayList<>();
    private float precioTotal;
    
    /**
     * Constructor de la clase carrito
     */
    public Carrito() {
    }

    /**
     * Metodo que agrega un producto al carrito
     * @param id recibe como parametro (Int) el id del producto elegido
     * @param cantidad recibe la cantidad (Int) de productso comprados
     */
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
   
    /**
     * Metodo para mostrar el listado de productos del carrito
     */
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

    /**
     * Getter para poder trabajar con la lista del carrito
     * @return retorna la listaCarrito que es la lista de productos en el carrito
     */
    public ArrayList<Producto> getListaCarrito() {
        return listaCarrito;
    }

    /**
     * Metodo para vaciar el carrito
     */
    public void vaciarCarrito(){
        for(Producto elemento:listaCarrito){
            Producto productoOriginal = DarAltaProducto.elegirProducto(elemento.getId());
            productoOriginal.setCantidad(productoOriginal.getCantidad()+elemento.getCantidad());
        }
        listaCarrito.clear();
        precioTotal=0;
        System.out.println("Se vacio el carrito correctamente");
    }

    /**
     * Getter del precioTotal 
     * @return retorna el atributo precioTotal el cual contiene la suma de los precios de todos los productos del carrito
     */
    public float getPrecioTotal() {
        return precioTotal;
    }

    /**
     * Setter del precioTotal
     * @param precioTotal recibe como parametro el nuevo precio total del carrito
     */ 
    public void setPrecioTotal(float precioTotal) {
        this.precioTotal = precioTotal;
    }
    

}
