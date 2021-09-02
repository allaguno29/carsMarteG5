
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
 * @author Ariana Llaguno
 */
public class Autos extends Vehiculo implements Serializable
{
    protected String vidrios;
    protected String transmision;
    private static final long serialVersionUID = -12345L;


    public Autos(String vidrios, String placa, String marca, String modelo, String motor, int año, double recorrido, String color, String combustible, double precio, String transmision) {
        super(placa, marca, modelo, motor, año, recorrido, color, combustible, precio);
        this.vidrios = vidrios;
        this.transmision=  transmision;
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
    
    //FUNCION LISTA - NO REVISADA FULL
    public static void registrarAuto(ScrollPane sp){
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
        Text colort= new Text("Color dle vehiculo:");
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
        hbox12.getChildren().add(placat);
        hbox12.getChildren().add(placa);
        vbox.getChildren().add(hbox1);
        vbox.getChildren().add(hbox2);
        vbox.getChildren().add(hbox3);
        vbox.getChildren().add(hbox4);
        vbox.getChildren().add(hbox5);
        vbox.getChildren().add(hbox6);
        vbox.getChildren().add(hbox7);
        vbox.getChildren().add(hbox8);
        vbox.getChildren().add(hbox9);
        vbox.getChildren().add(hbox10);
        vbox.getChildren().add(hbox12);
        if(!marca.getText().isEmpty() && !modelo.getText().isEmpty() &&
           !motor.getText().isEmpty() && !año.getText().isEmpty() &&
           !kilometraje.getText().isEmpty()&&!combustible.getText().isEmpty()&&
           !color.getText().isEmpty() && !precio.getText().isEmpty() && !vidrios.getText().isEmpty()&&
           !transmision.getText().isEmpty()  && !placa.getText().isEmpty()){
            try{
                int añov= Integer.parseInt(año.getText());
                double recorridov= Double.parseDouble(kilometraje.getText());
                double preciov=Double.parseDouble(precio.getText());
                Autos auto= new Autos(vidrios.getText(),placa.getText(),marca.getText(),modelo.getText(),motor.getText(),añov,recorridov,color.getText(),
                                            combustible.getText(),preciov,transmision.getText());
                auto.saveFile("vehiculos.ser");
                auto.saveFile("camionetas.ser");
            }catch(NumberFormatException e){
                Util.mostrarWarning("ERROR AL LLENAR CAMPOS", "Año solo permite numeros enteros y kilotraje y precio solo permite decimales.");
            }
        }else{
            Util.mostrarLlenar();
        }
    }
}
