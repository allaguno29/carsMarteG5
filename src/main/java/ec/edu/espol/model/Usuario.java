/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espol.model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Ariana Llaguno
 */
public class Usuario implements Serializable{
    protected int id;
    protected String nombres;
    protected String apellidos;
    protected String organizacion;
    protected String correo_electronico;
    protected String clave;
    protected String nomfile;
    private static final long serialVersionUID = 8799656478674716638L;
  

    public Usuario(int id, String nombres, String apellidos, String organizacion,
            String correo_electronico, String clave) {
        this.id = id;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.organizacion = organizacion;
        this.correo_electronico = correo_electronico;
        this.clave = clave;
        
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
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

    public String getCorreo_electronico() {
        return correo_electronico;
    }

    public void setCorreo_electronico(String correo_electronico) {
        this.correo_electronico = correo_electronico;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }
    
    public void setNomfile(String nomfile) {
        this.nomfile = nomfile;
    }
    
    
    public static void guardarUsuarios(ArrayList<Usuario> usuarios, String nomfile){
        try(FileOutputStream file = new FileOutputStream(nomfile);
                ObjectOutputStream out = new ObjectOutputStream(file)){
            out.writeObject(usuarios);
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
    
    public static ArrayList<Usuario> leerUsuarios(String nomfile){
        try(FileInputStream file = new FileInputStream(nomfile);
                ObjectInputStream in = new ObjectInputStream(file)){
            ArrayList<Usuario> usuarios =  (ArrayList<Usuario>)in.readObject();
            return usuarios;
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
        return new ArrayList<>();
    }
        
}
