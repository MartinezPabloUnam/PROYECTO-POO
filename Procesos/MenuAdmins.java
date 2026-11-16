package Procesos;

import Objetos.Admin;
import java.util.Scanner;
/**
 * @author Francisco Javier Montiel Montejano, Pablo Issac Martinez Giles,Angel Uriel Gutierrez Contreras
 * MenuAdmins
 */
public class MenuAdmins 
{
    private Admin adminactual;
    /**
     * Constructor del MenuAdmins
     * @param adminlist recibe como paramtero el administrador de la lista de administradores que entrara en el menu
     */
    public MenuAdmins(Admin adminlist)
    {
        this.adminactual=adminlist;
    }

    /**
     * metodo que contoiene el menu principal de administradores con las opciones que este puede realizar
     */
    public void adminmenu()
    {
        int k=1;
        Scanner lector = new Scanner(System.in);
        System.out.println("BIENVENIDO ADMINISTRADOR "+adminactual.getNombreusu());
        do{
            System.out.println("Elige el proceso que deseas ejecutar:");
            System.out.println("1) ALTA DE PRODUCTOS");
            System.out.println("2) MODIFICACION DE PRECIOS");
            System.out.println("3) REGRESAR AL MENU PRINCIPAL");
            int decision = lector.nextInt();
            switch(decision)
            {
                case 1:
                    //metodo alta de productos
                    break;
                
                case 2:
                    //metodo modificacion de productos
                    break;

                case 3:
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
}
