package Objetos;
/**
 * @author Francisco Javier Montiel Montejano, Pablo Issac Martinez Giles,Angel Uriel Gutierrez Contreras 
 * Producto
 */
public class Producto {

    private int id;
    private String nombreProducto;
    private String categoria;
    private float precio;
    private int cantidad;
    
    /**
     * Contructor de una instancia de producto
     * @param id recibe el id del producto
     * @param nombreProducto recibe el nombre del producto
     * @param categoria recibe la categoria del producto
     * @param precio recibe el precio del producto
     * @param cantidad recibe la cantidad del producto
     */
    public Producto(int id, String nombreProducto, String categoria, float precio, int cantidad) {
        this.id = id;
        this.nombreProducto = nombreProducto;
        this.categoria = categoria;
        this.precio = precio;
        this.cantidad = cantidad;
    }

    /**
     * getter del id
     * @return retorna el valor (int) del id del producto
     */
    public int getId() {
        return id;
    }

    /**
     * setter del id
     * @param id recibe como parametro el nuevo valor del id del producto
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * getter del nombre del producto
     * @return retorna el nombre del producto (String)
     */
    public String getNombreProducto() {
        return nombreProducto;
    }

    /**
     * setter del nombre del producto
     * @param nombreProducto recibe el nombre nuevo del producto como parametro
     */
    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    /**
     * getter de la categoria del producto
     * @return retorna el valor de la categoria del producto (String)
     */
    public String getCategoria() {
        return categoria;
    }

    /**
     * setter de la categoria
     * @param categoria recibe el nuevo valor de la categoria del producto
     */
    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    /**
     * getter del precio
     * @return retorna el valor del perdio del producto
     */
    public float getPrecio() {
        return precio;
    }

    /**
     * setter del precio
     * @param precio recibe como paramtero el nuevo valor del precio del producto
     */
    public void setPrecio(float precio) {
        this.precio = precio;
    }

    /**
     * getter de la cantidad
     * @return retorna la cantidad de elementos del producto
     */
    public int getCantidad() {
        return cantidad;
    }

    /**
     * setter de la cantidad
     * @param cantidad recibe como parametro la nueva cantidad del producto
     */
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

   
    
    
    
}
