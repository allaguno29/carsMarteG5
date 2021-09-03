
package ec.edu.espol.model;

import ec.edu.espol.util.Util;
import static ec.edu.espol.util.Util.mostrarWarning;
import java.io.File;
import java.io.Serializable;
import java.util.Scanner;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
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
    
  
}
