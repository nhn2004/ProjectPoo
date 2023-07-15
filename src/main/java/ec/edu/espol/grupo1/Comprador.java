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

  private String correo;
  private Oferta oferta;

    public Comprador(String correo, Oferta oferta, int id, String nombre, String apellidos, String organizacion, String correoElectronico, String clave) {
        super(id, nombre, apellidos, organizacion, correoElectronico, clave);
        this.correo = correo;
        this.oferta = oferta;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public Oferta getOferta() {
        return oferta;
    }

    public void setOferta(Oferta oferta) {
        this.oferta = oferta;
    }

  
  public void saveFile(String nombreArchivo){
    try(PrintWriter pw= new PrintWriter(new FileOutputStream(new File(nombreArchivo),true))){
        pw.println(this.id+"|"+this.nombre+"|"+this.apellidos+"|"+this.organizacion+"|"+this.correoElectronico+"|"+this.correo+"|"+this.clave);  
        } 
    catch(Exception e){
        System.out.println(e.getMessage());
        }
    }
  
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
   Comprador c= new Comprador(i,n,a,o,cE,co,clav);
   c.saveFile(nombreArchivo);
 }
  
  public void ofertaPorVehiculo(ArrayList<Vehiculo> vehiculos, String tipovehiculo, double recorridoInicio, double recorridoFin, int añoInicio, int añoFin, double precioInicio, 
          double precioFin, String nomArchivo){
    ArrayList<Vehiculo> vehiculosBuscados = Utilitaria.filtrarVehiculos(vehiculos, tipovehiculo, recorridoInicio, recorridoFin, añoInicio, añoFin, precioInicio, precioFin);
    Vehiculo vehiculoSeleccionado = Utilitaria.navegar(vehiculosBuscados);
    Scanner sc = new Scanner(System.in);
    System.out.println("Ingrese la oferta por el vehiculo elegido: ");
    double monto = sc.nextDouble();
    Oferta oferta = new Oferta(monto, vehiculoSeleccionado, this);
    oferta.saveFile(nomArchivo);//no estoy muy seguro de como obter el nombre del archivo donde se registrará la oferta, mientras tanto la pongo en los 
    //parametros del constructor

    }
}
