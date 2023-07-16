/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espol.grupo1;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Dom
 */
public class Moto extends Vehiculo{
    public Moto(String placa, String modelo, String marca, String tipoMotor, int año, 
            double recorrido, String color, String tipoCosmbustible, double precio, int idVendedor){
        super(placa, modelo, marca, tipoMotor, año, recorrido, color, tipoCosmbustible, precio,idVendedor);
    }
    
    public static ArrayList<Moto> readFile(String nombreArchivo){
        ArrayList<Moto> lM= new ArrayList<>();
        try(Scanner sc= new Scanner(new File(nombreArchivo))){
          while(sc.hasNextLine()){
            String linea= sc.nextLine();
            String[] el=linea.split("\\|");
            Moto moto= new Moto(el[0],el[1],el[2],el[3],Integer.parseInt(el[4]),
                    Double.parseDouble(el[5]),el[6],el[7],
                    Double.parseDouble(el[8]),Integer.parseInt(el[9]));    
            lM.add(moto);
          }
        }
        catch(Exception e){
          System.out.println(e.getMessage());
        }
        return lM;
    }
}
