/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espol.grupo1;

import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author HP
 */
public class Comprador extends Usuario{

  private Oferta oferta;

    public Comprador(int id, String nombre, String apellidos, String organizacion, 
            String correoElectronico, String clave) {
        super(id, nombre, apellidos, organizacion, correoElectronico, clave);
    }

    public Oferta getOferta() {
        return oferta;
    }

    public void setOferta(Oferta oferta) {
        this.oferta = oferta;
    }

  @Override//se supone q ya lo hereda asi q despues lo borro
  public void saveFile(String nombreArchivo){
    try(PrintWriter pw= new PrintWriter(new FileOutputStream(new File(nombreArchivo),true))){
        pw.println(super.toString());  
        } 
    catch(Exception e){
        System.out.println(e.getMessage());
        }
    }
  
  public static ArrayList<Comprador> readFile(String nombreArchivo){
        ArrayList<Comprador> lC= new ArrayList<>();
        try(Scanner sc= new Scanner(new File(nombreArchivo))){
          while(sc.hasNextLine()){
            String linea= sc.nextLine();
            String[] el=linea.split("\\|");
            Comprador comprador= new Comprador(Integer.parseInt(el[0]),el[1],el[2],el[3],el[4],el[5]);    
            lC.add(comprador);
          }
        }
        catch(Exception e){
          System.out.println(e.getMessage());
        }
        return lC;
    }
    
public static String buscarClave(String nombreArchivo,String correoElectronico){
        ArrayList<Comprador> lC= Comprador.readFile(nombreArchivo);
        String clave= "";
        for (Comprador c:lC){
            if (c.getCorreoElectronico().equals(correoElectronico))
                clave=c.getClave();
        }
    return clave;
    }

    public static Comprador searchByID(ArrayList<Comprador> compradores, int id){
        for (Comprador c: compradores){
            if (c.getId() == id)
                return c;
            
        }
        return null;
    }

  public void ofertaPorVehiculo(ArrayList<Vehiculo> vehiculos, String tipovehiculo, 
          double recorridoInicio, double recorridoFin, int añoInicio, int añoFin, double precioInicio, 
          double precioFin){
    ArrayList<Vehiculo> vehiculosBuscados = Utilitaria.filtrarVehiculos(vehiculos, tipovehiculo, 
            recorridoInicio, recorridoFin, añoInicio, añoFin, precioInicio, precioFin);
    Vehiculo vehiculoSeleccionado = Utilitaria.navegar(vehiculosBuscados);
    Scanner sc = new Scanner(System.in);
    System.out.println("Ingrese la oferta por el vehiculo elegido: ");
    double monto = sc.nextDouble();
    int idOffer = Utilitaria.nextId("Oferta.txt");
    Oferta oferta = new Oferta(idOffer ,monto, vehiculoSeleccionado, super.getId());
    oferta.saveFile("Oferta.txt");
    }
  
  /*
  public void registrarNuevoComprador(Scanner sc,String nombreArchivo){
   System.out.println("Ingrese nombres: ");
   String n= sc.nextLine();
   System.out.println("Ingrese apellidos: ");
   String a= sc.nextLine();
   System.out.println("Ingrese organización: ");
   String o= sc.nextLine();
   System.out.println("Ingrese correo electrónico: ");
   String cE= sc.nextLine();
   System.out.println("Ingrese correo:");
   String co = sc.nextLine();
   System.out.println("Ingrese clave: ");
   String clav= sc.nextLine();
   int i= Utilitaria.nextId(nombreArchivo);
   Comprador c= new Comprador(i,n,a,o,cE,clav,co);
   c.saveFile(nombreArchivo);
 }
  */
}
