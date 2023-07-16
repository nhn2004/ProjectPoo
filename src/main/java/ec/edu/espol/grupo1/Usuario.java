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
    
    @Override
    public void saveFile(String nombreArchivo){
        try(PrintWriter pw= new PrintWriter(new FileOutputStream(new File(nombreArchivo),true))){
            pw.println(toString());  
        } 
        catch(Exception e){
          System.out.println(e.getMessage());
        }
    }
    
    

/*
    public static ArrayList<Usuario> readFile(String nombreArchivo){
        ArrayList<Usuario> users= new ArrayList<>();
        try(Scanner sc= new Scanner(new File(nombreArchivo))){
          while(sc.hasNextLine()){
            String linea= sc.nextLine();
            String[] el=linea.split("\\|");
            if (el.length == 7 && nombreArchivo.equals("compradores.txt")){
                Usuario comprador= new Comprador(Integer.parseInt(el[0]),el[1],el[2],el[3],el[4],el[5],el[6]);    
                users.add(comprador);
            }
            else if (el.length == 6 && nombreArchivo.equals("vendedores.txt")){
                Usuario vendedor = new Vendedor(Integer.parseInt(el[0]),el[1],el[2],el[3],el[4],el[5]);
                users.add(vendedor);
            }
          }
        }
        catch(Exception e){
          System.out.println(e.getMessage());
        }
        return users;
    }//no seguro si funciona, esta aqui porsi

    
    public static String buscarClave(String nombreArchivo,String correoElectronico){
        ArrayList<Usuario> users = Usuario.readFile(nombreArchivo);
        String clave= "";
        for (Usuario user: users){
            if (user instanceof Comprador){
                Comprador c = (Comprador) user;
                if (c.getCorreoElectronico().equals(correoElectronico))
                    clave=c.getClave();
            }
            else if (user instanceof Vendedor){
                Vendedor v = (Vendedor) user;
                if (v.getCorreoElectronico().equals(correoElectronico))
                    clave=v.getClave();
            }
        }
    return clave;
    }//tampoco seguro si funciona, ahi esta porsi
*/
    public void registroNuevo(String nomArchivo){
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese su rol: ");
        String tipoUsuario = sc.nextLine();
        System.out.println("Ingrese nombres: ");
        String n= sc.nextLine();
        System.out.println("Ingrese apellidos: ");
        String a= sc.nextLine();
        System.out.println("Ingrese organización: ");
        String o= sc.nextLine();
        System.out.println("Ingrese correo electrónico: ");
        String cE= sc.nextLine();
        System.out.println("Ingrese clave: ");
        String clav= sc.nextLine();
        int i= Utilitaria.nextId(nomArchivo);
        if (tipoUsuario.toLowerCase().equals("vendedor")){
               Vendedor v= new Vendedor(i,n,a,o,cE,clav);
               v.saveFile(nomArchivo);
        }
        else if(tipoUsuario.toLowerCase().equals("comprador")){
            System.out.println("Ingrese un correo");
            String co = sc.nextLine();
            Comprador c = new Comprador(i, n, a, o, cE, clav, co);
            c.saveFile(nomArchivo);
        }
    }
    
    
    
}
