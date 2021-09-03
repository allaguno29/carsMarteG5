/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espol.model;
import ec.edu.espol.util.Rol;
import ec.edu.espol.util.Util;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
/**
 *
 * @author Josue Vera + Andres Porras
 */
public class Persona implements Serializable{
    protected String nombres;
    protected String apellidos;
    protected String correo;
    protected String organizacion;
    protected String clave;
    
    protected Rol rol;

    
    private static final long serialVersionUID = -5892814637268092625L;
    
    public Persona(String nombres, String apellidos, String correo, String organizacion, String clave, Rol rol) {
        this.nombres = nombres;
        this.apellidos = apellidos;
        
        if(Util.correoEsValido(correo))
        {
            this.correo = correo;
        }
        else
        {
            throw new CorreoException("Correo Invalido -> Ejemplo Valido: correo@servidor.com");
        }
        this.organizacion = organizacion;        
        this.clave = Util.convertirSHA256(clave);
        this.rol = rol;
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

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) 
    {
        if(Util.correoEsValido(correo))
        {
            this.correo = correo;
        }
        else
        {
            throw new CorreoException("Correo Invalido -> Ejemplo Valido: correo@servidor.com");
        }
    }

    public String getOrganizacion() {
        return organizacion;
    }

    public void setOrganizacion(String organizacion) {
        this.organizacion = organizacion;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) 
    {
        this.clave = (clave);
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }
    public static void removerPersona(String filename, Persona per)
    {
        ArrayList<Persona> personas = new ArrayList<>();
        personas = Util.readPersonasFile(filename);
        
        ArrayList<Persona> nuevasPer = new ArrayList<>();
        
        for(Persona p: personas)
        {
            if(p.getCorreo().equals(per.getCorreo()))
            {
               //No se agrega a la lista
            }
            else
            {
                nuevasPer.add(p);
            }
        }

        
        
        try(ObjectOutputStream outStream = new ObjectOutputStream(new FileOutputStream(filename)))
        {    
            outStream.writeObject(nuevasPer);
            outStream.close();
        }
        catch(FileNotFoundException fnfe)
        {
            fnfe.printStackTrace();
        }
        catch(IOException ioe)
        {
            ioe.printStackTrace();
            //ioe.printStackTrace();
        }
    }
   
}
