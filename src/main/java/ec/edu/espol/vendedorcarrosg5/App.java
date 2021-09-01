package ec.edu.espol.vendedorcarrosg5;

import ec.edu.espol.model.Persona;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/**
 * JavaFX App
 */
public class App extends Application {
    
    private static ArrayList<Persona> usuarios;
    private String css = getClass().getResource("style.css").toExternalForm(); 
    
    /* Estas funciones ya estan en el paquete Util
    
    public static void serializar(String ruta) {
        ObjectOutputStream escritor = null;
        try {
            escritor = new ObjectOutputStream(new FileOutputStream(ruta));
            escritor.writeObject(usuarios);
            escritor.close();
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

    public static ArrayList<Persona> deserializar(String ruta) {
        ObjectInputStream lector = null;
        try {
            lector = new ObjectInputStream(new FileInputStream(ruta));
            ArrayList<Persona> usuarios = (ArrayList<Persona>) lector.readObject();
            lector.close();
            return usuarios;
        } catch (Exception ex) {
            System.out.println("DEVUELVE NUEVO");
            return new ArrayList<Persona>();
        }
    }
        
    public static void agregarEstudiante(Persona e) {
        usuarios.add(e);
    }
    
*/


    private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {
        scene = new Scene(loadFXML("Login"));
        scene.getStylesheets().add(css);
        stage.setScene(scene);
        stage.show();
    }
    
    public static void agregarUsuario(Persona u) {
        usuarios.add(u);
    }

    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }
    
    public static void setRootLogin(FXMLLoader fxmllogin) throws IOException {
        scene.setRoot(fxmllogin.load());
    }
    
    public static void setRootRegister(FXMLLoader fxmlregister) throws IOException {
        scene.setRoot(fxmlregister.load());
    }
    
    public static void setRootPagina(FXMLLoader fxmlpagina) throws IOException {
        scene.setRoot(fxmlpagina.load());
    }

    public static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }
    
    public static FXMLLoader loadFXMLogin(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader;
    }

    
    public static FXMLLoader loadFXMRegister(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader;
    }
    
    public static FXMLLoader loadFXMPagina(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader;
    }

    public static void main(String[] args) {
        launch();
        
    }

}