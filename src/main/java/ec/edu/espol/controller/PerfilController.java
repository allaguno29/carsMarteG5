/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espol.controller;

import ec.edu.espol.vendedorcarrosg5.App;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author Ariana Llaguno
 */
public class PerfilController implements Initializable {

    @FXML
    private Label lblNom;
    @FXML
    private Label lblApe;
    @FXML
    private Label lblOrg;
    @FXML
    private Label lblCor;
    @FXML
    private Label lblRol;
    private Label lblCla;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    public void setLabels(String nombre, String apellido, String organizacion, String correo,String clav, String rol){
        lblNom.setText(nombre);
        lblApe.setText(apellido);
        lblOrg.setText(organizacion);
        lblCor.setText(correo);
        lblCla.setText(clav);
        lblRol.setText(rol);
        
        
    
    }

   /* FXMLLoader fxmlperfil = App.loadFXMRegister("Perfil");
            App.setRootP(fxmlperfil);
            PerfilController pc = fxmlperfil.getController();
            pc.setLabels(nombre, apellido, organizacion, correo, cla,"Vendedor");*/
            
    @FXML
    private void regresarLogin(MouseEvent event) throws IOException {
        FXMLLoader fxmllogin = App.loadFXMPagina("Login");
        App.setRoot(fxmllogin);
        RegistroController rc = fxmllogin.getController();
    
    }
    
}
