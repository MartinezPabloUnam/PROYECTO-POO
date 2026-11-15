
package Principal;

import java.util. Scanner;
import Procesos.InicioSesion;
public class Principal 
{
    public static void main(String[] args) 
    {
        Scanner lector= new Scanner(System.in);
        int k=1;
        System.out.println("BIENVENIDO A FACEBOOK MARKETPLACE!!!");
        do{
            System.out.println("Ingresa el tipo de Usuario que eres:");
            System.out.println("1) Soy Administrador");
            System.out.println("2) Soy cliente");
            System.out.println("3) Salir");
            int decision= lector.nextInt();

            switch (decision)
            {
                case 1:
                    
                    break;
                
                case 2:
                    System.out.println("BIENVENIDO CLIENTE!!!");
                    break;

                case 3:
                    Scanner lector2 = new Scanner(System.in);
                    System.out.println("¿DESEA SALIR DEL SISTEMA?");
                    System.out.println("INGRESA s PARA SI / n PARA NO");
                    String decision2= lector2.nextLine();
                    if(decision2.equals("n"))
                    {
                        System.out.println("GRACIAS POR USAR FACEBOOK MARKET PLACE!!");
                        System.out.println("----VUELVA PRONTO----");
                        k=0;
                    }
                    break;
            }
    } while(k==1);
    }
}
