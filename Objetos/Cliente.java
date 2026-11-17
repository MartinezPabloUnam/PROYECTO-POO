package Objetos;
import java.util.ArrayList;

public class Cliente extends Usuario 
{
    private String nombre;
    private long telefono;
    private Carrito compras;
    private ArrayList<MedioPago> mediosdepago;
    private ArrayList<Domicilio> domicilios;

    public Cliente(String nombre,String nombreusu ,long  telefono,Carrito compras )
    {
        super(nombreusu);
        this.telefono=telefono;
        this.nombre = nombre;
        this.compras = compras;
        this.mediosdepago = new ArrayList<>();
        this.domicilios= new ArrayList<>();
    }

    public void setnewdom(Domicilio newdom)
    {
        domicilios.add(newdom);
    }

    public void setnewmetPago(MedioPago newmet)
    {
        mediosdepago.add(newmet);
    }

    public Carrito getCompras() {
        return compras;
    }

    public ArrayList<Domicilio> getDomicilios() {
        return domicilios;
    }

    public String getNombre() {
        return nombre;
    }

    public long getTelefono() {
        return telefono;
    }

    public ArrayList<MedioPago> getMediosdepago() {
        return mediosdepago;
    }

    

}
