/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espol.grupo1;

import java.io.File;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Properties;
import java.util.Scanner;
import javax.mail.*;
import javax.mail.internet.*;

/**
 *
 * @author Dom
 */
class Utilitaria {
    
      public static int nextId(String nombreArchivo){
    int id=0;
    try(Scanner sc= new Scanner(new  File(nombreArchivo))){
      while(sc.hasNextLine()){
        String linea=sc.nextLine();
        String[] elementos=linea.split("\\|");
        id=Integer.parseInt(elementos[0]);
      }
    } catch (Exception e){
    }
    return id+1;
  }
      public static String generarHash (String input) {
        try{
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        byte[] hash= md.digest(input.getBytes(StandardCharsets.UTF_8));
        BigInteger number = new BigInteger(1, hash);
        StringBuilder s = new StringBuilder(number.toString(16));
        while (s.length() < 64){
            s.insert(0, '0');
        }
        return s.toString();
        } catch(Exception e){
            return "//ERROR";
        } 
   }
      public static String buscarClave(String nombreArchivo,String correoElectronico){
            ArrayList<Vendedor> lV= Vendedor.readFile(nombreArchivo);
        String clave= "";
        for (Vendedor v:lV){
            if (v.getCorreoElectronico().equals(correoElectronico)){
                clave=v.getClave();
            }
        }
        return clave;
      }
      
      
      public static boolean validarClave(String clave,String claveIngresada){
          String hash1= Utilitaria.generarHash(clave);
          String hash2= Utilitaria.generarHash(claveIngresada);
          return Objects.equals(hash1,hash2);
      }
            
    public static ArrayList<Vehiculo> filtrarVehiculos(ArrayList<Vehiculo> vehiculos,String tipovehiculo, double recorridoInicio, float recorridoFin, 
            int añoInicio, long añoFin, double precioInicio, float precioFin){
        
        ArrayList<Vehiculo> listaRetorno = new ArrayList<>();
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
    
    public static ArrayList<Vehiculo> filtrarVehiculos(ArrayList<Vehiculo> vehiculos,String tipovehiculo, double recorridoInicio, float recorridoFin, 
        int añoInicio, long añoFin, double precioInicio){
        ArrayList<Vehiculo> vehFiltrados = filtrarVehiculos(vehiculos, tipovehiculo,  recorridoInicio,  recorridoFin, añoInicio,  añoFin,  precioInicio, 1000000000000.0f);
        return vehFiltrados;
    }
    
    public static ArrayList<Vehiculo> filtrarVehiculos(ArrayList<Vehiculo> vehiculos,String tipovehiculo, double recorridoInicio, float recorridoFin, 
            int añoInicio, long añoFin, float precioFin){
        ArrayList<Vehiculo> vehFiltrados = filtrarVehiculos(vehiculos, tipovehiculo,  recorridoInicio,  recorridoFin, añoInicio,  añoFin,  0.0 , precioFin);
        return vehFiltrados;
    }
    
    public static ArrayList<Vehiculo> filtrarVehiculos(ArrayList<Vehiculo> vehiculos,String tipovehiculo, double recorridoInicio, float recorridoFin, 
            int añoInicio, double precioInicio, float precioFin){
        ArrayList<Vehiculo> vehFiltrados = filtrarVehiculos(vehiculos, tipovehiculo,  recorridoInicio,  recorridoFin, añoInicio, 1000000000, precioInicio, precioFin);
        return vehFiltrados;
    }
    
    public static ArrayList<Vehiculo> filtrarVehiculos(ArrayList<Vehiculo> vehiculos,String tipovehiculo, double recorridoInicio, float recorridoFin, 
            long añoFin, double precioInicio, float precioFin){
        ArrayList<Vehiculo> vehFiltrados = filtrarVehiculos(vehiculos, tipovehiculo,  recorridoInicio,  recorridoFin, 0, añoFin, precioInicio, precioFin);
        return vehFiltrados;
    }
    
    public static ArrayList<Vehiculo> filtrarVehiculos(ArrayList<Vehiculo> vehiculos,String tipovehiculo, double recorridoInicio, int añoInicio, long añoFin, 
            double precioInicio, float precioFin){
        ArrayList<Vehiculo> vehFiltrados = filtrarVehiculos(vehiculos, tipovehiculo,  recorridoInicio, 1000000000000.0f , añoInicio, añoFin, precioInicio, precioFin);
        return vehFiltrados;
    }
    
     public static ArrayList<Vehiculo> filtrarVehiculos(ArrayList<Vehiculo> vehiculos,String tipovehiculo, float recorridoFin, int añoInicio, long añoFin, 
             double precioInicio, float precioFin){
        ArrayList<Vehiculo> vehFiltrados = filtrarVehiculos(vehiculos, tipovehiculo,  0.0, recorridoFin , añoInicio, añoFin, precioInicio, precioFin);
        return vehFiltrados;
     }
     
      public static ArrayList<Vehiculo> filtrarVehiculos(ArrayList<Vehiculo> vehiculos, double recorridoInicio, float recorridoFin, 
            int añoInicio, long añoFin, double precioInicio, float precioFin){
        ArrayList<Vehiculo> vehFiltrados = new ArrayList<>();
        ArrayList<Vehiculo> vF1 = filtrarVehiculos(vehiculos, "camioneta" , recorridoInicio, recorridoFin , añoInicio, añoFin, precioInicio, precioFin);
        for (Vehiculo v: vF1)
            vehFiltrados.add(v);
        ArrayList<Vehiculo> vF2 = filtrarVehiculos(vehiculos, "auto" , recorridoInicio, recorridoFin , añoInicio, añoFin, precioInicio, precioFin);
        for (Vehiculo v: vF2)
            vehFiltrados.add(v);
        ArrayList<Vehiculo> vF3 = filtrarVehiculos(vehiculos, "moto" , recorridoInicio, recorridoFin , añoInicio, añoFin, precioInicio, precioFin);
        for (Vehiculo v: vF3)
            vehFiltrados.add(v);
        return vehFiltrados;
      }
    
    public static Vehiculo filtrarPorPlaca(ArrayList<Vehiculo> vehiculos, String placa){
        Vehiculo v = new Vehiculo();
        return v;
    }
    
    public static Vehiculo navegar(ArrayList<Vehiculo> vehiculos){
        int tamaño= vehiculos.size();
        Scanner sc= new Scanner(System.in);
        int seleccion;
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
            
            switch (seleccion) {
                case 1 -> {
                    i++;
                    if (i >= tamaño) {
                        System.out.println("Has revisado todos los vehículos.");
                        i--;
                    }
                }

                case 2 -> {
                    return v;
                }

                case 3 -> {
                    i--;
                    if (i < 0) {
                        System.out.println("Ya estás en el primer vehículo.");
                        i++;
                    }
                }

                default -> System.out.println("Opción inválida. Por favor, selecciona una opción válida.");
            }      

        }while (seleccion != 2);
        return null;
    }
    
    public static ArrayList<Object> listaAtributos(){
        ArrayList<Object> o = new ArrayList<>();
        return o;
    }
    
    
    
    public static void enviarCorreo(String correoDestino, String asunto, String mensaje){
        String correoEnvio = "nhncevallos@gmail.com";
        String contraseña = "olbapqxbumuxutep";

        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.ssl.trust", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");

        Session session = Session.getInstance(props, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(correoEnvio, contraseña);
            }
        });

        try {
            
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(correoEnvio));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(correoDestino));
            message.setSubject(asunto);
            message.setText(mensaje);
            
            Transport.send(message);
            System.out.println("Correo electrónico enviado exitosamente.");
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
}
