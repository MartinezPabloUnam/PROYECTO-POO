package Procesos;

import Objetos.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Pedido {

    private float precioTotal;
    private LocalDateTime fechaHora;
    private LocalDate fechaEntrega;
    private ArrayList<Producto> listaProductosFinal;
    private ArrayList<Domicilio> listaDomicilios;
    private ArrayList<MedioPago> listaMedioPago;
    private Cliente cliente;
    private Domicilio domicilioFinal;
    private MedioPago medioPagoCliente;
    private boolean confirmado=false;
    private DateTimeFormatter fechaActual;
    private DateTimeFormatter entrega; 

    /**
     * Contructor de una instancia de pedido
     * @param cliente recibe como parametro el cliente
     */
    public Pedido(Cliente cliente) {
        this.cliente = cliente;
    }

    /**
     * confirmarPedido Metodo que contienen todo el proceso del pago del pedido y las validaciones necesarias para terminar de procesarlo
     */
    public void confirmarPedido() {
        if(confirmado){
            System.out.println("El pedido ya fue confirmado.");
            return;
        }
        Scanner lector = new Scanner(System.in);
        precioTotal = cliente.getCompras().getPrecioTotal();
        listaProductosFinal=new ArrayList<>();
        for (Producto elemento:cliente.getCompras().getListaCarrito()){
            Producto copia = new Producto(elemento.getId(),elemento.getNombreProducto(),elemento.getCategoria(),elemento.getPrecio(),elemento.getCantidad());
            listaProductosFinal.add(copia);
        }
        this.listaDomicilios = new ArrayList<>(cliente.getDomicilios());
        this.listaMedioPago = new ArrayList<>(cliente.getMediosdepago());
        if (listaDomicilios.isEmpty() || listaProductosFinal.isEmpty() || listaMedioPago.isEmpty()) {
            System.out.println("Error al proceder con el pedido");
            return;
        }
        int i = 1;
        int opcion;
        for (Domicilio elemento : listaDomicilios) {
            System.out.println("Domicilio " + i);
            System.out.println("Calle: " + elemento.getCalle() + " | Colonia: " + elemento.getColonia() + " | Numero: " + elemento.getNumext());
            i++;

        }
        System.out.println("Elija a que domicilio enviar el pedido");
        domicilioFinal = new Domicilio("", "", 0);
        try {
            opcion = lector.nextInt();
            if (opcion <= 0 || opcion > listaDomicilios.size()) {
                System.out.println("No existe el domicilio");
                return;
            }
            domicilioFinal = listaDomicilios.get(opcion - 1);
        } catch (Exception e) {
            System.out.println("Error, algo salio mal");
            lector.nextLine();
            return;
        }
        i = 1;
        for (MedioPago elemento : listaMedioPago) {
            System.out.println("Medio de Pago " + i);
            elemento.mostrarDetalles();
            i++;
        }
        System.out.println("Elija que metodo de pago usar");
        medioPagoCliente = null;
        try {
            opcion = lector.nextInt();
            if (opcion <= 0 || opcion > listaMedioPago.size()) {
                System.out.println("No existe el metodo de pago");
                return;
            }
            medioPagoCliente = listaMedioPago.get(opcion - 1);
            if (medioPagoCliente.getClass().getSimpleName().equals("PayPal")) {
                PayPal paypal = (PayPal) medioPagoCliente;
                System.out.println("Ingrese la contraseña");
                try {
                    lector.nextLine();
                    String contraseña = lector.nextLine();
                    if (paypal.getContraseña().equals(contraseña)) {
                        System.out.println("Contraseña aceptada");
                        System.out.println("Se ha enviado una confirmacion de pago a: " + paypal.getCorreo());
                    } else {
                        System.out.println("Contraseña incorrecta");
                        return;
                    }
                } catch (Exception e) {
                    System.out.println("Error, algo salio mal");
                    lector.nextLine();
                    return;
                }
            } else {
                TarjetaCredito tarjeta = (TarjetaCredito) medioPagoCliente;
                System.out.println("Ingrese el NIP");
                try {
                    int nip = lector.nextInt();
                    lector.nextLine();
                    if (tarjeta.getNip() == nip) {
                        System.out.println("NIP aceptado");
                        System.out.println("Se ha enviado una confirmacion a la banca electronica de la tarjeta: *******" + tarjeta.getNumtarj() % 10000);
                    } else {
                        System.out.println("NIP incorrecto");
                        return;
                    }
                } catch (Exception e) {
                    System.out.println("Error, algo salio mal");
                    lector.nextLine();
                    return;
                }
            }
        } catch (Exception e) {
            System.out.println("Error, algo salio mal");
            lector.nextLine();
            return;
        }
        System.out.println("¿Desea confirmar su pedido? Si(s)/No(s)");
        try {
            String caracter = lector.nextLine();
            if (caracter.equalsIgnoreCase("s")) {
                System.out.println("Confirmación del pedido");
                System.out.println("Precio Total a Pagar: $" + this.precioTotal + "mxn");
                System.out.println("Domicilio seleccionado:");
                System.out.println("Calle: " + domicilioFinal.getCalle() + " Colonia: " + domicilioFinal.getColonia() + " Numero: " + domicilioFinal.getNumext());
                System.out.println("Metodo de Pago");
                medioPagoCliente.mostrarDetalles();
                fechaHora = LocalDateTime.now();
                Random random = new Random();
                fechaActual = DateTimeFormatter.ofPattern("yyyy-MM-dd_HH-mm-ss");
                fechaEntrega = fechaHora.toLocalDate().plusDays(random.nextInt(7, 15));
                entrega = DateTimeFormatter.ISO_LOCAL_DATE;
                confirmado = true;
                cliente.setHistorialPedido(this);
                System.out.println("Pedido confirmado");
                imprimirTicket();
                cliente.getCompras().getListaCarrito().clear();
                cliente.getCompras().setPrecioTotal(0);
                return;
            }
            if (caracter.equalsIgnoreCase("n")) {
                System.out.println("Pedido no confirmado");
                confirmado=false;
            }

        } catch (Exception e) {
            System.out.println("Ups, ocurrio un error");
            lector.nextLine();
        }
        

    }

    /**
     * Metodo que crea una carpeta y un archivo con la informacion del pedido "ticket" con ayuda de File y FileWriter
     */
    public void imprimirTicket() {
        if (confirmado) {
            String hora = fechaHora.format(fechaActual);
            File Pedido = new File("CarpetaRecibo");
            File Recibo = new File(Pedido, "Recibo" + cliente.getNombre() + hora + ".txt");

            if (!Pedido.exists()) {
                Pedido.mkdirs();
            }
            try (FileWriter escritor = new FileWriter(Recibo)) {
                escritor.write("Recibo de compra\n");
                escritor.write("Hora de compra\n");
                escritor.write(fechaHora.format(fechaActual) + "\n");
                escritor.write("Fecha de Entrega\n");
                escritor.write(fechaEntrega.format(entrega) + "\n");
                for (Producto elemento : listaProductosFinal) {
                    escritor.write("Nombre del producto: " + elemento.getNombreProducto() + " | ID: " + elemento.getId() + " | Categoria: " + elemento.getCategoria() + " | Precio: " + elemento.getPrecio() + " | Cantidad: " + elemento.getCantidad() + "\n");
                }
                escritor.write("Precio Total: " + precioTotal + "\n");
                escritor.write("Domicilio\n");
                escritor.write("Calle: " + domicilioFinal.getCalle() + " Colonia: " + domicilioFinal.getColonia() + " Numero: " + domicilioFinal.getNumext() + "\n");
                escritor.write("Medio de Pago\n");
                escritor.write(medioPagoCliente.getClass().getSimpleName() + "\n");
                if (medioPagoCliente.getClass().getSimpleName().equals("PayPal")) {
                    PayPal paypal = (PayPal) medioPagoCliente;
                    escritor.write(paypal.getCorreo() + "\n");
                } else {
                    TarjetaCredito tarjeta = (TarjetaCredito) medioPagoCliente;
                    escritor.write("*******"+tarjeta.getNumtarj() % 10000 + "\n");
                }
            } catch (IOException e) {
                System.out.println("Ocurrio un error al imprimir el recibo.");
            }
        } else {
            System.out.println("El pedido no ha sido confirmado");
        }

    }

    /**
     * Metodo que sirve para mostrar el pedido si ya fue confirmado
     */
    public void mostrarPedido(){
        if(!confirmado){
            System.out.println("El pedido no ha sido confirmado.");
            return;
        }
        System.out.println("Precio Total a Pagar: $" + this.precioTotal + "mxn");
        System.out.println("Domicilio seleccionado:");
        System.out.println("Calle: " + domicilioFinal.getCalle() + " Colonia: " + domicilioFinal.getColonia() + " Numero: " + domicilioFinal.getNumext());
        System.out.println("Metodo de Pago");
        System.out.println(medioPagoCliente.getClass().getSimpleName());
        medioPagoCliente.mostrarDetalles();
    }
}

