/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espol.model;

import ec.edu.espol.util.Util;
import static ec.edu.espol.util.Util.mostrarWarning;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.Window;

/**
 *
 * @author Axel
 */
public class Vehiculo implements Serializable{
    protected String placa;
    protected String marca;
    protected String modelo;
    protected String motor;
    protected int año;
    protected double recorrido;
    protected String color;
    protected String combustible;
    protected double precio;
    protected transient double prioridad; 
    private static final long serialVersionUID = -12345L;
    
    public Vehiculo(String placa, String marca, String modelo, String motor, int año, double recorrido, String color, String combustible, double precio) {
        this.placa = placa;
        this.marca = marca;
        this.modelo = modelo;
        this.motor = motor;
        this.año = año;
        this.recorrido = recorrido;
        this.color = color;
        this.combustible = combustible;
        this.precio = precio;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getMotor() {
        return motor;
    }

    public void setMotor(String motor) {
        this.motor = motor;
    }

    public int getAño() {
        return año;
    }

    public void setAño(int año) {
        this.año = año;
    }

    public double getRecorrido() {
        return recorrido;
    }

    public void setRecorrido(double recorrido) {
        this.recorrido = recorrido;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getCombustible() {
        return combustible;
    }

    public void setCombustible(String combustible) {
        this.combustible = combustible;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
    public double getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(double prioridad) {
        this.prioridad = prioridad;  
    }  
    
    public static void removerVehiculo(String placa) throws IOException
    {
        String filename = "autos.ser";
        ArrayList<Vehiculo> vehs = Util.readVehiclesFile(filename);
        
        ArrayList<Vehiculo> vehsMod = new ArrayList<>();
        
        for(Vehiculo o : vehs)
        {
            if(o.getPlaca().equals(placa))
            {
               
            }
            else
            {
                vehsMod.add(o);
            }
        }

        
        
        try(ObjectOutputStream outStream = new ObjectOutputStream(new FileOutputStream(filename)))
        {    
            outStream.writeObject(vehsMod);
            outStream.close();
        }
        catch(FileNotFoundException fnfe)
        {
            File f = new File(filename);
            f.createNewFile();
            System.out.println("Se ha creado el archivo");
            //fnfe.printStackTrace();
        }
        catch(IOException ioe)
        {
            //ioe.printStackTrace();
        }
        filename = "camionetas.ser";
        vehs = Util.readVehiclesFile(filename);
        
        vehsMod = new ArrayList<>();
        
        for(Vehiculo o : vehs)
        {
            if(o.getPlaca().equals(placa))
            {
               
            }
            else
            {
                vehsMod.add(o);
            }
        }

        
        
        try(ObjectOutputStream outStream = new ObjectOutputStream(new FileOutputStream(filename)))
        {    
            outStream.writeObject(vehsMod);
            outStream.close();
        }
        catch(FileNotFoundException fnfe)
        {
            File f = new File(filename);
            f.createNewFile();
            System.out.println("Se ha creado el archivo");
            //fnfe.printStackTrace();
        }
        catch(IOException ioe)
        {
            //ioe.printStackTrace();
        }
        
        filename = "motos.ser";
        vehs = Util.readVehiclesFile(filename);
        
        vehsMod = new ArrayList<>();
        
        for(Vehiculo o : vehs)
        {
            if(o.getPlaca().equals(placa))
            {
               
            }
            else
            {
                vehsMod.add(o);
            }
        }

        
        
        try(ObjectOutputStream outStream = new ObjectOutputStream(new FileOutputStream(filename)))
        {    
            outStream.writeObject(vehsMod);
            outStream.close();
        }
        catch(FileNotFoundException fnfe)
        {
            File f = new File(filename);
            f.createNewFile();
            System.out.println("Se ha creado el archivo");
            //fnfe.printStackTrace();
        }
        catch(IOException ioe)
        {
            //ioe.printStackTrace();
        }
        filename = "vehiculos.ser";
        vehs = Util.readVehiclesFile(filename);
        
        vehsMod = new ArrayList<>();
        
        for(Vehiculo o : vehs)
        {
            if(o.getPlaca().equals(placa))
            {
               
            }
            else
            {
                vehsMod.add(o);
            }
        }

        
        
        try(ObjectOutputStream outStream = new ObjectOutputStream(new FileOutputStream(filename)))
        {    
            outStream.writeObject(vehsMod);
            outStream.close();
        }
        catch(FileNotFoundException fnfe)
        {
            File f = new File(filename);
            f.createNewFile();
            System.out.println("Se ha creado el archivo");
            //fnfe.printStackTrace();
        }
        catch(IOException ioe)
        {
            //ioe.printStackTrace();
        }
    
    }

    //FUNCION LISTA - LOGICA PARALELA NO DEBERIA DAR PROBLEMAS
    public void saveFile(String filename)
    {
        
        ArrayList<Vehiculo> vehiculos = new ArrayList<>();
        vehiculos = Util.readVehiclesFile(filename);
        
        try(ObjectOutputStream outStream = new ObjectOutputStream(new FileOutputStream(filename)))
        {
            vehiculos.add(this);    
            outStream.writeObject(vehiculos);
            outStream.close();
        }        
        catch(FileNotFoundException fnfe)
        {
            File f = new File(filename);
            try {
                f.createNewFile();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            System.out.println("Se ha creado el archivo");
            //fnfe.printStackTrace();
        }
        catch(IOException ioe)
        {
            //ioe.printStackTrace();
        }
    }
    
    
     
    
    
}
