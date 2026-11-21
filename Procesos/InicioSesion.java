package Procesos;
import Objetos.Admin;
import Objetos.Carrito;
import Objetos.Cliente;
import Objetos.Usuario;
import java.util.ArrayList;
import java.util.Scanner;
/**
 * @author Francisco Javier Montiel Montejano, Pablo Isaac Martinez Giles,Angel Uriel Gutierrez Contreras
 * InicioSesion
 */
public class InicioSesion 
{

   ArrayList <Usuario> clientes_sistema;
   ArrayList <Usuario> admins_sistema;

   /**
    *Contructor de la intancia de inicio de sesion este inicializa las listas de administradores y de clientes 
    */
   public InicioSesion()
   {
      this.admins_sistema=new ArrayList<>();
      this.clientes_sistema=new ArrayList<>();
      
         Admin Francisco=new Admin("Francho");
         Admin Pablo=new Admin("Pavo");
         Admin Angel=new Admin("Engel");
         Admin Beto=new Admin("Robert");
         
         admins_sistema.add(Francisco);
         admins_sistema.add(Pablo);
         admins_sistema.add(Angel);
         admins_sistema.add(Beto);
   }

   /**
    * metodo que sirve para poder acceder al sistema del menu de clientes o administrador segun el nombre de usuario ingresado
    */
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
               MenuClientes menucli = new MenuClientes((Cliente)clientelist);
               menucli.clientemenu();
               break;
            }      
         }
         for(Usuario adminlist : admins_sistema)
         {
            if(adminlist.getNombreusu().equals(nombreusu))
            {
               c=0;
               System.out.println("Usuario encontrado!!, entrando al Menú de Administradores");
               MenuAdmins menuad = new MenuAdmins((Admin)adminlist);
               menuad.adminmenu();
               break;
            }
         }
         if(c==1)
         {
            System.out.println("----USUARIO NO ENCONTRADO----");
         }

   }

   /**
    * Metodo para agregar un nuevo cliente a la lista de clientes validando que no se repitan usuarios
    */
   public void RegistroClientes()
   {
      Scanner lector = new Scanner(System.in);
      Scanner read = new Scanner(System.in);
      System.out.println("BIENVENIDO NUEVO CLIENTE!!!");
      System.out.println("Por favor ingresa tu nombre completo:");
      String nombre = lector.nextLine();
      System.out.println("Por favor ingresa tu nombre de usuario:");
      String nombreusu = lector.nextLine();
      

      boolean existe=false;

      for(Usuario usu : clientes_sistema)
      {
         if(usu.getNombreusu().equals(nombreusu))
         {
            existe = true;
            break;
         }
      }

      for(Usuario usuad : admins_sistema)
      {
         if(usuad.getNombreusu().equals(nombreusu))
         {
            existe = true;
            break;
         }
      }


      if(existe) 
      {
       System.out.println("---- ERROR: El nombre de usuario '" + nombreusu + "' ya está en uso. Intente con otro. ----");
      }  
      else
      {
         try {
            System.out.println("Por favor ingresa tu telefono:");
            long numero = read.nextLong();
            Carrito carroclient = new Carrito();
            Cliente newmiembro = new Cliente(nombre,nombreusu,numero,carroclient);
            clientes_sistema.add(newmiembro);
            System.out.println("REGISTRO EXITOSO!!!");
         } catch (Exception e) {
            System.out.println("Ups, ha ocurrido un error");
         }
      
      }
      
   }  

}
