/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espol.grupo1;

/**
 *
 * @author nicol
 */
public class Camioneta extends Vehiculo {
    private String traccion;
    private String vidrios;
    private String transmision;

    public Camioneta(String placa, String modelo, String marca, String tipoMotor, int año, 
            double recorrido, String color, String tipoCosmbustible, double precio,String traccion, 
            String vidrios, String transmision) {
        super(placa, modelo, marca, tipoMotor, año, recorrido, color, tipoCosmbustible, precio);
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
    
    
}
