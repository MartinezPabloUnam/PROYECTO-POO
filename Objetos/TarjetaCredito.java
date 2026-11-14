package Objetos;

public abstract class TarjetaCredito extends MedioPago
{
    private int numtarj;
    private int nip;

    public TarjetaCredito(int numtarj, int nip)
    {
        this.nip=nip;
        this.numtarj=numtarj;
    }
}
