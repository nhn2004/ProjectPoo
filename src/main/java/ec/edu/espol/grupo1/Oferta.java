/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espol.grupo1;

import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintWriter;

/**
 *
 * @author HP
 */
public class Oferta {
    private double precio;
    private Vehiculo vehiculo;
    private Comprador comprador;

    public Oferta(){

    }
    public Oferta(double p,Vehiculo v,Comprador c){
      precio=p;
      vehiculo=v;
      comprador=c;
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
