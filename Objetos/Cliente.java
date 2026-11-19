package Objetos;
import Procesos.Pedido;
import java.util.ArrayList;
/**
 * @author Francisco Javier Montiel Montejano, Pablo Issac Martinez Giles,Angel Uriel Gutierrez Contreras
 * Cliente clase concreta que hereda de Usuario
 */
public class Cliente extends Usuario 
{
    private String nombre;
    private long telefono;
    private Carrito compras;
    private ArrayList<MedioPago> mediosdepago;
    private ArrayList<Domicilio> domicilios;
    private ArrayList<Pedido> historialPedido;

    /**
     * Contructor de una instancia de cliente
     * @param nombre recibe el nombre de el cliente
     * @param nombreusu recibe el nombre de usuario
     * @param telefono recibe el telefono del cliente
     * @param compras recibe el carrito del cliente
     */
    public Cliente(String nombre,String nombreusu ,long  telefono,Carrito compras )
    {
        super(nombreusu);
        this.telefono=telefono;
        this.nombre = nombre;
        this.compras = compras;
        this.mediosdepago = new ArrayList<>();
        this.domicilios= new ArrayList<>();
        this.historialPedido= new ArrayList<>();
    }

    /**
     * Setter del domicilio de la persona que añade un nuevo domicilio a una lista
     * @param newdom recibe como parametro el domicilio nuevo
     */
    public void setnewdom(Domicilio newdom)
    {
        domicilios.add(newdom);
    }

    /**
     * setter del nuevo metodod de pago que añade un nuevo metodo de pagpo a la una lista
     * @param newmet recibe como parametro el nuevo metodo de pago
     */
    public void setnewmetPago(MedioPago newmet)
    {
        mediosdepago.add(newmet);
    }

    /**
     * getter del carrito
     * @return retorna el carrito del cliente
     */
    public Carrito getCompras() {
        return compras;
    }

    /**
     * getter de domicilios
     * @return retorna la lista de domicilios registrados por el cliente
     */
    public ArrayList<Domicilio> getDomicilios() {
        return domicilios;
    }

    /**
     * getter del nombre 
     * @return retorna el nombre del cliente
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * getter del telefono
     * @return retorna el numero de telefono del cliente(long)
     */
    public long getTelefono() {
        return telefono;
    }

    /**
     * getter de medios de pago
     * @return retorna la lista de medio de pago
     */
    public ArrayList<MedioPago> getMediosdepago() {
        return mediosdepago;
    }

    /**
     * setter del historial de pedidos
     * @param historialPedido recibe como parametro un pedido nuevo y lo añade a una lista
     */
    public void setHistorialPedido(Pedido historialPedido) {
        this.historialPedido.add(historialPedido);
    }

    /**
     * getter del historial de pedidos
     * @return retorna la lista de pedidos del cliente
     */
    public ArrayList<Pedido> getHistorialPedido() {
        return historialPedido;
    }

    

}
