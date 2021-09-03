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
    //protected transient Image foto;
    
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
/*
    public Image getFoto() {
        return foto;
    }

    public void setFoto(Image foto) {
        this.foto = foto;
    }
  
    public static Vehiculo registrarVehiculoGenerico(VBox vbox)
    {
        vbox.setAlignment(Pos.CENTER);
        
        
        Button registrar = new Button("Registrar");
        HBox hbox1 = new HBox();
        Text marcat= new Text("Marca:");
        
        TextField marca = new TextField();
        hbox1.getChildren().add(marcat);
        hbox1.getChildren().add(marca);
        
        
        HBox hbox2 = new HBox();
        Text modelot= new Text("Modelo:");
        TextField modelo = new TextField();
        hbox2.getChildren().add(modelot);
        hbox2.getChildren().add(modelo);
        
        
        HBox hbox3 = new HBox();
        Text motort= new Text("Tipo de motor:");
        TextField motor = new TextField();
        
        
        hbox3.getChildren().add(motort);
        hbox3.getChildren().add(motor);
        HBox hbox4 = new HBox();
        Text añot= new Text("Año del vehiculo:");
        TextField año = new TextField();
        
        
        hbox4.getChildren().add(añot);
        hbox4.getChildren().add(año);
        HBox hbox5 = new HBox();
        Text kilometrajet= new Text("kilometraje:");
        TextField kilometraje = new TextField();
        hbox5.getChildren().add(kilometrajet);
        hbox5.getChildren().add(kilometraje);
        
        
        HBox hbox6 = new HBox();
        Text combustiblet= new Text("Tipo de combustible:");
        TextField combustible = new TextField();
        hbox6.getChildren().add(combustiblet);
        hbox6.getChildren().add(combustible);
        
        
        HBox hbox7 = new HBox();
        Text colort= new Text("Color del vehiculo:");
        TextField color = new TextField();
        hbox7.getChildren().add(colort);
        hbox7.getChildren().add(color);
        
        
        HBox hbox8 = new HBox();
        Text preciot= new Text("Precio:");
        TextField precio = new TextField();
        hbox8.getChildren().add(preciot);
        hbox8.getChildren().add(precio);
        
        
        HBox hbox9 = new HBox();
        Text vidriost= new Text("Tipo de vidrios:");
        TextField  vidrios= new TextField();
        hbox9.getChildren().add(vidriost);
        hbox9.getChildren().add(vidrios);
        
        
        HBox hbox10 = new HBox();
        Text transmisiont= new Text("Transmision:");
        TextField  transmision= new TextField();
        hbox10.getChildren().add(transmisiont);
        hbox10.getChildren().add(transmision);
        
        
        HBox hbox12 = new HBox();
        Text placat= new Text("Placa:");
        TextField  placa= new TextField();
        
        
        
        HBox hbox13 = new HBox(); //
        Button selecBtn = new Button("Subir Foto");
    
        TextField tf = new TextField();
        tf.setEditable(false);
        Vehiculo container = new Vehiculo("placa", "String marca", "String modelo", "String" , 0, 0, "color", "comb", 0);
        
        selecBtn.setOnMouseClicked(evento -> { 
            FileChooser fileChooser = new FileChooser();
            fileChooser.setTitle("Buscar Imagen");

            // Agregar filtros para facilitar la busqueda
            fileChooser.getExtensionFilters().addAll(
                    new FileChooser.ExtensionFilter("All Images", "*.*"),
                    new FileChooser.ExtensionFilter("JPG", "*.jpg"),
                    new FileChooser.ExtensionFilter("PNG", "*.png")
            );
            
            //hbox.getChildren().add(imagen);
            // Obtener la imagen seleccionada
            Window owner = Stage.getWindows().stream().filter(Window::isShowing).findFirst().orElse(null);
            File imgFile = fileChooser.showOpenDialog(owner);
            
            
            // Mostar la imagen
            if (imgFile != null) {
                Image img = new Image("file:" + imgFile.getAbsolutePath());
                tf.setText(img.getUrl());
                //container.setFoto(img);
                
            }
            else
            {
                mostrarWarning("Error", "Foto no encontrada");
            }
        });
       
        
        hbox13.getChildren().add(selecBtn);
        hbox13.getChildren().add(tf);
        
        hbox12.getChildren().add(placat);
        hbox12.getChildren().add(placa);
        
        
        vbox.getChildren().add(hbox13);
        vbox.getChildren().add(hbox12);
        vbox.getChildren().add(hbox1);
        vbox.getChildren().add(hbox2);
        vbox.getChildren().add(hbox3);
        vbox.getChildren().add(hbox4);
        vbox.getChildren().add(hbox5);
        vbox.getChildren().add(hbox6);
        vbox.getChildren().add(hbox7);
        vbox.getChildren().add(hbox8);
        //vbox.getChildren().add(hbox9);
        //vbox.getChildren().add(hbox10);
        
        if(!marca.getText().isEmpty() && !modelo.getText().isEmpty() &&
           !motor.getText().isEmpty() && !año.getText().isEmpty() &&
           !kilometraje.getText().isEmpty()&&!combustible.getText().isEmpty()&&
           !color.getText().isEmpty() && !precio.getText().isEmpty() && !placa.getText().isEmpty() && !tf.getText().equals(""))
        {

            try
                {
                    int añov= Integer.parseInt(año.getText());
                    double recorridov= Double.parseDouble(kilometraje.getText());
                    double preciov=Double.parseDouble(precio.getText());


                    Vehiculo v = new Vehiculo(placa.getText(), marca.getText(), modelo.getText(), motor.getText(), 
                            añov, recorridov, color.getText(), combustible.getText(), preciov);
                    return v;
                }
                catch(NumberFormatException e)
                {
                    //Util.mostrarWarning("ERROR AL LLENAR CAMPOS", "Año solo permite numeros enteros y kilometraje y precio solo permite decimales.");
                    throw new NumberFormatException("Año solo permite numeros enteros y kilometraje y precio solo permite decimales.");
                }
                catch(RuntimeException e)
                {
                    //Util.mostrarWarning("ERROR", e.getMessage());
                    throw new RuntimeException(e);
                    
                }

        }
        return null;
        vbox.getChildren().add(registrar);
        
        registrar.setOnMouseClicked((MouseEvent evento)->{
        if(!marca.getText().isEmpty() && !modelo.getText().isEmpty() &&
           !motor.getText().isEmpty() && !año.getText().isEmpty() &&
           !kilometraje.getText().isEmpty()&&!combustible.getText().isEmpty()&&
           !color.getText().isEmpty() && !precio.getText().isEmpty() /*&& !vidrios.getText().isEmpty()&&
           !transmision.getText().isEmpty() && !placa.getText().isEmpty() && !tf.getText().equals(""))
        {
            try
            {
                int añov= Integer.parseInt(año.getText());
                double recorridov= Double.parseDouble(kilometraje.getText());
                double preciov=Double.parseDouble(precio.getText());
                Autos auto= new Autos(vidrios.getText(),placa.getText(),marca.getText(), 
                        modelo.getText(),motor.getText(),añov,recorridov,color.getText(),
                                combustible.getText(), preciov, transmision.getText());
                
                

                auto.setFoto(container.getFoto());
                auto.saveFile("vehiculos.ser");
                auto.saveFile("autos.ser");
                Vehiculo v = new Vehiculo(placa.getText(), marca.getText(), modelo.getText(), motor.getText(), 
                        añov, recorridov, color.getText(), combustible.getText(), preciov);
                return v;
            }
            catch(NumberFormatException e)
            {
                Util.mostrarWarning("ERROR AL LLENAR CAMPOS", "Año solo permite numeros enteros y kilotraje y precio solo permite decimales.");
                return null;
            }
            catch(Exception e)
            {
                 Util.mostrarWarning("ERROR", e.getMessage());
                 return null;
            }
        }
        else
        {
            return null;
    
        }
        });
        return null;}*/
    
    
    public static Vehiculo lanzarVehiculo(Vehiculo v)
    {
        return v;
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
            fnfe.printStackTrace();
        }
        catch(IOException ioe)
        {
            //ioe.printStackTrace();
        }
    }
    
    
     
    
    
}
