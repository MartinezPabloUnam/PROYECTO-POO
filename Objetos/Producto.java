package Objetos;

public class Producto {

    private int id;
    private String nombreProducto;
    private String categoria;
    private float precio;
    private int cantidad;
    
    public Producto(int id, String nombreProducto, String categoria, float precio, int cantidad) {
        this.id = id;
        this.nombreProducto = nombreProducto;
        this.categoria = categoria;
        this.precio = precio;
        this.cantidad = cantidad;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

   
    
    
    
}
