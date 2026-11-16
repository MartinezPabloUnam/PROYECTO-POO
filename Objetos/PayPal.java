package Objetos;

public class PayPal extends MedioPago
{
    private String correo;
    private String contraseña;

    public PayPal(String correo, String contraseña)
    {
        this.contraseña=contraseña;
            this.correo=correo;
    }

    @Override 

    public void mostrarDetalles()
    {
        System.out.println("Se ha enviado una confirmacion de pago a: "+this.correo);
    }
}
