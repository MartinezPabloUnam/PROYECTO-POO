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
        System.out.println("Tarjeta");
        System.out.println("Numero de tarjeta: "+this.numtarj%10000);
    }

    public int getNumtarj() {
        return numtarj;
    }

    public int getNip() {
        return nip;
    }

    
}
