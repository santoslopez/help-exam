import java.util.*;

//esto es para poder usar la clase Pattern

import java.util.regex.*;
public class Solucion{

  /*variables que nos va a servir para guardar los datos que va contener el linkedList*/
  private String usuario;
  private String nombre;
  private String password;
  private static LinkedList linkedList =
  linkedList=new LinkedList();//creamos una instancia de LinkedList
  //estatico porque lo vamos a llamar desde el metodo menuPrincipal y este es estatico

  //constructor y este va servir para hacerle saber al linkedList que vamos almacenar 3 valores
  public Solucion(String usuario,String nombre,String password){
    this.usuario=usuario;
    this.nombre=nombre;
    this.password=password;
  }


  //le vamos a dar un formato al toString para que nos despliege correctamente nuestros datos
  public String toString(){
    String informacion = "Usuario: "+this.usuario + " Nombre: " + this.nombre +  "Password: " +this.password;
    return informacion;
  }


  //vamos a pasarle un parametro de tipo LinkedList para desplegar su contenido
  public static void listado(LinkedList linkedList){

    //si el contenido del linkedList esta vacio
    if(linkedList.isEmpty()){
    System.out.println("La lista está vacia");
    return;
    }

    //la clase Iterator nos va servir para recorrer los datos del linkedList
    Iterator it = linkedList.iterator();

    System.out.println("Los elementos de la lista son: ");
    while(it.hasNext()){
      System.out.println(it.next().toString());
    }

  }

  public static void menuPrincipal(){

    Scanner escaner = new Scanner(System.in);
    System.out.println("1. Agregar usuario");
    System.out.println("2. Listar");
    System.out.println("3. Buscar usuario");
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

        /*desplegamos un resumen con los datos del usuario*/
        System.out.println("Resumen");
        System.out.println("Nombre usuario :"+agregarUsuario);
        System.out.println("Nombre :"+agregarNombre);
        System.out.println("Nombre :"+agregarPassword);


        /*hacemos uso del constructor de 3 parametros para guardar estos valores en el LinkedList*/
        Solucion todosDatos = new Solucion(agregarUsuario,agregarNombre,agregarPassword);
        linkedList.add(todosDatos);//agregamos los datos al linkedlist

        //volvemos a llamar al menu principal para no cerrar el programa
        menuPrincipal();

        break;

        //vamos listar
        case "2":

        listado(linkedList);
        //volvemos a llamar al menu principal para que siempre se permita a realizar una accion hasta que se ingrese la opcion de salir
        menuPrincipal();
        break;

        //vamos eliminar
        case "3":
        break;

        case "4":
        break;

        case "5":
        System.out.println("Saliendo del programa");
        System.exit(0);//salimos del menu principal
        break;

        /*esto puede ser opcional*/
        default:
        System.out.println("Opcion incorrecta");
        break;

      }
    }else{
      System.out.println("Lo que ingreso no es una opcion correcta");
      //repetimos el ciclo
      menuPrincipal();
    }
  }

}
