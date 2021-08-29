/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espol.controller;

import ec.edu.espol.model.Comprador;
import ec.edu.espol.model.Persona;
import ec.edu.espol.util.Rol;
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
    }    

    @FXML
    private void Perfil(MouseEvent event) throws IOException {
        
        String nombre = nomb.getText();
        String apellido = apell.getText();
        String organizacion = Org.getText();
        String correo = corrElect.getText();   
        String cla = clave.getText();
        
        //falta guardar en sr
        if(!nomb.getText().isEmpty() ||!apell.getText().isEmpty()||!Org.getText().isEmpty()||!corrElect.getText().isEmpty()||!clave.getText().isEmpty() ){  
        if (chckV.isSelected() && !chckC.isSelected()) {
            
            Persona ingresado = new Persona(nombre, apellido, correo, organizacion, cla, rol);
            RegistradoConfirmado();
            FXMLLoader fxmllogin = App.loadFXMPagina("Login");
            App.setRoot(fxmllogin);
            RegistroController rc = fxmllogin.getController();   
        }
        
        if (chckC.isSelected() && !chckV.isSelected()) {
            
            Persona ingresado = new Persona(nombre, apellido, correo, organizacion, cla, rol);
            RegistradoConfirmado();
            FXMLLoader fxmllogin = App.loadFXMPagina("Login");
            App.setRoot(fxmllogin);
            RegistroController rc = fxmllogin.getController();
            
        }
        
        if (chckV.isSelected() && chckC.isSelected()) {
            
            RegistradoConfirmado();
            Persona ingresado = new Persona(nombre, apellido, correo, organizacion, cla, rol);
            Comprador ingresado1 = new Comprador(nombre, apellido, organizacion, correo, cla);
            FXMLLoader fxmllogin = App.loadFXMPagina("Login");
            App.setRoot(fxmllogin);
            RegistroController rc = fxmllogin.getController();  
        }
        }else{
            
            mostrarLlenar();
        }
        
        if (!chckV.isSelected() && !chckC.isSelected()) {
            mostrarAlertWarning();
        }
        
    }
    private void mostrarAlertWarning() {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setHeaderText(null);
        alert.setTitle("Campo Incompleto");
        alert.setContentText("Por favor seleccione un rol");
        alert.showAndWait();
    }
    
    private void RegistradoConfirmado() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText(null);
        alert.setTitle("Bienvenido nuevo Usuario");
        alert.setContentText("Usted ha sido registrado con exito");
        alert.showAndWait();
    }
    
   private void mostrarLlenar() {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setHeaderText(null);
        alert.setTitle("Campo Incompleto");
        alert.setContentText("Llenar todos los campos");
        alert.showAndWait();
    }
    

    
}
