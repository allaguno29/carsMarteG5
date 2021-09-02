/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espol.controller;

import ec.edu.espol.model.Persona;
import ec.edu.espol.util.Util;
import ec.edu.espol.vendedorcarrosg5.App;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
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
    
    //ArrayList<Persona> usuarios;
    
    private String personasFile = "usuarios.ser";

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
    public void initialize(URL url, ResourceBundle rb) 
    {
       

        //usuarios = Util.readPersonasFile(personasFile);
       //System.out.println(usuarios);
    }    

    @FXML
    private void cambioUsuario(MouseEvent event) throws IOException 
    {
        
        String correoObtenido = correo.getText();
        String claveObtenida = pass.getText();
        
        if(Util.credencialEsValida(personasFile, correoObtenido, claveObtenida))
        {

            //System.out.println(correoObtenido);
            //System.out.println(correo.getText());
            //FXMLLoader fxmlpagina = App.loadFXMPagina("PaginaPrincipal");
            //PaginaPrincipalController pg = fxmlpagina.getController();;   
            
            
            FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("PaginaPrincipal.fxml"));
            Parent root = fxmlLoader.load();
            App.setAnyRoot(root);
            PaginaPrincipalController pg = fxmlLoader.<PaginaPrincipalController>getController();
            
            pg.setCorreoUser(correoObtenido);
            pg.mostrarBotones();
            
        }
 
    }

    @FXML
    private void CambioRegistro(MouseEvent event) throws IOException {
        FXMLLoader fxmlregister = App.loadFXMRegister("Registro");
        App.setRootRegister(fxmlregister);
        RegistroController rc = fxmlregister.getController();
        
    }
}
        
               