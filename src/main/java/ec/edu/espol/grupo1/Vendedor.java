
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

    public Vendedor(int id, String nombre, String apellidos, String organizacion, String correoElectronico, String clave) {
        super(id, nombre, apellidos, organizacion, correoElectronico, clave);
    }

public static ArrayList<Vendedor> readFile(String nombreArchivo){
        ArrayList<Vendedor> lV= new ArrayList<>();
        try(Scanner sc= new Scanner(new File(nombreArchivo))){
          while(sc.hasNextLine()){
            String linea= sc.nextLine();
            String[] el=linea.split("\\|");
            Vendedor vende= new Vendedor(Integer.parseInt(el[0]),el[1],el[2],el[3],el[4],el[5]);    
            lV.add(vende);
          }
        }
        catch(Exception e){
          System.out.println(e.getMessage());
        }
        return lV;
    }
    
public static String buscarClave(String nombreArchivo,String correoElectronico){
        ArrayList<Vendedor> lV= Vendedor.readFile(nombreArchivo);
        String clave= "";
        for (Vendedor v:lV){
            if (v.getCorreoElectronico().equals(correoElectronico))
                clave=v.getClave();
        }
    return clave;
    }

 public void registrarNuevoVehiculo(String nombreArchivo){
    Scanner sc= new Scanner(System.in);

    System.out.println("Ingrese su correo electrónico: ");
    String cE= sc.nextLine();
    String claveSistema= Vendedor.buscarClave(nombreArchivo,cE);
    System.out.println("Ingrese su clave: ");
    String clave= sc.nextLine();
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
     sc.nextLine();
     System.out.print("Ingrese el color: ");
     String color = sc.nextLine();
     System.out.print("Ingrese el tipo de combustible: ");
     String tipoCombustible = sc.nextLine();
     System.out.print("Ingrese el precio: ");
     double precio = sc.nextDouble();
     sc.nextLine(); 

    String tipo= t.toLowerCase();
     switch (tipo){
       case "camioneta" -> {
           System.out.print("Ingrese la tracción: ");
           String traccion = sc.nextLine();
           System.out.print("Ingrese los vidrios: ");
           String vidrios = sc.nextLine();
           System.out.print("Ingrese la transmisión: ");
           String transmision = sc.nextLine();
           Camioneta c= new Camioneta(placa, modelo, marca,
                   tipoMotor, año, recorrido, color, tipoCombustible,
                   precio,super.getId(),traccion, vidrios, transmision);
           c.saveFile(nombreArchivo);
           this.vehiculos.add(c);
              }
       case "auto" -> {
           System.out.print("Ingrese los vidrios: ");
           String vid = sc.nextLine();
           System.out.print("Ingrese la transmisión: ");
           String transm = sc.nextLine();
           Auto a= new Auto(placa, modelo, marca,
                   tipoMotor, año, recorrido, color,
                   tipoCombustible, precio,super.getId(),vid, transm);
           a.saveFile(nombreArchivo);
           this.vehiculos.add(a);
              }
       case "moto" -> {
           Vehiculo m= new Vehiculo(placa, modelo, marca, tipoMotor, año, recorrido, color, tipoCombustible, precio,super.getId());
           m.saveFile(nombreArchivo);
           this.vehiculos.add(m);
              }
       
        }

        }
    }
 }
 
    public static Vendedor searchByID(ArrayList<Vendedor> vendedores, int id){
        for (Vendedor v: vendedores){
            if (v.getId() == id)
                return v;
            
        }
        return null;
    }
 
 public void aceptarOferta(){
    Scanner sc= new Scanner(System.in);
    System.out.println("Ingrese su correo electrónico: ");
    String cE= sc.nextLine();
    String claveSistema= Vendedor.buscarClave("Vendedor.txt",cE);
    System.out.println("Ingrese su clave: ");
    String clave= sc.nextLine();
    boolean validacionClave= Utilitaria.validarClave(claveSistema, clave);
    if (validacionClave==true){
        System.out.println("Ingrese la placa: ");
        String placa= sc.nextLine();
                    
        Vehiculo v= Utilitaria.filtrarPorPlaca(vehiculos,placa);
        System.out.println(""+v.getMarca()+" "+v.getModelo()+" Precio: "+v.getPrecio());
        int tamaño= v.getOfertas().size();
        int seleccion;
        Oferta oferta;
        int i=0;
        do{
          System.out.println("Oferta "+(i+1)+":");

          oferta= v.getOfertas().get(i);  
          System.out.println("Correo: "+oferta.getComprador().getCorreoElectronico());
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
                    case 1 -> {
                        i++;
                        if (i >= tamaño) {
                            System.out.println("Has revisado todos los vehículos.");
                            i--;
                        }
                }
                    case 2 -> {
                        String mensaje= "Hola, es un placer hacer negocios contigo, mi "+v.getMarca()+" "+v.getModelo()+" pronto sera tuyo, responde a este correo para hablar";
                        String asunto= ""+v.getVendedor().getNombre()+" acepto tu oferta!!!";
                        Utilitaria.enviarCorreo(oferta.getComprador().getCorreoElectronico(), asunto, mensaje);
                        // solo falta elimina el auto del sistema
                    }

                    case 3 -> {
                        i--;
                        if (i < 0) {
                            System.out.println("Ya estás en el primer vehículo.");
                            i++;
                        } 
                }
                    default -> System.out.println("Opción inválida. Por favor, selecciona una opción válida.");
                }

        }while (seleccion != 2);
    }
    
   }

 }

