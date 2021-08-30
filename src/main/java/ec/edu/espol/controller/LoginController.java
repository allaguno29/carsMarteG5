/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espol.controller;

import ec.edu.espol.model.Persona;
import ec.edu.espol.vendedorcarrosg5.App;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author Ariana Llaguno
 */
public class LoginController implements Initializable {
    
    ArrayList<Persona> usuarios;

    @FXML
    private Button btnIni;
    @FXML
    private Button btnReg;
    @FXML
    private PasswordField pass;
    @FXML
    private TextField correo;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void cambioUsuario(MouseEvent event) throws IOException {
        FXMLLoader fxmlpagina = App.loadFXMRegister("PaginaPrincipal");
        App.setRoot(fxmlpagina);
        RegistroController pg = fxmlpagina.getController();
        String core = correo.getText();
        
        for(Persona u: usuarios){
            if(!u.getCorreo().equals(correo)){
                Alert a = new Alert(AlertType.ERROR,"Usted no esta registrado");
                a.show();
            } 
    }
    }

    @FXML
    private void CambioRegistro(MouseEvent event) throws IOException {
        FXMLLoader fxmlregister = App.loadFXMRegister("Registro");
        App.setRoot(fxmlregister);
        RegistroController rc = fxmlregister.getController();
        
    }
}
        
               