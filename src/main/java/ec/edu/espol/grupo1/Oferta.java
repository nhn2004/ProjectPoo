/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espol.grupo1;

import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 *
 * @author HP
 */
public class Oferta {
    private int idOferta;
    private double precio;
    private Vehiculo vehiculo;
    private Comprador comprador;
    private int idComprador;

    public Oferta(){

    }
    public Oferta(int idOferta, double p,Vehiculo v, int idComprador){
      this.idOferta = idOferta;
      precio=p;
      vehiculo=v;
      this.idComprador = idComprador;
      ArrayList<Comprador> compradores = Comprador.readFile("Comprador.txt");
      this.comprador = Comprador.searchByID(compradores, idComprador);
    }

    public double getPrecio() {
        return precio;
    }

    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public Comprador getComprador() {
        return comprador;
    }
 
    public void saveFile(String nombreArchivo){
        try(PrintWriter pw= new PrintWriter(new FileOutputStream(new File(nombreArchivo),true))){
            pw.println(this.precio+"|"+this.vehiculo+"|"+this.comprador);  
        } 
        catch(Exception e){
          System.out.println(e.getMessage());
        }
    }
}
