
package ec.edu.espol.grupo1;

/**
 *
 * @author Dom
 */

import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Vendedor{
    private int id;
    private String nombres;
    private String apellidos;
    private String organizacion;
    private String correoElectronico;
    private String clave;
    private ArrayList<Vehiculo> vehiculos;

    public Vendedor(){}


    public Vendedor(int id,String n,String a,String o,String cE,String clave){
        this.id=id;
        this.nombres=n;
        this.apellidos=a;
        this.organizacion=o;
        this.correoElectronico= cE;
        this.clave=clave;
        this.vehiculos= new ArrayList<>();
    }

    public void saveFile(String nombreArchivo){
        try(PrintWriter pw= new PrintWriter(new FileOutputStream(new File(nombreArchivo),true))){
          pw.println(this.id+"|"+this.nombres+"|"+this.apellidos+"|"+
                  this.organizacion+"|"+this.correoElectronico+"|"+this.clave);  
        } catch(Exception e){
          System.out.println(e.getMessage());
        }
    }


    public static ArrayList<Vendedor> readFile(String nombreArchivo){
        ArrayList<Vendedor>  vendedores= new ArrayList<>();
        try(Scanner sc= new Scanner(new File(nombreArchivo))){
          while(sc.hasNextLine()){
            String linea= sc.nextLine();
            String[] el=linea.split("\\|");//el: elementos
            Vendedor vendedor= new Vendedor(Integer.parseInt(el[0]),el[1],el[2],el[3],el[4],el[5]);
            vendedores.add(vendedor);
          }
        }catch(Exception e){
          System.out.println(e.getMessage());
        }
        return vendedores;
    }

    public static String buscarClave(String nombreArchivo,String correoElectronico){
        ArrayList<Vendedor> lV= Vendedor.readFile(nombreArchivo);
        String clave= "";
        for (Vendedor v:lV){
            if (v.correoElectronico.equals(correoElectronico)){
                clave=v.clave;
            }
        }
        return clave;
    }
 
 public void aceptarOferta(String cE,String clave){
   //validar si la clave es correcta: calcular el hash de la clave y compararla con la que está almacenada en el archivo.
     /*
El vendedor podrá revisar las ofertas para los vehículos ingresando la placa del vehículo. Las ofertas deben presentarse de una manera interactiva al momento de revisar las ofertas. La aplicación presenta una oferta a la vez y debe permitirle al vendedor revisar la siguiente oferta, en su defecto, cuando vaya avanzado entre las ofertas, debe tener la posibilidad de regresar a revisar otra oferta.*/

 

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
/*
     Ingrese la placa: PBA5050
     Renault Logan 1.6 Precio: 16000
     Se han realizado 3 ofertas
     Oferta 1
     Correo: jperez@gmail.com
     Precio Ofertado: 15500
     1.- Siguiente Oferta
     2.- Aceptar Oferta
*/
   /*Cuando el vendedor acepta la oferta,
el vehículo que está a la venta debe eliminarse del sistema
y enviarle un correo al comprador del cual se aceptó la oferta confirmándole que se ha aceptado su oferta.*/
 


 }

