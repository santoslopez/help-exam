import java.util.*;

//esto es para poder usar la clase Pattern

import java.util.regex.*;
public class Solucion{

  /*variables que nos va a servir para guardar los datos que va contener el linkedList*/
  private String usuario;
  private String nombre;
  private String password;

  /*creamos una instancia de LinkedList estatico porque lo vamos a llamar desde el metodo menuPrincipal y este es estatico*/
  private static LinkedList linkedList=new LinkedList();

  //constructor de 3 parametros
  public Solucion(String usuario,String nombre,String password){
    this.usuario=usuario;
    this.nombre=nombre;
    this.password=password;
  }


  //le vamos a dar un formato al toString para que nos despliege correctamente nuestros datos
  public String toString(){
    String informacion = "Usuario: "+this.usuario + " Nombre: " + this.nombre +  " Password: " +this.password;
    return informacion;
  }


  //desplegamos el contenido de un linkedlist, este metodo lo vamos a utilizar cuando queremos eliminar un usuario o desplegar usuario
  public static void recorrerLista(LinkedList linkedList){
    //verificamos si el LinkedList esta vacio
    if(linkedList.isEmpty()){
    System.out.println("ERROR!!! La lista está vacia. ");
    menuPrincipal();
    }

    int longitudLista=linkedList.size();
    //recorremos nuestra lista
    for (int ind=0; ind<longitudLista;ind++ ) {
        //imprimos nuestra lista agregandole el numero de indice de cada dato
        System.out.println("Indice: "+ind+ " "+linkedList.get(ind).toString());
    }
  }

  public static void menuPrincipal(){

    Scanner escaner = new Scanner(System.in);
    System.out.println("1. Agregar usuario");
    System.out.println("2. Listar");
    System.out.println("3. Modificar usuario");
    System.out.println("4. Eliminar usuario");
    System.out.println("5. Salir");


    //vamos a permitir que ingresen un textos
    String opciones = escaner.nextLine();

    //hacemos uso de las expresiones regulares, indicamos que vamos a permitir numero del 1 al 5, y solo se va permitir
    //un solo numero
    if (Pattern.matches("[1-5]{1}",opciones) ) {
      /*Dependiendo del numero ingresado va realizar la accion correspondiente al numero del menu, de lo contrario
      vamos a desplegar un mensaje de opcion incorrecta*/
      switch (opciones) {
        //vamos agregar un usuario
        case "1":

        //lo declaramos aqui para que podamos usarlo cuando pedimos usuario, nombre, password
        Scanner agregar = new Scanner(System.in);


        /*vamos a pedir un nombre de usuario, nombre, y password -> 3 datos.
        Si pidieramos solo 2 datos el constructor debe tener solo 2 parametros
        public Solucion(String usuario,String nombre){
          this.usuario=usuario;
          this.nombre=nombre;
        }*/
        System.out.println("Nombre del usuario: ");
        String agregarUsuario = agregar.nextLine();

        System.out.println("Ingrese su nombre: ");
        String  agregarNombre = agregar.nextLine();

        System.out.println("Ingrese su password: ");
        String  agregarPassword = agregar.nextLine();

        /*
        Nota: aqui podes poner otro o otros:
        System.out.println("Confirme su password: ");
        String  confirmarPassword = agregar.nextLine();

        y este te puede servir para confirmar el password

        if (agregarPassword.equals(confirmarPassword)) {
          //todo el codigo que empieza en System.out.println y termina en menuPrincipal();
          TODO ESE CODIGO VA AQUI
        }else{
          System.out.println("Las contrasenas no son iguales no se agrego el usuario");
        }
        */

        //mostramos un resumen de usuario agregado correctamente
        System.out.println("\nUsuario agregado correctamente!!!\n");

        /*hacemos uso del constructor de 3 parametros para guardar estos valores en el LinkedList*/
        Solucion todosDatos = new Solucion(agregarUsuario,agregarNombre,agregarPassword);
        linkedList.add(todosDatos);//agregamos los datos al linkedlist

        //volvemos a llamar al menu principal para no cerrar el programa
        menuPrincipal();

        break;

        //vamos a listar todos los usuarios
        case "2":

        //invocamos al metodo que habiamos declarado para listar los usuarios, le pasamos el parametro de LinkedList
        recorrerLista(linkedList);
        //volvemos a llamar al menu principal para que siempre se permita a realizar una accion hasta que se ingrese la opcion de salir
        menuPrincipal();
        break;

        //vamos a modificar los datos del usuario
        case "3":
        recorrerLista(linkedList);

        /*nada del otro mundo, declaracion de variables y Scanner*/
        System.out.println("-----------ACTUALIZACION DE DATOS-----------------");
        Scanner modificarValor = new Scanner(System.in);
        System.out.println("Ingrese el indice del usuario a MODIFICAR: ");
        int indiceModificar = Integer.parseInt(modificarValor.nextLine());//por medio del indice vamos a saber que datos modificar

        System.out.println("Actualice su usuario: ");
        String updateUsuario = modificarValor.nextLine();

        System.out.println("Actualice su nombre: ");
        String  updateNombre = modificarValor.nextLine();

        System.out.println("Actualice su password: ");
        String  updatePassword = modificarValor.nextLine();

        /*hacemos uso del constructor de 3 parametros para guardar estos valores en el LinkedList*/
        Solucion updateDatos = new Solucion(updateUsuario,updateNombre,updatePassword);

        linkedList.set(indiceModificar,updateDatos);//actualizamos todos los datos del usuario

        System.out.println("Usuario modificado correctamente!!!");
        menuPrincipal();
        break;

        case "4":
        //invocamos al metodo que habiamos declarado
        recorrerLista(linkedList);//mostramos los valores del linkedList si hubiera datos
        System.out.println("----------------------------");
        Scanner eliminarValor = new Scanner(System.in);
        System.out.println("Ingrese el indice del usuario a eliminar: ");
        int indiceEliminar = eliminarValor.nextInt();
        linkedList.remove(indiceEliminar);//eliminamos el usuario por medio del indice ingresado
        System.out.println("Usuario eliminado correctamente!!!");
        menuPrincipal();
        break;

        case "5":
        System.out.println("Saliendo del programa");
        System.exit(0);//salimos del menu principal
        break;

      }
    }else{
      System.out.println("Lo que ingreso no es una opcion correcta");
      //repetimos el ciclo
      menuPrincipal();
    }
  }
}
