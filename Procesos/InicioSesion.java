package Procesos;
import Objetos.Carrito;
import Objetos.Cliente;
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
         System.out.println("Porfavor ingresa tu nombre de usuario:");
         String nombreusu= lector.nextLine();
         int c=1;
         for (Usuario clientelist : clientes_sistema)
         {
            if(clientelist.getNombreusu().equals(nombreusu))
            {
               c=0;
               System.out.println("Usuario encontrado!!, entrando al Menu de Clientes......");
               //FALTA LLAMADA A MENU
            }      
         }
         for(Usuario adminlist : admins_sistema)
         {
            if(adminlist.getNombreusu().equals(nombreusu))
            {
               c=0;
               System.out.println("Usuario encontrado!!, entrando al Menú de Administradores");
               //Falta llamada a menu de admins
            }
         }
         if(c==1)
         {
            System.out.println("----USUARIO NO ENCONTRADO----");
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
      String nombreusu = lector.nextLine();
      System.out.println("Por favor ingresa tu telefono:");
      int numero = read.nextInt();
      Carrito carroclient = new Carrito();

      Cliente newmiembro = new Cliente(nombre,nombreusu,numero,carroclient);
      clientes_sistema.add(newmiembro);
      System.out.println("REGISTRO EXITOSO!!!");
   }  


}
