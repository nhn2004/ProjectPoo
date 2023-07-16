/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package ec.edu.espol.demo;

/**
 *
 * @author Dom
 */
public class Demo {

    public static void main(String[] args) {
        
        for (int i=0;i<2;i++){
            Vendedor.registroNuevo("Vendedor.txt");
        }
        for (int i=0;i<2;i++){
            Comprador.registroNuevo("Comprador.txt");
        }
        
    }
}
