
package ec.edu.espol.model;

import ec.edu.espol.util.Util;
import static ec.edu.espol.util.Util.mostrarWarning;
import java.io.File;
import java.io.Serializable;
import java.util.Scanner;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.Window;


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
    /*public static Button registrarAuto(VBox vbox, Vehiculo container,TextField placa, TextField marca, TextField modelo, 
            TextField motor, TextField año, TextField kilometraje, TextField combustible, 
            TextField color, TextField vidrios, TextField transmision, TextField tf, //tf es el textfield con la foto
            TextField precio)
    {
        Button registrar = new Button("Registrar");
        
        registrar.setOnMouseClicked((MouseEvent evento)->{
        if(!marca.getText().isEmpty() && !modelo.getText().isEmpty() &&
           !motor.getText().isEmpty() && !año.getText().isEmpty() &&
           !kilometraje.getText().isEmpty()&&!combustible.getText().isEmpty()&&
           !color.getText().isEmpty() && !precio.getText().isEmpty() && !vidrios.getText().isEmpty()&&
           !transmision.getText().isEmpty()  && !placa.getText().isEmpty() && !tf.getText().equals(""))
        {
            try
            {
                int añov= Integer.parseInt(año.getText());
                double recorridov= Double.parseDouble(kilometraje.getText());
                double preciov=Double.parseDouble(precio.getText());
                Autos auto= new Autos(vidrios.getText(),placa.getText(),marca.getText(), 
                        modelo.getText(),motor.getText(),añov,recorridov,color.getText(),
                                combustible.getText(), preciov, transmision.getText());
                
                

                //auto.setFoto(container.getFoto());
                auto.saveFile("vehiculos.ser");
                auto.saveFile("autos.ser");
            }
            catch(NumberFormatException e)
            {
                Util.mostrarWarning("ERROR AL LLENAR CAMPOS", "Año solo permite numeros enteros y kilotraje y precio solo permite decimales.");
            }
            catch(Exception e)
            {
                 Util.mostrarWarning("ERROR", e.getMessage());
            }
        }
        else
        {
            Util.mostrarLlenar();
        }
        });
        
        return registrar;
        
    }*/
}
