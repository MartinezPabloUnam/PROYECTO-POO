package Procesos;
import Objetos.Usuario;
import java.util.ArrayList;
import java.util.Scanner;

public class InicioSesion 
{

   ArrayList <Usuario> clientes_sistema;
   ArrayList <Usuario> admins_sistema;

   public InicioSesion()
   {
      this.admins_sistema=new ArrayList<>();
      this.clientes_sistema=new ArrayList<>();
   }

   public void EntrarSistema()
   {
         Scanner lector = new Scanner(System.in);
         System.out.println("Porfavor ingresa tu nombre de ususario:");
         String nombreusu= lector.nextLine();
         for (Usuario clientelist : clientes_sistema)
         {
            if(clientelist.getNombreusu().equals(nombreusu))
            {
               System.out.println("Usuario encontrado!!, entrando al Menu de Clientes......");
               //FALTA LLAMADA A MENU
            }      
         }
         for(Usuario adminlist : admins_sistema)
         {
            if(adminlist.getNombreusu().equals(nombreusu))
            {
               System.out.println("Usuario encontrado!!, entrando al Menú de Administradores");
               //Falta llamada a menu de admins
            }
         }
   }

   public void RegistroClientes()
   {
      Scanner lector = new Scanner(System.in);
      Scanner read = new Scanner(System.in);
      System.out.println("BIENVENIDO NUEVO CLIENTE!!!");
      System.out.println("Por favor ingresa tu nombre completo:");
      String nombre = lector.nextLine();
      System.out.println("Por favor ingresa tu nombre de usuario:");
      String nombreudu = lector.nextLine();
      System.out.println("Por favor ingresa tu telefono:");
   }  int numero = read.nextInt();

}
