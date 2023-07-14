/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espol.grupo1;

/**
 *
 * @author HP
 */
public class Oferta {
 private double precio;
 private Vehiculo vehiculo;
 private Comprador comprador;

 public Oferta(){

 }
 public Oferta(double p,Vehiculo v,Comprador c){
   precio=p;
   vehiculo=v;
   comprador=c;
 }
}
