package Procesos;

import Objetos.Cliente;
import Objetos.Domicilio;
import Objetos.PayPal;
import Objetos.TarjetaCredito;
import java.util.Scanner;
/**
 * @author Francisco Javier Montiel Montejano, Pablo Issac Martinez Giles,Angel Uriel Gutierrez Contreras
 * MenuClientes
 */
public class MenuClientes {

    private Cliente clienteactual;

     /**
     * Contructor de una instancia de menu de clientes
     * @param clienteactual recibe como parametro el cliente que entrara en el menu
     */
    public MenuClientes(Cliente clienteactual) {
        this.clienteactual = clienteactual;
    }

     /**
     * Menu prinicpal del menu de clientes, presenta las opciones a poder realizar por cada cliente
     */
    public void clientemenu() {
        DarAltaProducto.inicializarProductos();
        int k = 1;
        Scanner lector = new Scanner(System.in);
        System.out.println("BIENVENIDO CLIENTE " + clienteactual.getNombreusu());
        do {
            System.out.println("Elige el proceso que deseas ejecutar:");
            System.out.println("1) AGREGAR PRODUCTO AL CARRITO");
            System.out.println("2) REGISTRAR DOMICILIO");
            System.out.println("3) REGISTRAR MEDIO DE PAGO");
            System.out.println("4) CONFIRMAR PEDIDO");
            System.out.println("5) VACIAR CARRITO");
            System.out.println("6) CONSULTAR CARRITO");
            System.out.println("7) IMPRIMIR TICKET DE UN PEDIDO");
            System.out.println("8) REGRESAR AL MENU PRINCIPAL");
            int decision;
            try {
                decision=lector.nextInt();
                lector.nextLine();
            } catch (Exception e) {
                System.out.println("Ha ocurrido un error");
                lector.nextLine();
                continue;
            }
            int id, cantidad;
            switch (decision) {
                case 1:
                    DarAltaProducto.mostrarProductos();
                    if (DarAltaProducto.getListaProductos().isEmpty()) {
                        System.out.println("No hay productos disponibles");
                        break;
                    }
                    System.out.println("Igrese el ID del producto que desee agregar");
                    try {
                        id = lector.nextInt();
                        System.out.println("Ingrese la cantidad que desee agregar");
                        cantidad = lector.nextInt();
                        clienteactual.getCompras().agregarProductoCarrito(id, cantidad);
                    } catch (Exception e) {
                        System.out.println("Ups, ha ocurrido un error");
                        lector.nextLine();
                    }
                    break;

                case 2:
                    registrarDomicilio(clienteactual);
                    break;

                case 3:
                    registrarNewMetodopago(clienteactual);
                    break;

                case 4:
                    Pedido pedido = new Pedido(clienteactual);
                    pedido.confirmarPedido();
                    break;

                case 5:
                    clienteactual.getCompras().vaciarCarrito();
                    break;

                case 6:
                    clienteactual.getCompras().mostrarCarrito();
                    break;

                case 7:
                    int i = 1;
                    if (!clienteactual.getHistorialPedido().isEmpty()) {
                        for (Pedido pedidoActual : clienteactual.getHistorialPedido()) {
                            System.out.println("Pedido " + i);
                            pedidoActual.mostrarPedido();
                            i++;
                        }
                        System.out.println("Ingrese el pedido que desee imprimir");
                        try {
                            int opcion = lector.nextInt();
                            if (opcion > 0 && opcion <= clienteactual.getHistorialPedido().size()) {
                                clienteactual.getHistorialPedido().get(opcion - 1).imprimirTicket();
                            }
                        } catch (Exception e) {
                            System.out.println("Ups, ocurrio un error");
                            lector.nextLine();
                        }
                    }
                    break;

                case 8:
                    Scanner lector2 = new Scanner(System.in);
                    System.out.println("¿DESEA SALIR DEL MENU?");
                    System.out.println("INGRESA s PARA SI / n PARA NO");
                    String decision2 = lector2.nextLine();
                    if (decision2.equalsIgnoreCase("s")) {
                        System.out.println("REGRESANDO AL MENU PRINCIPAL.....");
                        k = 0;
                    }
                    break;
            }
        } while (k == 1);
    }

    /**
     * Metodo para registrar un domicilio nuevo para el cliente
     * @param cliente recibe una instancia del cliente al que se le agregar aeste domicilio nuevo
     */
    public void registrarDomicilio(Cliente cliente)
    {
        Scanner lector= new Scanner(System.in);
        Scanner lector2= new Scanner(System.in);
        String calle;
        String colonia;
        int num; 
        boolean continuar;
        do{
            continuar=false;
            System.out.println("Ingresa una calle:");
            calle = lector.nextLine();
            System.out.println("Ingresa una colonia:");
            colonia = lector.nextLine();
            System.out.println("Ingresa un numero exterior:");
            try {
                num = lector2.nextInt();
            } catch (Exception e) {
                System.out.println("Ha ocurrido un error");
                return;
            }
            
            for(Domicilio dom:cliente.getDomicilios()){
                if(dom.getCalle().equalsIgnoreCase(calle) && dom.getColonia().equalsIgnoreCase(colonia) && dom.getNumext()==num){
                    System.out.println("Los datos ingresados ya existen en tus domicilios ingresados anteriormente vulevelo a intentar");
                    continuar=true;
                    break;
                }
            }            
        }while (continuar==true);                 
        Domicilio nuevodom = new Domicilio(calle, colonia, num);
        cliente.setnewdom(nuevodom);
    }


    /**
     * Metodo para que el cliente registre un metodo de pago nuevo
     * @param cliente Recibe una instancia de cliente al que se le agregara el metodo de pago nuevo
     */
    public void registrarNewMetodopago(Cliente cliente) {
        Scanner reader = new Scanner(System.in);
        Scanner reader2 = new Scanner(System.in);
        System.out.println("¿QUE METODO DE PAGO DESEAS AGREGAR?");
        System.out.println("1) TARJETA DE CREDITO");
        System.out.println("2) PAYPAL");
        int decision;
        try {
            decision = reader.nextInt();
            reader.nextLine();
            switch (decision) {
                case 1:
                    System.out.println("Ingresa el numero de tu tarjeta a registrar:");
                    int num = reader.nextInt();
                    System.out.println("Ingresa el NIP de dicha tarjeta:");
                    int nip = reader.nextInt();
                    reader.nextLine();
                    TarjetaCredito newtar = new TarjetaCredito(num, nip);
                    cliente.setnewmetPago(newtar);
                    break;

                case 2:
                    System.out.println("Ingresa tu correo electronico a asociar:");
                    String correo = reader2.nextLine();
                    System.out.println("Ingresa la contraseña de dicho PAYPAL:");
                    String contrasena = reader2.nextLine();
                    PayPal newpay = new PayPal(correo, contrasena);
                    cliente.setnewmetPago(newpay);
                    break;

                default:
                    System.out.println("Ingrese un dato valido");
                    break;

            }
        } catch (Exception e) {
            System.out.println("Ha ocurrido un error");
            reader.nextLine();
        }

    }
}
