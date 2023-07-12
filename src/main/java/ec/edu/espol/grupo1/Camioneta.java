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

    public Camioneta(String traccion, String vidrios, String transmision, String placa, String modelo, String marca, String tipoMotor, int año, double recorrido, String color, String tipoCosmbustible, double precio) {
        super(placa, modelo, marca, tipoMotor, año, recorrido, color, tipoCosmbustible, precio);
        this.traccion = traccion;
        this.vidrios = vidrios;
        this.transmision = transmision;
    }
    
    
    
}
