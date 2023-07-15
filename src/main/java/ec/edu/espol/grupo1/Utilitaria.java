/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espol.grupo1;

import java.util.ArrayList;

/**
 *
 * @author Dom
 */
class Utilitaria {
    
    public static ArrayList<Vehiculo> filtrarVehiculos(ArrayList<Vehiculo> vehiculos,String tipovehiculo, double recorridoInicio, double recorridoFin, 
            int añoInicio, int añoFin, double precioInicio, double precioFin){
        
    ArrayList<Vehiculo> listaRetorno = new ArrayList<>();
    
    if (precioFin == 0)
      precioFin = 1000000000000.0;
    if (recorridoFin == 0)
      recorridoFin = 1000000000000.0;
    if (añoFin == 0)
      añoFin = 100000000;
    //if (tipovehiculo.equals(null))
      //tipovehiculo = no se que ponerle aqui para el switch se cumpla en los tres casos y agregue todo
      //ya que se consideran todos los tipos vehículos
    
     for (Vehiculo v:vehiculos){
      switch (tipovehiculo){
        case "camioneta" -> {
            if(v instanceof Camioneta){
                if(v.getRecorrido() <= recorridoFin &&
                        v.getRecorrido() >= recorridoInicio &&
                        v.getAño()<= añoFin && v.getAño()>= añoInicio &&
                        v.getPrecio()<= precioFin && v.getPrecio()>= precioInicio)
                    listaRetorno.add(v);}
        }
        case "auto" -> {
            if(v instanceof Auto){
                if(v.getRecorrido()<= recorridoFin &&
                        v.getRecorrido()>= recorridoInicio &&
                        v.getAño()<= añoFin &&
                        v.getAño()>= añoInicio &&
                        v.getPrecio()<= precioFin &&
                        v.getPrecio()>= precioInicio)
                    listaRetorno.add(v);} 
        }
        case "moto" -> {
            if(v instanceof Vehiculo){
                if(v.getRecorrido()<= recorridoFin &&
                        v.getRecorrido()>= recorridoInicio &&
                        v.getAño()<= añoFin &&
                        v.getAño()>= añoInicio &&
                        v.getPrecio()<= precioFin &&
                        v.getPrecio()>= precioInicio)
                    listaRetorno.add(v);} 
        }
       } 
     }
    return listaRetorno;
    }
    
    public static Vehiculo filtrarPorPlaca(ArrayList<Vehiculo> vehiculos, String placa){
        Vehiculo v = new Vehiculo();
        return v;
    }
}
