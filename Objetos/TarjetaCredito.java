package Objetos;

public class TarjetaCredito extends MedioPago
{
    private int numtarj;
    private int nip;

    public TarjetaCredito(int numtarj, int nip)
    {
        this.nip=nip;
        this.numtarj=numtarj;
    }

    @Override 

    public void mostrarDetalles()
    {
        System.out.println("Se ha enviado una confirmacion a la banca electronica de la tarjeta: *****"+(this.numtarj/1000));
    }
}
