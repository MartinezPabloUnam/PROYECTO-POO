package Procesos;

import Objetos.Admin;
import java.util.Scanner;
/**
 * @author Francisco Javier Montiel Montejano, Pablo Isaac Martinez Giles,Angel Uriel Gutierrez Contreras
 * MenuAdmins
 */
public class MenuAdmins {

    private Admin adminactual;
    /**
     * Constructor del MenuAdmins
     * @param adminlist recibe como paramtero el administrador de la lista de administradores que entrara en el menu
     */
    public MenuAdmins(Admin adminlist) {
        this.adminactual = adminlist;
    }

    /**
     * metodo que contoiene el menu principal de administradores con las opciones que este puede realizar
     */
    public void adminmenu() {
        int k = 1;
        Scanner lector = new Scanner(System.in);
        DarAltaProducto.inicializarProductos();
        System.out.println("BIENVENIDO ADMINISTRADOR " + adminactual.getNombreusu());
        do {
            System.out.println("Elige el proceso que deseas ejecutar:");
            System.out.println("1) ALTA DE PRODUCTOS");
            System.out.println("2) MODIFICACION DE PRECIOS");
            System.out.println("3) REGRESAR AL MENU PRINCIPAL");
            int decision;
            try {
                decision = lector.nextInt();
                lector.nextLine();
            } catch (Exception e) {
                System.out.println("Error, se ingreso un elemento invalido");
                lector.nextLine();
                continue;
            }
            
            switch (decision) {
                case 1:
                    System.out.println("Ingrese los datos del producto");
                    String nombre, 
                    categoria;
                    int id, 
                    cantidad;
                    float precio;
                    try {
                        System.out.println("Nombre: ");
                        nombre = lector.nextLine();
                        System.out.println("ID: ");
                        id = lector.nextInt();
                        if(id<=0){
                            System.out.println("No se admiten id's negativos");
                            break;
                        }
                        lector.nextLine();
                        System.out.println("Categoria: ");
                        categoria = lector.nextLine();
                        System.out.println("Cantidad: ");
                        cantidad = lector.nextInt();
                        if(cantidad<=0){
                            System.out.println("No se aceptan cantidades negativas");
                            break;
                        }
                        System.out.println("Precio: ");
                        precio = lector.nextFloat();
                        DarAltaProducto.darAltaProducto(precio, id, nombre, categoria, cantidad);
                    } catch (Exception e) {
                        System.out.println("Ups, ocurrio un error");
                        lector.nextLine();
                    }
                    break;

                case 2:
                    try {
                        if (DarAltaProducto.mostrarProductos()) {
                            System.out.println("Ingrese el id del producto que desee modificar");
                            id = lector.nextInt();
                            System.out.println("Ingrese el nuevo precio");
                            precio = lector.nextFloat();
                            DarAltaProducto.modificarPrecio(id, precio);
                        } else {
                            return;
                        }

                    } catch (Exception e) {
                        System.out.println("Ups, ocurrio un error");
                        lector.nextLine();
                    }

                    break;

                case 3:
                    Scanner lector2 = new Scanner(System.in);
                    System.out.println("¿DESEA SALIR DEL MENU?");
                    System.out.println("INGRESA s PARA SI / n PARA NO");
                    String decision2 = lector2.nextLine();
                    if (decision2.toLowerCase().equals("s")) {
                        System.out.println("REGRESANDO AL MENU PRINCIPAL.....");
                        k = 0;
                    }
                    break;
            }
        } while (k == 1);
    }
}
