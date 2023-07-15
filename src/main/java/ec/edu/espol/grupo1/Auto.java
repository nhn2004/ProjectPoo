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
 * @author nicol
 */
public class Auto extends Vehiculo {
    private String vidrios;
    private String transmision;

    public Auto(String placa, String modelo, String marca, String tipoMotor, 
            int año, double recorrido, String color, String tipoCosmbustible, 
            double precio,String vidrios, String transmision) {
        super(placa, modelo, marca, tipoMotor, año, recorrido, color, tipoCosmbustible, precio);
        this.vidrios = vidrios;
        this.transmision = transmision;
    }

    public String getVidrios() {
        return vidrios;
    }

    public String getTransmision() {
        return transmision;
    }
    
    @Override
    public String toString(){
        return super.toString()+",/n"
                + "Vidrios = "+this.vidrios+",/n"
                + "Transmisión = "+this.transmision;
    }
    
    @Override
    public void saveFile(String nombreArchivo){
        try(PrintWriter pw= new PrintWriter(new FileOutputStream(new File(nombreArchivo),true))){
            pw.println(toString());//si es que se cambia el toString  
        } 
        catch(Exception e){
          System.out.println(e.getMessage());
        }
    }
    
       
}
