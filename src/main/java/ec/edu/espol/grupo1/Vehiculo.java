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
 * @author Dom
 */
public class Vehiculo implements Saveable {
    private String placa;
    private String modelo;
    private String marca;
    private String tipoMotor;
    private int año;
    private double recorrido;
    private String color;
    private String tipoCosmbustible;
    private double precio;
    private int idVendedor;
    private Vendedor vendedor;
    ArrayList<Oferta> ofertas;
    
    public Vehiculo(){
        
    }

    public Vehiculo(String placa, String modelo, String marca, String tipoMotor, int año, double recorrido, String color, String tipoCosmbustible, double precio, int idVendedor) {
        this.placa = placa;
        this.modelo = modelo;
        this.marca = marca;
        this.tipoMotor = tipoMotor;
        this.año = año;
        this.recorrido = recorrido;
        this.color = color;
        this.tipoCosmbustible = tipoCosmbustible;
        this.precio = precio;
        this.idVendedor=idVendedor;
        this.ofertas = new ArrayList<>();
        ArrayList<Vendedor> vendedores = Vendedor.readFile("Vendedor.txt");
        this.vendedor= Vendedor.searchByID(vendedores, idVendedor);
    }

    public String getPlaca() {
        return placa;
    }

    public String getModelo() {
        return modelo;
    }

    public String getMarca() {
        return marca;
    }

    public String getTipoMotor() {
        return tipoMotor;
    }

    public int getAño() {
        return año;
    }

    public double getRecorrido() {
        return recorrido;
    }

    public String getColor() {
        return color;
    }

    public String getTipoCosmbustible() {
        return tipoCosmbustible;
    }

    public double getPrecio() {
        return precio;
    }

    public Vendedor getVendedor() {
        return vendedor;
    }

    public ArrayList<Oferta> getOfertas() {
        return ofertas;
    }

    @Override
    public String toString(){
        return "Este vehículo tiene:/n"
                + "Placa = "+this.placa+",/n"
                + "Marca = "+this.marca+",/n"
                + "Modelo = "+this.modelo+",/n"
                + "Tipo de motor = "+this.tipoMotor+",/n"
                + "Año = "+this.año+",/n"
                + "Recorrido = "+this.recorrido+",/n"
                + "Color = "+this.color+",/n"
                + "Tipo de combustible = "+this.tipoCosmbustible+",/n"
                + "Precio = "+this.precio+",/n";
    }
    
    public String lineFile(){
        return ""+this.placa+"|"+this.marca+"|"+this.modelo+"|"+this.tipoMotor+"|"+this.año+"|"+this.recorrido+"|"+this.color+"|"+this.tipoCosmbustible+"|"+this.precio+"|"+this.idVendedor;
    }

     @Override
    public void saveFile(String nombreArchivo){
        try(PrintWriter pw= new PrintWriter(new FileOutputStream(new File(nombreArchivo),true))){
            pw.println(this.lineFile());  
        } 
        catch(Exception e){
          System.out.println(e.getMessage());
        }
    }
    
    public static ArrayList<Vehiculo> readFile(String nombreArchivo){
        ArrayList<Vehiculo> lV= new ArrayList<>();
        try(Scanner sc= new Scanner(new File(nombreArchivo))){
          while(sc.hasNextLine()){
            String linea= sc.nextLine();
            String[] el=linea.split("\\|");
            Vehiculo vehiculo= new Vehiculo(el[0],el[1],el[2],el[3],Integer.parseInt(el[4]),Double.parseDouble(el[5]),el[6],el[7],Double.parseDouble(el[8]),Integer.parseInt(el[9]));    
            lV.add(vehiculo);
          }
        }
        catch(Exception e){
          System.out.println(e.getMessage());
        }
        return lV;
    }
    
}
