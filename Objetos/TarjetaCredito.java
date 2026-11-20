package Objetos;

import java.util.Random;

/**
 * @author Francisco Javier Montiel Montejano, Pablo Issac Martinez Giles,Angel Uriel Gutierrez Contreras
 * TarjetaCredito metodo que implementa la interfaz MedioPago
 */
public class TarjetaCredito implements MedioPago
{
    private long numtarj;
    private int nip;
    private float saldo;
    private Random random;

     /**
     * Constructo de una instancia de tarjeta de credito
     * @param numtarj recibe el numero de la tarjeta instanciada(float)
     * @param nip recibe el nip de la tarjeta instasnciada(int)
     */
    public TarjetaCredito(long  numtarj, int nip)
    {
        this.nip=nip;
        this.numtarj=numtarj;
        this.saldo=random.nextFloat(500, 50001);
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
        System.out.println("Saldo: "+this.saldo);
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

    /**
     * getter del saldo
     * @return retorna el saldo de la tyarjeta de credito
     */
    public float getSaldo() {
        return saldo;
    }
     /**
      * setter del saldo
      * @param saldo recibe como parametro el nuevo saldo de la tarjeta de credito
      */
    public void setSaldo(float saldo) {
        this.saldo = saldo;
    }

    
}
