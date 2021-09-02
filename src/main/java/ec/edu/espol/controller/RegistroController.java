/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espol.controller;

import ec.edu.espol.model.Comprador;
import ec.edu.espol.model.CorreoException;
import ec.edu.espol.model.Persona;
import ec.edu.espol.model.Vendedor;
import ec.edu.espol.util.Rol;
import ec.edu.espol.util.Util;
import ec.edu.espol.vendedorcarrosg5.App;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author Ariana Llaguno
 */
public class RegistroController implements Initializable {
   
    ArrayList<Persona> usuarios;
    Rol rol;
    
    private String personasFile = "usuarios.ser";
    @FXML
    private Button btnGuar;
    @FXML
    private TextField nomb;
    @FXML
    private TextField apell;
    @FXML
    private TextField Org;
    @FXML
    private TextField corrElect;
    @FXML 
    private PasswordField clave;
    @FXML
    private CheckBox chckV;
    @FXML
    private CheckBox chckC;
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
        //Descomentar para ver en consola todos los usuarios ya registrados;
        //System.out.println(Util.readPersonasFile(personasFile));
    }    

    @FXML
    private void Perfil(MouseEvent event) throws IOException {
        
        String nombre = nomb.getText();
        String apellido = apell.getText();
        String organizacion = Org.getText();
        String correo = corrElect.getText();   
        String cla = clave.getText();
        
        if(!nomb.getText().isEmpty() && !apell.getText().isEmpty() &&
                !Org.getText().isEmpty() && !corrElect.getText().isEmpty() &&
                !clave.getText().isEmpty())
        {  
            if (chckV.isSelected() && !chckC.isSelected()) 
            {

               //Solo si el registro fue exitoso la funcion devuelve true y se cambia al login
                if(Vendedor.RegistrarVendedor(nombre, apellido, organizacion, correo, cla, Rol.VENDEDOR))
                {
                    FXMLLoader fxmllogin = App.loadFXMLogin("Login");
                    App.setRootLogin(fxmllogin);
                    LoginController lc = fxmllogin.getController();   
                }
                
            }

            if (chckC.isSelected() && !chckV.isSelected()) 
            {
                //Solo si el registro fue exitoso la funcion devuelve true y se cambia al login
                if(Comprador.registrarComprador(nombre, apellido, organizacion, correo, cla))
                {
                    FXMLLoader fxmllogin = App.loadFXMLogin("Login");
                    App.setRootLogin(fxmllogin);
                    LoginController lc = fxmllogin.getController();   
                }

            }

            if (chckV.isSelected() && chckC.isSelected()) 
            {

                
                //Solo si el registro fue exitoso la funcion devuelve true y se cambia al login
                if(Vendedor.RegistrarVendedor(nombre, apellido, organizacion, correo, cla, Rol.AMBOS))
                {
                    FXMLLoader fxmllogin = App.loadFXMLogin("Login");
                    App.setRootLogin(fxmllogin);
                    LoginController lc = fxmllogin.getController();    
                }
                         
            }
        }
        else if (!chckV.isSelected() && !chckC.isSelected()) 
        {
            System.out.println("Rol vacio");
            Util.mostrarRolNoEleg();
        }
        else
        {    
            Util.mostrarLlenar();
        }
        
        
        
    }
   
   
    

    
}
