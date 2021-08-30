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

    private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {
        scene = new Scene(loadFXML("Login"));
        stage.setScene(scene);
        stage.show();
    }
    
    public static void agregarUsuario(Persona u) {
        usuarios.add(u);
    }

    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }
    
    public static void setRootPa(FXMLLoader fxmllogin) throws IOException {
        scene.setRoot(fxmllogin.load());
    }
    
    public static void setRoot(FXMLLoader fxmlregister) throws IOException {
        scene.setRoot(fxmlregister.load());
    }
    
    public static void setRootP(FXMLLoader fxmlperfil) throws IOException {
        scene.setRoot(fxmlperfil.load());
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }
    
    public static FXMLLoader loadFXMRegister(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader;
    }
    
    public static FXMLLoader loadFXMPerfil(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader;
    }
    
    public static FXMLLoader loadFXMPagina(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader;
    }

    public static void main(String[] args) {
        launch();
        //ArrayList<Usuario> usuarios = new ArrayList<>();
        //usuarios.add(new Usuario(01,"Ariana Naomi", "Llaguno Mora","Brahma","arianallagunomora@gmail.com","sadsASASDS283"));
        //usuarios.add(new Usuario(02,"Karin Helen", "Macias Garzon","CocaCola","karinmacias26@gmail.com","sfgdgd45"));
        //usuarios.add(new Usuario(03,"Domenica Anahi", "Rendon Cisneros","Pepsi","domerendon12@gmail.com","afsdfdsd23"));
        //usuarios.add(new Usuario(04,"Karen Luciana", "Vaca Tacuri","Hyundai","luciatacuri10@gmail.com","dsda34"));
        //usuarios.add(new Usuario(05,"Anabelle Carola", "Mora Vaca","Ford","anamora08@gmail.com","fgfgjgjg32"));
        //Usuario.guardarUsuarios(usuarios, "usuarios.ser");
    //ArrayList<Usuario> usuarios = Usuario.leerUsuarios("usuarios.ser");
    //System.out.println(usuarios);
    }

}