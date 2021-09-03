/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espol.model;

import ec.edu.espol.util.Util;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;
import javafx.collections.FXCollections;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javax.mail.MessagingException;

/**
 *
 * @author Josue Vera + Andres Porras
 */
public class Oferta implements Serializable,Comparable<Oferta>
{
    protected String correo;
    protected double precio;
    private String placa;
    
    private static final long serialVersionUID = -12345L;

  public Oferta(String correo, double precio, String placa){
      this.correo=  correo;
      this.precio= precio;
      this.placa= placa;
  }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }
  
   public void saveFile(String filename) 
   {
       
        ArrayList<Oferta> ofertas = new ArrayList<>();
        ofertas = Util.readOfertasFile(filename);
        
        try(ObjectOutputStream outStream = new ObjectOutputStream(new FileOutputStream(filename)))
        {
            ofertas.add(this);    
            outStream.writeObject(ofertas);
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
   
    public static void removerOferta(String filename, Oferta oferta) 
    {
        ArrayList<Oferta> ofertas = new ArrayList<>();
        ofertas = Util.readOfertasFile(filename);
        
        ArrayList<Oferta> ofertasMod = new ArrayList<>();
        
        for(Oferta o : ofertas)
        {
            if(o.getCorreo().equals(oferta.getCorreo()) && o.getPlaca().equals(oferta.getPlaca()))
            {
               
            }
            else
            {
                ofertasMod.add(o);
            }
        }

        
        
        try(ObjectOutputStream outStream = new ObjectOutputStream(new FileOutputStream(filename)))
        {    
            outStream.writeObject(ofertasMod);
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
    public static void realizarOferta(ScrollPane sp, String user){
        ArrayList <String> tipos = new ArrayList<> ();
        tipos.add("Todos");
        tipos.add("Moto");
        tipos.add("Auto");
        tipos.add("Camioneta");
        double wrappingW = 100;
        VBox vbox = new VBox();
        sp.setContent(vbox);
        vbox.setAlignment(Pos.CENTER);
        Button buscar = new Button("Buscar");
        
        HBox hbox1 = new HBox();
        Text tipot= new Text("Tipo de vehículo:");
        ComboBox tipo = new ComboBox();
        tipo.setItems(FXCollections.observableArrayList(tipos));
        hbox1.getChildren().add(tipot);
        hbox1.getChildren().add(tipo);
        tipot.setWrappingWidth(wrappingW);
        
        HBox hbox2 = new HBox();
        Text recorridot= new Text("Recorrido:   ");
        recorridot.setTextAlignment(TextAlignment.RIGHT);
        TextField recorrido = new TextField();
        hbox2.getChildren().add(recorridot);
        hbox2.getChildren().add(recorrido);
        recorridot.setWrappingWidth(wrappingW);

        HBox hbox3 = new HBox();
        Text añot= new Text("Año:   ");    
        añot.setTextAlignment(TextAlignment.RIGHT);
        TextField año = new TextField();
        hbox3.getChildren().add(añot);
        hbox3.getChildren().add(año);
        añot.setWrappingWidth(wrappingW);
        
        HBox hbox4 = new HBox();
        Text preciot= new Text("Precio:   ");
        preciot.setTextAlignment(TextAlignment.RIGHT);
        TextField precio = new TextField();
        hbox4.getChildren().add(preciot);
        hbox4.getChildren().add(precio);
        preciot.setWrappingWidth(wrappingW);
        
        vbox.getChildren().add(hbox1);
        vbox.getChildren().add(hbox2);
        vbox.getChildren().add(hbox3);
        vbox.getChildren().add(hbox4);
        vbox.getChildren().add(buscar);
        
        buscar.setOnMouseClicked((MouseEvent evento)->{
            try{
                double recorridop= Double.parseDouble(recorrido.getText());
                int añop= Integer.parseInt(año.getText());
                double preciop= Double.parseDouble(precio.getText());
            ArrayList<Vehiculo> vehiculos = new ArrayList <>();
            String item = (String)tipo.getValue();
            if (item.equals("Todos"))
                vehiculos=Util.readVehiclesFile("vehiculos.ser");
            if(item.equals("Moto"))
                vehiculos= Util.readVehiclesFile("motos.ser");
            if(item.equals("Auto"))
                vehiculos= Util.readVehiclesFile("autos.ser");
            if(item.equals("Camioneta"))
                vehiculos= Util.readVehiclesFile("camionetas.ser");
            for(Vehiculo v:vehiculos){
                double x= recorridop - v.getRecorrido();
                double y = añop - v.getAño();
                double z = preciop - v.getPrecio();
                double distancia = Math.sqrt(Math.pow(x, 2)+Math.pow(y, 2)+Math.pow(z, 2));
                v.setPrioridad(distancia);
            }
            vehiculos.sort((Vehiculo v1, Vehiculo v2)->Double.compare(v1.getPrioridad(),v2.getPrioridad()));
                
            ///////////////////////////////////////////////////////////////////////////////
            vbox.getChildren().clear();
            for(Vehiculo v:vehiculos){
                HBox hbox = new HBox();
                Image foto= new Image("img/"+v.getPlaca()+".jpg");
                ImageView im= new ImageView(foto);
                Text precios= new Text("$"+v.getPrecio());
                Text años= new Text(""+v.getAño());
                Text recorridos= new Text(v.getRecorrido()+"km");
                Button boton= new Button();
                boton.setText("Ofertar");
                boton.setOnMouseClicked((MouseEvent event)->{
                    vbox.getChildren().clear();
                    vbox.setAlignment(Pos.CENTER);
                    Button botono = new Button("Ofertar");
                    vbox.getChildren().add(im);
                    Text placav= new Text("placa: "+v.getPlaca());
                    Text marcav= new Text("Marca: "+v.getMarca());
                    Text combustiblev= new Text("Combustible: "+v.getCombustible());
                    Text colorv= new Text("Color: "+v.getColor());
                    Text modelov= new Text("Modelo: "+v.getModelo());
                    Text motorv= new Text("Motor :"+v.getMotor());
                    Text preciov= new Text("Precio: $"+v.getPrecio());
                    Text añov= new Text("Año: "+v.getAño());
                    Text recorridov= new Text("Recorrido: "+v.getRecorrido()+"km");   
                    HBox hboxn= new HBox();
                    Text precioOfertadot= new Text("Precio a ofertar:  ");
                    TextField precioOfertado = new TextField();
                    hboxn.getChildren().add(precioOfertadot);
                    hboxn.getChildren().add(precioOfertado);
                    vbox.getChildren().add(placav);
                    vbox.getChildren().add(marcav);
                    vbox.getChildren().add(combustiblev);
                    vbox.getChildren().add(colorv);
                    vbox.getChildren().add(modelov);
                    vbox.getChildren().add(motorv);
                    vbox.getChildren().add(preciov);
                    vbox.getChildren().add(añov);
                    vbox.getChildren().add(recorridov);
                    vbox.getChildren().add(hboxn);
                    vbox.getChildren().add(botono);
                    botono.setOnMouseClicked((MouseEvent ofertar)->{
                        try{
                            double precioOferta = Double.parseDouble(precioOfertado.getText()) ; 
                            Oferta oferta = new Oferta(user,precioOferta,v.getPlaca());
                            oferta.saveFile("ofertas.ser");
                             Alert a = new Alert(Alert.AlertType.INFORMATION,"Registro de oferta exitoso");
                            a.show();
                            vbox.getChildren().clear();
                            }catch(NumberFormatException e){
                                 Util.mostrarWarning("ERROR AL LLENAR CAMPOS", "Año solo permite numeros enteros y recorrido y precio solo permite decimales.");} 
                    });
                });
                hbox.getChildren().add(im);
                hbox.getChildren().add(precios);
                hbox.getChildren().add(años);
                hbox.getChildren().add(recorridos);
                hbox.getChildren().add(boton);
                vbox.getChildren().add(hbox);
        }
                }catch(NumberFormatException e){
                Util.mostrarWarning("ERROR AL LLENAR CAMPOS", "Año solo permite numeros enteros y recorrido y precio solo permite decimales.");
            }
        });
        
        
        
    }
    
    @Override
    public String toString()
    {
        String res = String.format("Placa: %s%nCorreo: %s%nPrecio Ofertado: %.2f", this.getPlaca(),
                this.getCorreo(), this.getPrecio());
        return res;
    }

    @Override
    public int compareTo(Oferta arg0) {
        Double p1= this.precio;
        Double p2= arg0.getPrecio();
       return p2.compareTo(p1);
    }
}
