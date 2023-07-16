/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espol.grupo1;

import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 *
 * @author HP
 */
public class Usuario implements Saveable {
    private int id;
    private String nombre;
    private String apellidos;
    private String organizacion;
    private String correoElectronico;
    private String clave;

    public Usuario(int id, String nombre, String apellidos, String organizacion, String correoElectronico, String clave) {
        this.id = id;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.organizacion = organizacion;
        this.correoElectronico = correoElectronico;
        this.clave = clave;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getOrganizacion() {
        return organizacion;
    }

    public void setOrganizacion(String organizacion) {
        this.organizacion = organizacion;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }
    
    @Override
    public String toString(){
        return this.id+"|"+this.nombre+"|"+this.apellidos+"|"+this.organizacion+"|"+this.correoElectronico+"|"+this.clave;
    }
    
    @Override
    public void saveFile(String nombreArchivo){
        try(PrintWriter pw= new PrintWriter(new FileOutputStream(new File(nombreArchivo),true))){
            pw.println(toString());  
        } 
        catch(Exception e){
          System.out.println(e.getMessage());
        }
    }
    
    public void registroNuevo(String nomArchivo){
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese su rol: ");
        String tipoUsuario = sc.nextLine();
        System.out.println("Ingrese nombres: ");
        String nom= sc.nextLine();
        System.out.println("Ingrese apellidos: ");
        String apellido= sc.nextLine();
        System.out.println("Ingrese organización: ");
        String org= sc.nextLine();
        System.out.println("Ingrese correo electrónico: ");
        String cE= sc.nextLine();
        System.out.println("Ingrese clave: ");
        String key= sc.nextLine();
        int i= Utilitaria.nextId(nomArchivo);
        if (tipoUsuario.toLowerCase().equals("vendedor")){
               Vendedor v= new Vendedor(i,nom,apellido,org,cE,key);
               v.saveFile(nomArchivo);
        }
        else if(tipoUsuario.toLowerCase().equals("comprador")){
            
            Comprador c = new Comprador(i, nom, apellido, org, cE, key);
            c.saveFile(nomArchivo);
        }
    }
    
    
    
}
