/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package ec.edu.espol.demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author Dom
 */
public class Demo {

    public static void main(String[] args) {
        

        //for (int i=0;i<2;i++){

 
        //}
       // for (int i=0;i<2;i++){
           // Comprador.registroNuevo("Comprador.txt");
      //  }
        

//        for (int i=0;i<2;i++){
//            Vendedor.registroNuevo("Vendedor.txt");
//        }
//        for (int i=0;i<2;i++){
//            Comprador.registroNuevo("Comprador.txt");
//        }
//        Vendedor.registroNuevo("Vendedor.txt");
//        Vendedor v1 = new Vendedor(1,"Nahin","Cevallos","Espol","nhncevallos@gmail.com","nhn/2004");
//        for (int i=0;i<3;i++){
////            Comprador.registroNuevo("Comprador.txt");
////        }
//        
//            v1.registrarNuevoVehiculo();
//        }
//          Vendedor.registroNuevo("Vendedor.txt");
          Vendedor v1 = new Vendedor(1,"Nahin","Cevallos","Espol","nhncevallos@gmail.com","nhn/2004");
          v1.registrarNuevoVehiculo();
          
////          ArrayList<Vehiculo> vehiculos = Vehiculo.readFile("Vehiculos.txt");
//          System.out.println(vehiculos.get(0));
          Comprador c1 = new Comprador(1,"Kenneth","Echeverria","Espol","kjecheve@espol.edu.ec","kenne");
          c1.ofertaPorVehiculo("Auto", 45000, 49000, 2008, 2011, 10000, 16000);
          v1.aceptarOferta();

    }
}
