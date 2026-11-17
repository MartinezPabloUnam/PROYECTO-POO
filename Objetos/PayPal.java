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
        System.out.println("Paypal");
        System.out.println("Correo electronico: "+this.correo);
    }

    public String getCorreo() {
        return correo;
    }

    public String getContraseña() {
        return contraseña;
    }


}
