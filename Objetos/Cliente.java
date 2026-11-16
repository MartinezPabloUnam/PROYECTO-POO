package Objetos;
import java.util.ArrayList;
/**
 * @author Francisco Javier Montiel Montejano, Pablo Issac Martinez Giles,Angel Uriel Gutierrez Contreras
 * Cliente
 */
public class Cliente extends Usuario 
{
    private String nombre;
    private int telefono;
    private Carrito compras;
    private ArrayList<MedioPago> mediosdepago;
    private ArrayList<Domicilio> domicilios;

    /**
     * Constructor de una incstancia de cliente
     * @param nombre recibe el nombre real del cliente
     * @param nombreusu recibe el nombre del cliente en el sistema (nombre de usuario) que lo madara a la clase padre Usuario
     * @param telefono recibe el telefono del cliente
     * @param compras recibe el carrito del cliente
     */
    public Cliente(String nombre,String nombreusu ,int telefono,Carrito compras )
    {
        super(nombreusu);
        this.telefono=telefono;
        this.nombre = nombre;
        this.compras = compras;
        this.mediosdepago = new ArrayList<>();
        this.domicilios= new ArrayList<>();
    }

    /**
     * Metodo para agregar un domicilio nuevo a la liasta de domicilios del cliente
     * @param newdom recibe como parametro una instancia de el domicilio nuevo a agregar
     */
    public void setnewdom(Domicilio newdom)
    {
        domicilios.add(newdom);
    }

    /**
     * Metodo para agregar un nuevo metodo de pago a la lista de metodos de pago
     * @param newmet recibe como parametro una instancia del nuevo metodo de pago a agregar
     */
    public void setnewmetPago(MedioPago newmet)
    {
        mediosdepago.add(newmet);
    }

    /**
     *metodo getter de Domicilios 
     * @return retorna la lista de domicilios del cliente
     */
    public ArrayList<Domicilio> getDomicilios(){
        return this.domicilios;
    }


}
