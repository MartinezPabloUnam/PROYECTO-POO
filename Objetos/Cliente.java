package Objetos;
import java.util.ArrayList;

public class Cliente extends Usuario 
{
    private String nombre;
    private int telefono;
    private Carrito compras;
    private ArrayList<MedioPago> mediosdepago;
    private ArrayList<Domicilio> domicilios;

    public Cliente(String nombre,String nombreusu ,int telefono,Carrito compras )
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


}
