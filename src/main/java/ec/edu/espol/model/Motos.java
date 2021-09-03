/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espol.model;

import ec.edu.espol.util.Util;
import java.io.Serializable;
import java.util.Scanner;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;


/**
 *
 * @author Josue Vera
 */
public class Motos extends Vehiculo implements Serializable{

    private static final long serialVersionUID = -12345L;

    public Motos(String placa, String marca, String modelo, String motor, int año, double recorrido, String color, String combustible, double precio) {
        super(placa, marca, modelo, motor, año, recorrido, color, combustible, precio);
    }
    public static void registrarMoto(ScrollPane sp){
        double wrappingW = 150;
        VBox vbox= new VBox();
        vbox.setAlignment(Pos.CENTER);
        sp.setContent(vbox);
        Button registrar = new Button("Registrar");
        HBox hbox1 = new HBox();
        Text marcat= new Text("Marca:");
        TextField marca = new TextField();
        hbox1.getChildren().add(marcat);
        hbox1.getChildren().add(marca);
        marcat.setWrappingWidth(wrappingW);
        
        HBox hbox2 = new HBox();
        Text modelot= new Text("Modelo:");
        TextField modelo = new TextField();
        hbox2.getChildren().add(modelot);
        hbox2.getChildren().add(modelo);
        modelot.setWrappingWidth(wrappingW);
        
        HBox hbox3 = new HBox();
        Text motort= new Text("Tipo de motor:");
        TextField motor = new TextField();
        hbox3.getChildren().add(motort);
        hbox3.getChildren().add(motor);
        motort.setWrappingWidth(wrappingW);
        
        HBox hbox4 = new HBox();
        Text añot= new Text("Año del vehiculo:");
        TextField año = new TextField();
        hbox4.getChildren().add(añot);
        hbox4.getChildren().add(año);
        añot.setWrappingWidth(wrappingW);
        
        HBox hbox5 = new HBox();
        Text kilometrajet= new Text("kilometraje:");
        TextField kilometraje = new TextField();
        hbox5.getChildren().add(kilometrajet);
        hbox5.getChildren().add(kilometraje);
        kilometrajet.setWrappingWidth(wrappingW);
        
        HBox hbox6 = new HBox();
        Text combustiblet= new Text("Tipo de combustible:");
        TextField combustible = new TextField();
        hbox6.getChildren().add(combustiblet);
        hbox6.getChildren().add(combustible);
        combustiblet.setWrappingWidth(wrappingW);
        
        HBox hbox7 = new HBox();
        Text colort= new Text("Color dle vehiculo:");
        TextField color = new TextField();
        hbox7.getChildren().add(colort);
        hbox7.getChildren().add(color);
        colort.setWrappingWidth(wrappingW);
        
        HBox hbox8 = new HBox();
        Text preciot= new Text("Precio:");
        TextField precio = new TextField();
        hbox8.getChildren().add(preciot);
        hbox8.getChildren().add(precio);
        preciot.setWrappingWidth(wrappingW);
        
        HBox hbox12 = new HBox();
        Text placat= new Text("Placa:");
        TextField  placa= new TextField();
        hbox12.getChildren().add(placat);
        hbox12.getChildren().add(placa);
        placat.setWrappingWidth(wrappingW);
        
        vbox.getChildren().add(hbox1);
        vbox.getChildren().add(hbox2);
        vbox.getChildren().add(hbox3);
        vbox.getChildren().add(hbox4);
        vbox.getChildren().add(hbox5);
        vbox.getChildren().add(hbox6);
        vbox.getChildren().add(hbox7);
        vbox.getChildren().add(hbox8);
        vbox.getChildren().add(hbox12);
        vbox.getChildren().add(registrar);
        registrar.setOnMouseClicked((MouseEvent evento)->{
        if(!marca.getText().isEmpty() && !modelo.getText().isEmpty() &&
           !motor.getText().isEmpty() && !año.getText().isEmpty() &&
           !kilometraje.getText().isEmpty()&&!combustible.getText().isEmpty()&&
           !color.getText().isEmpty() && !precio.getText().isEmpty() && !placa.getText().isEmpty()){
            try{
                int añov= Integer.parseInt(año.getText());
                double recorridov= Double.parseDouble(kilometraje.getText());
                double preciov=Double.parseDouble(precio.getText());
                Motos moto= new Motos(placa.getText(),marca.getText(),modelo.getText(),motor.getText(),añov,recorridov,color.getText(),
                                            combustible.getText(),preciov);
                moto.saveFile("vehiculos.ser");
                moto.saveFile("motos.ser");
                Alert a = new Alert(Alert.AlertType.INFORMATION,"Registro del Vehiculo exitoso");
                a.show();
                sp.setContent(null);
            }catch(NumberFormatException e){
                Util.mostrarWarning("ERROR AL LLENAR CAMPOS", "Año solo permite numeros enteros y kilotraje y precio solo permite decimales.");
            }catch(Exception e){
                 Util.mostrarWarning("ERROR", e.getMessage());
            }
        }else{
            Util.mostrarLlenar();}
        });
    }
}
    
  
