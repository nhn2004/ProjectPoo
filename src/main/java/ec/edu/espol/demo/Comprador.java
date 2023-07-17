/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espol.demo;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author HP
 */
public class Comprador extends Usuario{

  private Oferta oferta;

    public Comprador(int id, String nombre, String apellidos, String organizacion, 
            String correoElectronico, String clave) {
        super(id, nombre, apellidos, organizacion, correoElectronico, clave);
    }
    

     public static void registroNuevo(String nomArchivo){
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Ingrese correo electrónico: ");
        String cE= sc.nextLine();
        System.out.println("Ingrese clave: ");
        String key= sc.nextLine();
        System.out.println("Ingrese nombres: ");
        String nom= sc.nextLine();
        System.out.println("Ingrese apellidos: ");
        String apellido= sc.nextLine();
        System.out.println("Ingrese organización: ");
        String org= sc.nextLine();
        int i= Utilitaria.nextId(nomArchivo);
        if (Comprador.buscarClave(nomArchivo, cE).equals("")){
        Comprador v= new Comprador(i,nom,apellido,org,cE,key);
        v.saveFile(nomArchivo);
         } else{
                System.out.println("Ese correo ya existe no se puede registar");
        } 
        }
    
    public Oferta getOferta() {
        return oferta;
    }

    public void setOferta(Oferta oferta) {
        this.oferta = oferta;
    }

  
  public static ArrayList<Comprador> readFile(String nombreArchivo){
        ArrayList<Comprador> lC= new ArrayList<>();
        try(Scanner sc= new Scanner(new File(nombreArchivo))){
          while(sc.hasNextLine()){
            String linea= sc.nextLine();
            String[] el=linea.split("\\|");
            Comprador comprador= new Comprador(Integer.parseInt(el[0]),el[1],el[2],el[3],el[4],el[5]);    
            lC.add(comprador);
          }
        }
        catch(Exception e){
          System.out.println(e.getMessage());
        }
        return lC;
    }
    
public static String buscarClave(String nombreArchivo,String correoElectronico){
        ArrayList<Comprador> lC= Comprador.readFile(nombreArchivo);
        String clave= "";
        for (Comprador c:lC){
            if (c.getCorreoElectronico().equals(correoElectronico))
                clave=c.getClave();
        }
    return clave;
    }

    public static Comprador searchByID(ArrayList<Comprador> compradores, int id){
        for (Comprador c: compradores){
            if (c.getId() == id)
                return c;
        }
        return null;
    }

  public void ofertaPorVehiculo(String tipovehiculo, 
          float recorridoInicio, float recorridoFin, int añoInicio, int añoFin, float precioInicio, 
          float precioFin){
    ArrayList<Vehiculo> vehiculos = Vehiculo.readFile();
    
    ArrayList<Vehiculo> vehiculosBuscados = Utilitaria.filtrarVehiculos(vehiculos,tipovehiculo, 
            recorridoInicio, recorridoFin, añoInicio, añoFin, precioInicio, precioFin);
      
    Vehiculo vehiculoSeleccionado = Utilitaria.navegar(vehiculosBuscados);
    System.out.println("caca");
    Scanner sc = new Scanner(System.in);
    System.out.println("Ingrese la oferta por el vehiculo elegido: ");
    double monto = sc.nextDouble();
    int idOffer = Utilitaria.nextId("Oferta.txt");
    Utilitaria.registrarOferta(idOffer, monto, vehiculoSeleccionado, this.getId(),vehiculoSeleccionado.getPlaca());
    }
}
