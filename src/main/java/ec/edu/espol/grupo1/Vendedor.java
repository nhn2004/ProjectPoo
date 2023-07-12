
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


 }

