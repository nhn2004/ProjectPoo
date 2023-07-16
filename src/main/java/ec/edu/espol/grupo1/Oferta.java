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

public class Oferta {
    private int id;
    private double precio;
    private Vehiculo vehiculo;
    private Comprador comprador;
    private int idComprador;

    public Oferta(){

    }
    
    public Oferta(int id,double p,int idC){
        this.id=id;
        this.precio=p;
        this.idComprador=idC;
    }
    
    public void registrarOferta(int idOferta, double p,Vehiculo v, int idComprador){
      Oferta oferta = new Oferta(idOferta, p, idComprador);
      ArrayList<Comprador> compradores = Comprador.readFile("Comprador.txt");
      this.comprador = Comprador.searchByID(compradores, idComprador);
      oferta.saveFile("Oferta.txt");
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdComprador() {
        return idComprador;
    }

    public void setIdComprador(int idComprador) {
        this.idComprador = idComprador;
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
    
    public static ArrayList<Oferta> readFile(String nombreArchivo){
        ArrayList<Oferta> lO= new ArrayList<>();
        try(Scanner sc= new Scanner(new File(nombreArchivo))){
          while(sc.hasNextLine()){
            String linea= sc.nextLine();
            String[] el=linea.split("\\|");
            Oferta oferta= new Oferta(Integer.parseInt(el[0]),Double.parseDouble(el[1]),Integer.parseInt(el[2]));
            lO.add(oferta);
          }
        }
        catch(Exception e){
          System.out.println(e.getMessage());
        }
        return lO;
    }
    
    public void saveFile(String nombreArchivo){
        try(PrintWriter pw= new PrintWriter(new FileOutputStream(new File(nombreArchivo),true))){
            pw.println(this.id+"|"+this.precio+"|"+this.idComprador);  
        } 
        catch(Exception e){
          System.out.println(e.getMessage());
        }
    }
}