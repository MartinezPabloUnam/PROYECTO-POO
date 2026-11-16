package Procesos;

import Objetos.Admin;
import java.util.Scanner;

public class MenuAdmins 
{
    private Admin adminactual;

    public MenuAdmins(Admin adminlist)
    {
        this.adminactual=adminlist;
    }

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
