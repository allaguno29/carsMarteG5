/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espol.controller;

import ec.edu.espol.model.Comprador;
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
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

/**
 * FXML Controller class
 *
 * @author Ariana Llaguno
 */
public class PaginaPrincipalController implements Initializable 
{

    private ArrayList<Persona> personas;
    private Persona usuario;
    private String correoUser;
    

    @FXML
    private Button salirbtn;
    private VBox Vcenter;
    @FXML
    private ImageView btnImage;

    @FXML
    private VBox panelBotones;
    @FXML
    private Button venbtn1;
    @FXML
    private Button venbtn2;
    @FXML
    private Button btnComp1;
    @FXML
    private Button btnComp2;
    @FXML
    private Button venbtn3;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) 
    {  
        this.personas = Util.readPersonasFile("usuarios.ser");

        


    }
    
    public void setCorreoUser(String correo)
    {
        correoUser = correo;
        
    }
    
    public void mostrarBotones()
    {
        for (Persona p: personas)
        {
            if(p.getCorreo().equals(correoUser))
            {
                usuario = p;
            }
        }
        
        if(usuario.getRol()==Rol.COMPRADOR)
        {
            this.mostrarComprador();
        }
        
        else if(usuario.getRol()==Rol.VENDEDOR)
        {
            this.mostrarVendedor();
        }
        else
        {
            this.mostrarAmbos();
        }
    }
    
    @FXML
    private void salir(MouseEvent event) 
    {
        FXMLLoader fxmllogin;
        try {
                fxmllogin = App.loadFXMLogin("Login");
                App.setRootLogin(fxmllogin);
                LoginController lc = fxmllogin.getController();    
        } catch (IOException ex) {
            Util.mostrarWarning("Error", "No se encuentra el archivo fxml");
        }
       
    }

    @FXML // Muestra el perfil de cada usuario
    private void mostrarPerfil(MouseEvent event) throws IOException {
        for(Persona p : personas ){ 
            Text nomb = new Text("Nombres");
            Text nombre = new Text(p.getNombres());
            Text ape = new Text("Apellidos");
            Text Apellido = new Text(p.getApellidos());
            Text org = new Text("Organizacion");
            Text Organizacion = new Text(p.getOrganizacion());
            Text cor = new Text("Correo");
            Text Correo = new Text(p.getCorreo());
            Button btCla = new Button("Cambiar Clave");
            Button btRol = new Button("Cambiar Rol");
            Vcenter.getChildren().clear();
            Vcenter.getChildren().add(nomb);
            Vcenter.getChildren().add(nombre);
            Vcenter.getChildren().add(ape);
            Vcenter.getChildren().add(Apellido);
            Vcenter.getChildren().add(org);
            Vcenter.getChildren().add(Organizacion);
            Vcenter.getChildren().add(cor);
            Vcenter.getChildren().add(Correo);
            Vcenter.getChildren().add(btCla);
            Vcenter.getChildren().add(btRol); 


    
    }}

    private void mostrarVendedor() {

        //Button bt4 = new Button("Regresar");
        panelBotones.getChildren().clear();
        
        panelBotones.getChildren().add(btnImage);
        panelBotones.getChildren().add(venbtn1);
        panelBotones.getChildren().add(venbtn2);
        panelBotones.getChildren().add(venbtn3);
        panelBotones.getChildren().add(salirbtn);
    
    }
    
    private void mostrarComprador() 
    {
    

            panelBotones.getChildren().clear();
            panelBotones.getChildren().add(btnImage);
            panelBotones.getChildren().add(btnComp1);
            panelBotones.getChildren().add(btnComp2);
            panelBotones.getChildren().add(salirbtn);
  
                
    }
    
    private void mostrarAmbos()
    {

        panelBotones.getChildren().clear();
        panelBotones.getChildren().add(btnImage);
        panelBotones.getChildren().add(venbtn1);
        panelBotones.getChildren().add(venbtn2);
        panelBotones.getChildren().add(venbtn3);
        panelBotones.getChildren().add(btnComp1);
        panelBotones.getChildren().add(btnComp2);
        
        panelBotones.getChildren().add(salirbtn);
    }

    @FXML
    private void botonRegistrarVendedor(MouseEvent event) {
    }

    @FXML
    private void botonIngresarVehiculo(MouseEvent event) {
    }

    @FXML
    private void botonAceptarOfertas(MouseEvent event) {
    }

    @FXML
    private void botonRegistrarComprador(MouseEvent event) {
    }

    @FXML
    private void botonRealizarOferta(MouseEvent event) {
    }
}


   