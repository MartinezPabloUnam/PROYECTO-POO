package Procesos;

import Objetos.Cliente;
import Objetos.Domicilio;
import Objetos.PayPal;
import Objetos.TarjetaCredito;
import java.util.Scanner;

public class MenuClientes {

    private Cliente clienteactual;

    public MenuClientes(Cliente clienteactual) {
        this.clienteactual = clienteactual;
    }

    public void clientemenu() {
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
            int decision = lector.nextInt();
            lector.nextLine();
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
                            if(opcion>0 && opcion<clienteactual.getHistorialPedido().size()){
                                clienteactual.getHistorialPedido().get(opcion - 1).imprimirTicket();
                            }
                        } catch (Exception e) {
                            System.out.println("Ups, ocurrio un error");
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

    public void registrarDomicilio(Cliente cliente) {
        Scanner lector = new Scanner(System.in);
        Scanner lector2 = new Scanner(System.in);
        System.out.println("Ingresa una calle:");
        String calle = lector.nextLine();
        System.out.println("Ingresa una colonia:");
        String colonia = lector.nextLine();
        System.out.println("Ingresa un numero exterior:");
        int num = lector2.nextInt();

        Domicilio nuevodom = new Domicilio(calle, colonia, num);
        cliente.setnewdom(nuevodom);
    }

    public void registrarNewMetodopago(Cliente cliente) {
        Scanner reader = new Scanner(System.in);
        Scanner reader2 = new Scanner(System.in);
        System.out.println("¿QUE METODO DE PAGO DESEAS AGREGAR?");
        System.out.println("1) TARJETA DE CREDITO");
        System.out.println("2) PAYPAL");
        int decision = reader.nextInt();
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
    }
}
