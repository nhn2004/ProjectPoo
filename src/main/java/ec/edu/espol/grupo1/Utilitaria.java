/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espol.grupo1;

import java.util.ArrayList;
import java.util.Scanner;

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
    
    public static Vehiculo navegar(ArrayList<Vehiculo> vehiculos){
        int tamaño= vehiculos.size();
        Scanner sc= new Scanner(System.in);
        int seleccion = 0;
        int i=0;
        Vehiculo v;
        do{
            v = vehiculos.get(i);  
            System.out.println(v.toString());
            if (tamaño>0 && i==0){
              System.out.println("1.- Siguiente");
              System.out.println("2.- Seleccionar");
            }
            else if(tamaño>i){
              System.out.println("1.- Siguiente");
              System.out.println("2.- Seleccionar");
              System.out.println("3.- Anterior");
            }
            else{
              System.out.println("2.- Seleccionar");
              System.out.println("3.- Anterior");
            }
            seleccion= sc.nextInt();
            sc.nextInt();
            if (seleccion == 2){
                return v;
              /* Cuando el vendedor acepta la oferta, el vehículo que está a la venta debe eliminarse del sistema y enviarle un correo al comprador del cual se aceptó la oferta confirmándole que se ha aceptado su oferta.*/
            }
            else if (seleccion == 1){
              i++;
            }
            else if(seleccion==3){
              i--;
            }
            switch (seleccion) {
                case 1:
                    i++;
                    if (i >= tamaño) {
                        System.out.println("Has revisado todos los vehículos.");
                        i--;
                    }
                    break;

                case 2:
                    return v;

                case 3:
                    i--;
                    if (i < 0) {
                        System.out.println("Ya estás en el primer vehículo.");
                        i++;
                    }
                    break;

                default:
                    System.out.println("Opción inválida. Por favor, selecciona una opción válida.");
                    break;
            }      

        }while (seleccion != 2);
        return null;
    }
}
