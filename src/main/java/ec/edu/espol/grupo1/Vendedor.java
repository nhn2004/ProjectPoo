
package ec.edu.espol.grupo1;

/**
 *
 * @author Dom
 */

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class Vendedor extends Usuario{

    private ArrayList<Vehiculo> vehiculos;

    public ArrayList<Vehiculo> getVehiculos() {
        return vehiculos;
    }

    public void setVehiculos(ArrayList<Vehiculo> vehiculos) {
        this.vehiculos = vehiculos;
    }

    public Vendedor(int id, String nombre, String apellidos, String organizacion, String correoElectronico, String clave) {
        super(id, nombre, apellidos, organizacion, correoElectronico, clave);
    }


    
 public void registrarNuevoVendedor(Scanner sc,String nombreArchivo){
   System.out.println("Ingrese nombres: ");
   String n= sc.nextLine();
   System.out.println("Ingrese apellidos: ");
   String a= sc.nextLine();
   System.out.println("Ingrese organización: ");
   String o= sc.nextLine();
   System.out.println("Ingrese correo electrónico: ");
   String cE= sc.nextLine();
   System.out.println("Ingrese clave: ");
   String clav= sc.nextLine();
   int i= Utilitaria.nextId(nombreArchivo);
   Vendedor v= new Vendedor(i,n,a,o,cE,clav);
   v.saveFile(nombreArchivo);
 }
 
 public void registrarNuevoVehiculo(String nombreArchivo){
    Scanner sc= new Scanner(System.in);

    System.out.println("Ingrese su correo electrónico: ");
    String cE= sc.nextLine();
    String claveSistema= Vendedor.buscarClave(nombreArchivo,cE);
    System.out.println("Ingrese su clave: ");
    boolean validacionClave= Utilitaria.validarClave(claveSistema, clave);
    if (validacionClave==true){
      System.out.print("Ingrese la placa: ");
      String placa = sc.nextLine();
      boolean validacion=true;

      for (Vehiculo v:vehiculos){
     if (!(placa.equals(v.getPlaca()))){
       validacion=false;}
      }

   if (validacion==false){
      System.out.println("Ingrese el tipo de Vehículo a registrar: ");
     String t= sc.nextLine();

       System.out.print("Ingrese la marca: ");
     String marca = sc.nextLine();

     System.out.print("Ingrese el modelo: ");
     String modelo = sc.nextLine();

     System.out.print("Ingrese el tipo de motor: ");
     String tipoMotor = sc.nextLine();

     System.out.print("Ingrese el año: ");
     int año = sc.nextInt();
     sc.nextLine();
     System.out.print("Ingrese el recorrido: ");
     int recorrido = sc.nextInt();
     sc.nextLine(); // Consumir la nueva línea después de leer el número
     System.out.print("Ingrese el color: ");
     String color = sc.nextLine();
     System.out.print("Ingrese el tipo de combustible: ");
     String tipoCombustible = sc.nextLine();
     System.out.print("Ingrese el precio: ");
     double precio = sc.nextDouble();
     sc.nextLine(); // Consumir la nueva línea después de leer el número

    String tipo= t.toLowerCase();
     switch (tipo){
       case "camioneta":
         //Tracción,vidrios,transmision
         System.out.print("Ingrese la tracción: ");
         String traccion = sc.nextLine();
         System.out.print("Ingrese los vidrios: ");
         String vidrios = sc.nextLine();
         System.out.print("Ingrese la transmisión: ");
         String transmision = sc.nextLine();
         Camioneta c= new Camioneta(placa, modelo, marca, 
                 tipoMotor, año, recorrido, color, tipoCombustible, 
                 precio,traccion, vidrios, transmision);
         c.saveFile(nombreArchivo);
         
         break;
       case "auto":
         System.out.print("Ingrese los vidrios: ");
         String vid = sc.nextLine();
         System.out.print("Ingrese la transmisión: ");
         String transm = sc.nextLine();
         Auto a= new Auto(placa, modelo, marca, 
                 tipoMotor, año, recorrido, color, 
                 tipoCombustible, precio,vid, transm);
         a.saveFile(nombreArchivo);
         break;
       case "moto":
         Vehiculo m= new Vehiculo(placa, modelo, marca, tipoMotor, año, recorrido, color, tipoCombustible, precio);
         m.saveFile(nombreArchivo);
         break;
       default:
         Vehiculo d= new Vehiculo(placa, modelo, marca, tipoMotor, año, recorrido, color, tipoCombustible, precio);
         d.saveFile(nombreArchivo);
         break;
     }

   }
    }
 }
 
 public void aceptarOferta(String cE,String clave){
    Scanner sc= new Scanner(System.in);
    System.out.println("Ingrese la placa: ");
    String placa= sc.nextLine();

    Vehiculo v= Utilitaria.filtrarPorPlaca(vehiculos,placa);
    System.out.println(""+v.getMarca()+" "+v.getModelo()+" Precio: "+v.getPrecio());
    int tamaño= v.getOfertas().size();
    int seleccion = 0;
    Oferta oferta;
    int i=0;
    do{
      System.out.println("Oferta "+(i+1)+":");
      
      oferta= v.getOfertas().get(i);  
      System.out.println("Correo: "+oferta.getComprador().getCorreo());
      System.out.println("Precio "+oferta.getPrecio());
      if (tamaño>0 && i==0){
        System.out.println("1.- Siguiente Oferta");
        System.out.println("2.- Aceptar Oferta");
      }
      else if(tamaño>i){
        System.out.println("1.- Siguiente Oferta");
        System.out.println("2.- Aceptar Oferta");
        System.out.println("3.- Anterior Oferta");
      }
      else{
        System.out.println("2.- Aceptar Oferta");
        System.out.println("3.- Anterior Oferta");
      }
      seleccion= sc.nextInt();
      sc.nextInt();
      switch (seleccion) {
                case 1:
                    i++;
                    if (i >= tamaño) {
                        System.out.println("Has revisado todos los vehículos.");
                        i--;
                    }
                    break;

                case 2:
//                    elimina de la base ese vehiculo;

                case 3:
                    i--;
                    if (i < 0) {
                        System.out.println("Ya estás en el primer vehículo.");
                        i++;
                    }
                    break;

                default:
                    System.out.println("Opción inválida. Por favor, selecciona una opción válida.");
                    break;
            }
      
    }while (seleccion != 2);
   }

 }

