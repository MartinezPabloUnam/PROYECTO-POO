package Objetos;

/**
 * @author Francisco Javier Montiel Montejano, Pablo Issac Martinez Giles,Angel Uriel Gutierrez Contreras
 * TarjetaCredito metodo que implementa la interfaz MedioPago
 */
public class TarjetaCredito implements MedioPago
{
    private long numtarj;
    private int nip;

     /**
     * Constructo de una instancia de tarjeta de credito
     * @param numtarj recibe el numero de la tarjeta instanciada(int)
     * @param nip recibe el nip de la tarjeta instasnciada(int)
     */
    public TarjetaCredito(long  numtarj, int nip)
    {
        this.nip=nip;
        this.numtarj=numtarj;
    }

    /**    (non-Javadoc)
     *Metodo que sobrescribe mostrarDetalles mostrando el mendaje de que se envio una confirmacio a la banca electronica de la tarjeta
     * @see Objetos.MedioPago#mostrarDetalles()
     */
    @Override 

    public void mostrarDetalles()
    {
        System.out.println("Tarjeta");
        System.out.println("Numero de tarjeta: "+this.numtarj%10000);
    }

    /**
     * getter del numero de la tarjeta
     * @return retrona el numerop de la tarjeta
     */
    public long getNumtarj() {
        return numtarj;
    }

    /***
     * getter del nip
     * @return retorna el nip(int) de la tarjeta
     */
    public int getNip() {
        return nip;
    }

    
}
