package Objetos;
/**
 * @author Francisco Javier Montiel Montejano, Pablo Issac Martinez Giles,Angel Uriel Gutierrez Contreras
 * PayPal clase que implememnta la interfaz MedioPago
 */
public class PayPal implements MedioPago
{
    private String correo;
    private String contraseña;
    /**
     * Constructor de el metodod de pago paypal
     * @param correo recibe el correo asociado al medio de pago
     * @param contraseña recibe la contraseña para el medio de pago
     */
    public PayPal(String correo, String contraseña)
    {
        this.contraseña=contraseña;
            this.correo=correo;
    }
    /**(non-Javadoc)
    *metodo que sobrescribe mostrarDetalles mostrando el un mensaje de a que correo se envio una confirmacion de pago  
    * @see Objetos.MedioPago#mostrarDetalles()
    */
    @Override 

    public void mostrarDetalles()
    {
        System.out.println("Se ha enviado una confirmacion de pago a: "+this.correo);
    }
}
