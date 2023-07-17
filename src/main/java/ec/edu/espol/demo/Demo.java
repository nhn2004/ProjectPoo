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

          Vendedor v1 = new Vendedor(1,"Nahin","Cevallos","Espol","nhncevallo@gmail.com","nhn/2004");
          v1.registrarNuevoVehiculo();

          Comprador c1 = new Comprador(1,"Kenneth","Echeverria","Espol","kjecheve@espol.edu.ec","kenne");
          c1.ofertaPorVehiculo("Auto", 45000, 49000, 2008, 2011, 10000, 16000);

          v1.aceptarOferta();

    }
}
