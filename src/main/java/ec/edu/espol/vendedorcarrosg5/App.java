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
public class App extends Application 
{
    
    private static ArrayList<Persona> usuarios;
    private String css = getClass().getResource("style.css").toExternalForm(); 
    
    


    private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {
        scene = new Scene(loadFXML("Login"));
        scene.getStylesheets().add(css);
        stage.setHeight(600);
        stage.setWidth(750);
        stage.setScene(scene);
        stage.show();
    }
    
    
    public static void agregarUsuario(Persona u) 
    {
        usuarios.add(u);
    }

    public static void setAnyRoot(Parent root) throws IOException 
    {
        scene.setRoot(root);
    }
    
    public static void setRootLogin(FXMLLoader fxmllogin) throws IOException 
    {
        scene.setRoot(fxmllogin.load());
    }
    
    public static void setRootRegister(FXMLLoader fxmlregister) throws IOException 
    {
        scene.setRoot(fxmlregister.load());
    }
    
    public static void setRootPagina(FXMLLoader fxmlpagina) throws IOException 
    {
        scene.setRoot(fxmlpagina.load());
    }

    public static Parent loadFXML(String fxml) throws IOException 
    {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }
    
    public static FXMLLoader loadFXMLogin(String fxml) throws IOException 
    {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader;
    }

    
    public static FXMLLoader loadFXMRegister(String fxml) throws IOException 
    {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader;
    }
    
    public static FXMLLoader loadFXMPagina(String fxml) throws IOException 
    {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader;
    }

    public static void main(String[] args) 
    {
        launch();
        
    }

}