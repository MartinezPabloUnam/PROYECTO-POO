package Procesos;
import Objetos.Cliente;
import Objetos.Domicilio;
import Objetos.PayPal;
import Objetos.TarjetaCredito;
import java.util.Scanner;

public class MenuClientes 
{
    public void clientemenu(Cliente cliente)
    {
        int k=1;
        Scanner lector = new Scanner(System.in);
        System.out.println("BIENVENIDO CLIENTE "+cliente.getNombreusu());
        do{
            System.out.println("Elige el proceso que deseas ejecutar:");
            System.out.println("1) AGREGAR PRODUCTO AL CARRITO");
            System.out.println("2) REGISTRAR DOMICILIO");
            System.out.println("3) REGISTRAR MEDIO DE PAGO");
            System.out.println("4) CONFIRMAR PEDIDO");
            System.out.println("5) VACIAR CARRITO");
            System.out.println("6) CONSULTAR CARRITO");
            System.out.println("7) IMPRIMIR TICKET DE UN PEDIDO");
            System.out.println("8) REGRESAR AL MENU PRINCIPAL");
            int decision = lector.nextInt();
            switch(decision)
            {
                case 1:
                    //metodo agregar producto carrito
                    break;
                
                case 2:
                    registrarDomicilio(cliente);
                    break;

                case 3:
                    //metodo registrar medio de pago
                    break;
                
                case 4:
                    //metodo confirmar pedido
                    break;

                case 5:
                    //metodo vaciar carrito
                    break;

                case 6:
                    //metodo consultar carrito
                    break;

                case 7:
                    //metodo imprimir ticket
                    break;


                case 8:
                    Scanner lector2 = new Scanner(System.in);
                    System.out.println("¿DESEA SALIR DEL MENU?");
                    System.out.println("INGRESA s PARA SI / n PARA NO");
                    String decision2= lector2.nextLine();
                    if(decision2.equals("n"))
                    {
                        System.out.println("REGRESANDO AL MENU PRINCIPAL.....");
                        k=0;
                    }
                    break;
            }
        }while(k==1);
    }

    public void registrarDomicilio(Cliente cliente)
    {
        Scanner lector= new Scanner(System.in);
        Scanner lector2= new Scanner(System.in);
        System.out.println("Ingresa una calle:");
        String calle = lector.nextLine();
        System.out.println("Ingresa una colonia:");
        String colonia = lector.nextLine();
        System.out.println("Ingresa un numero exterior:");
        int num = lector2.nextInt();

        Domicilio nuevodom = new Domicilio(calle, colonia, num);
        cliente.setnewdom(nuevodom);
    }


    public void registrarNewMetodopago(Cliente cliente)
    {
        Scanner reader = new Scanner(System.in);
        Scanner reader2 = new Scanner(System.in);
        System.out.println("¿QUE METODO DE PAGO DESEAS AGREGAR?");
        System.out.println("1) TARJETA DE CREDITO");
        System.out.println("2) PAYPAL");
        int decision = reader.nextInt();
        switch(decision)
        {
            case 1:
                System.out.println("Ingresa el numero de tu tarjeta a registrar:");
                int num= reader.nextInt();
                System.out.println("Ingresa el NIP de dicha tarjeta:");
                int nip= reader.nextInt();
                TarjetaCredito newtar = new TarjetaCredito(num,nip);
                cliente.setnewmetPago(newtar);
                break;
            
            case 2:
                System.out.println("Ingresa tu correo electronico a asociar:");
                String correo = reader2.nextLine();
                System.out.println("Ingresa la contraseña de dicho PAYPAL:");
                String contrasena = reader2.nextLine();
                PayPal newpay = new PayPal(correo,contrasena);
                cliente.setnewmetPago(newpay);
                break;

            default:
                System.out.println("Ingrese un dato valido");
                break;

        }
    }
}
