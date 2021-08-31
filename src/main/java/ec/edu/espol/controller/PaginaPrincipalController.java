/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espol.controller;

import ec.edu.espol.util.Util;
import ec.edu.espol.vendedorcarrosg5.App;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author Ariana Llaguno
 */
public class PaginaPrincipalController implements Initializable 
{

    @FXML
    private Button salirbtn;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) 
    {
        // TODO
    }    

    @FXML
    private void salir(MouseEvent event) 
    {
        FXMLLoader fxmlpagina;
        try {
            fxmlpagina = App.loadFXMRegister("Login"); 
            App.setRoot(fxmlpagina);
            LoginController ppg = fxmlpagina.getController();   
        } catch (IOException ex) {
            Util.mostrarWarning("Error", "No se encuentra el archivo fxml");
        }
       
    }
    
}
