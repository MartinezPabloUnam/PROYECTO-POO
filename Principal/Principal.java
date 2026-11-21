package Principal;

import Procesos.InicioSesion;
import java.util.Scanner;
/**
 * @author Francisco Javier Montiel Montejano, Pablo Issac Martinez Giles,Angel Uriel Gutierrez Contreras
 * Principal Clase principal
 */
public class Principal {
     /**
     * Metodo principal que contienen el menu de inicio al correr el programa
     * @param args
     */
    public static void main(String[] args) {
        Scanner lector = new Scanner(System.in);
        InicioSesion ingresosistem = new InicioSesion();
        int k = 1;
        boolean exit=false;
        System.out.println("BIENVENIDO A FACEBOOK MARKETPLACE!!!");
        do { 
            
        
        try {
            do {
                System.out.println("Ingresa el tipo de Usuario que eres:");
                System.out.println("1) Entrar al Sistema");
                System.out.println("2) Registrarse como Cliente");
                System.out.println("3) Salir");
                int decision;
                decision = lector.nextInt();
                lector.nextLine();
                switch (decision) {
                    case 1:
                        ingresosistem.EntrarSistema();
                        break;

                    case 2:
                        ingresosistem.RegistroClientes();
                        break;

                    case 3:
                        Scanner lector2 = new Scanner(System.in);
                        System.out.println("¿DESEA SALIR DEL SISTEMA?");
                        System.out.println("INGRESA s PARA SI / n PARA NO");
                        String decision2 = lector2.nextLine();
                        if (decision2.toLowerCase().equals("s")) {
                            System.out.println("GRACIAS POR USAR FACEBOOK MARKET PLACE!!");
                            System.out.println("----VUELVA PRONTO----");
                            k = 0;
                            exit=true;
                        }
                        break;
                }
            } while (k == 1);
        } catch (Exception e) {
            System.out.println("Ha ocurrido un error");
            lector.nextLine();
        }
        } while (!exit);
    }
}
