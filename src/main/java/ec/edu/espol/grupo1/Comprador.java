/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espol.grupo1;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author HP
 */
public class Comprador {
  private int id;
  private String nombre;
  private String apellidos;
  private String organizacion;
  private String correoElectronico;
  private String correo;
  private String clave;
  private Oferta oferta;

  public Comprador(int id,String n, String a, String o, String cE, String c, String cl){
    this.id=id;
    this.nombre = n;
    this.apellidos = a;
    this.correoElectronico = cE;
    this.organizacion = o;
    this.correo = c;
    this.clave = cl;
    this.oferta = new Oferta();
  }

//getters
  
  public String  getNombre(){
    return this.nombre;
  }

  public String getApellidos(){
    return this.apellidos;
  }

  public String correoElectronico(){
    return this.correoElectronico;
  }

  public String getOrganizacion(){
    return this.organizacion;
  }

  public String getCorreo(){
    return this.correo;
  }

  public String getClave(){
    return this.clave;
  }

  public Oferta getOferta(){
    return this.oferta;
  }

// setters
  
  public void setNombre(String n){
    this.nombre = n;
  }

  public void setApellidos(String a){
    this.apellidos = a;
  }

  public void setCorreoElectronico(String cE){
    this.correoElectronico = cE;
  }

  public void setOrganizacion(String o){
    this.organizacion = o;
  }

  public void setCorreo(String c){
    this.correo = c;
  }

  public void setClave(String cl){
    this.clave = cl;
  }

  public void setOferta(Oferta o){
    this.oferta = o;
  }
  
  public void registrarComprador(){
      
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
