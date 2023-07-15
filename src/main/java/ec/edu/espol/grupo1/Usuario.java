/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espol.grupo1;

import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
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
 
    public void saveFile(String nombreArchivo){
        try(PrintWriter pw= new PrintWriter(new FileOutputStream(new File(nombreArchivo),true))){
            pw.println(this.toString());  
        } 
        catch(Exception e){
          System.out.println(e.getMessage());
        }
    }
    
    public static ArrayList<Object> readFile(String nombreArchivo){
        ArrayList<Usuario>  users= new ArrayList<>();
        ArrayList<Comprador> compradores = new ArrayList<>();
        try(Scanner sc= new Scanner(new File(nombreArchivo))){
          while(sc.hasNextLine()){
            String linea= sc.nextLine();
            String[] el=linea.split("\\|");//el: elementos------ si el usuario es vendedor tendrá estos parametros, si es comprador tendrá uno mas que es correo
            //por lo que se podria ver el tamaño del split
            if(el.length==6){
                Usuario user= new Usuario(Integer.parseInt(el[0]),el[1],el[2],el[3],el[4],el[5]);
                users.add(user);
            }
            else if(el.length==7){
                Comprador c = new Comprador(Integer.parseInt(el[0]),el[1],el[2],el[3],el[4],el[5],el[6]);//el orden de los parametros no me queda del todo claro
                compradores.add(c);
            }
          }
        }
        catch(Exception e){
          System.out.println(e.getMessage());
        }
        return users,compradores;
    }
    
    public static String buscarClave(String nombreArchivo,String correoElectronico){
        ArrayList<Usuario> listaUsuarios= Usuario.readFile(nombreArchivo);
        String clave= "";
        for (Usuario user:listaUsuarios){
            if (user.correoElectronico.equals(correoElectronico))
                clave=user.clave;
        }
    return clave;
    }
}
