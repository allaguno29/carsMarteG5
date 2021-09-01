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
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

/**
 *
 * @author Josue Vera
 */
public class Camioneta extends Vehiculo implements Serializable
{
    protected String vidrios;
    protected String transmision;
    protected String traccion;
    private static final long serialVersionUID = -12345L;

    public Camioneta(String vidrios, String placa, String marca, String modelo, String motor, int año, double recorrido, String color, String combustible, double precio, String transmision, String traccion) {
        super(placa, marca, modelo, motor, año, recorrido, color, combustible, precio);
        this.vidrios= vidrios;
        this.transmision= transmision;
        this.traccion= traccion;

    }

    public String getVidrios() {
        return vidrios;
    }

    public void setVidrios(String vidrios) {
        this.vidrios = vidrios;
    }

    public String getTransmision() {
        return transmision;
    }

    public void setTransmision(String transmision) {
        this.transmision = transmision;
    }

    public String getTraccion() {
        return traccion;
    }

    public void setTraccion(String traccion) {
        this.traccion = traccion;
    }
    
    public static void DatosCamioneta(Scanner sc){
        //sc.nextLine();
        System.out.println("Ingrese la placa del vehiculo: ");
        String placa =sc.nextLine();
        
        while(!Util.placaEsValida("vehiculos.ser",placa))
        {
            System.out.println("Placa ya registrada en el sistema, por favor ingrese otra: ");
            placa = sc.nextLine();
        }
        System.out.println("Ingrese la marca del vehiculo: ");
        String marca= sc.nextLine();
        System.out.println("Ingrese el modelo del vehiculo: ");
        String modelo= sc.nextLine();
        System.out.println("Ingrese el tipo de motor que tiene el vehiculo: ");
        String motor=sc.nextLine();
        System.out.println("Ingrese el año del vehiculo: ");
        int año= sc.nextInt();
        System.out.println("Ingrese el kilometraje del vehiculo: ");
        double recorrido=sc.nextDouble();
        sc.nextLine();
        System.out.println("Ingrese el color del vehiculo: ");
        String color=sc.nextLine();
        System.out.println("Ingrese el tipo de combustible que usa el vehiculo: ");
        String combustible=sc.nextLine();
        System.out.println("Ingrese el precio de su vehiculo: ");
        double precio= sc.nextDouble();
        System.out.println("Ingrese la transmision del vehiculo: ");
        String transmision=sc.nextLine();
        System.out.println("Ingrese que tipos de vidrio tine su vehiculo: ");
        String vidrios= sc.nextLine();
        System.out.println("Ingrese la traccion del vehiculo: ");
        String traccion=sc.nextLine();
        Vehiculo camioneta= new Camioneta(vidrios,placa,marca,modelo,motor,año,recorrido,color,combustible,precio,transmision,traccion);
        camioneta.saveFile("vehiculos.ser"); 
        camioneta.saveFile("camionetas.ser");
    }
    public static void registrarCamioneta(ScrollPane sp){
        VBox vbox= new VBox();
        vbox.setAlignment(Pos.CENTER);
        sp.setContent(vbox);
        HBox hbox1 = new HBox();
        Text marcat= new Text("Marca:");
        TextField marca = new TextField();
        hbox1.getChildren().add(marcat);
        hbox1.getChildren().add(marcat);
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
        Text placat= new Text("Año del vehiculo:");
        TextField año = new TextField();
        hbox4.getChildren().add(placat);
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
        Text colort= new Text("Color dle vehiculo:");
        TextField color = new TextField();
        hbox7.getChildren().add(colort);
        hbox7.getChildren().add(color);
        HBox hbox8 = new HBox();
        Text preciot= new Text("Precio:");
        TextField precio = new TextField();
        vbox.getChildren().add(preciot);
        vbox.getChildren().add(precio);
        vbox.getChildren().add(hbox1);
        vbox.getChildren().add(hbox2);
        vbox.getChildren().add(hbox3);
        vbox.getChildren().add(hbox4);
        vbox.getChildren().add(hbox5);
        vbox.getChildren().add(hbox6);
        vbox.getChildren().add(hbox7);
        vbox.getChildren().add(hbox8);
        double añov= Double.parseDouble(año.getText());
        
    }
}
