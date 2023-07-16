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
 * @author nicol
 */
public class Camioneta extends Vehiculo {
    private String traccion;
    private String vidrios;
    private String transmision;

    public Camioneta(String placa, String modelo, String marca, String tipoMotor, int año, 
            double recorrido, String color, String tipoCosmbustible, double precio, int idVendedor,String traccion, 
            String vidrios, String transmision) {
        super(placa, modelo, marca, tipoMotor, año, recorrido, color, tipoCosmbustible, precio,idVendedor);
        this.traccion = traccion;
        this.vidrios = vidrios;
        this.transmision = transmision;
    }

    public String getTraccion() {
        return traccion;
    }
    

    public String getVidrios() {
        return vidrios;
    }

    public String getTransmision() {
        return transmision;
    }
    
    @Override
    public String toString(){
        return (super.toString()+",/n"
                + "Vidrios = "+this.vidrios+",/n"
                + "Transmisión = "+this.transmision+",/n"
                + "Tracción = "+this.traccion);
    }
    
    @Override
    public String lineFile(){
        return super.lineFile()+this.vidrios+"|"+this.transmision+this.traccion;
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
        ArrayList<Vehiculo> lC= new ArrayList<>();
        try(Scanner sc= new Scanner(new File(nombreArchivo))){
          while(sc.hasNextLine()){
            String linea= sc.nextLine();
            String[] el=linea.split("\\|");
            Camioneta camioneta= new Camioneta(el[0],el[1],el[2],el[3],Integer.parseInt(el[4]),
                    Double.parseDouble(el[5]),el[6],el[7],
                    Double.parseDouble(el[8]),Integer.parseInt(el[9]),
                    el[10],el[11],el[12]);    
            lC.add(camioneta);
          }
        }
        catch(Exception e){
          System.out.println(e.getMessage());
        }
        return lC;
    }
}
