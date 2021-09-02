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
    @FXML
    private Button btnVendedor;
    @FXML
    private Button btnComprador;
    @FXML
    private VBox Vcenter;
    @FXML
    private ImageView btnImage;
    private Button bt1;
    private Button bt2;
    private Button bt3;
    private Button bt4;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) 
    {  
        this.personas = Util.readPersonasFile("usuarios.ser");
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
    
    public void setCorreoUser(String correo)
    {
        this.correoUser = correo;
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

        Button bt1 = new Button("Registrar un nuevo vendedor");
        Button bt2 = new Button("Ingresar un nuevo vehículo");
        Button bt3 = new Button("Aceptar oferta");
        Button bt4 = new Button("Regresar");
        Vcenter.getChildren().clear();
        Vcenter.getChildren().add(bt1);
        Vcenter.getChildren().add(bt2);
        Vcenter.getChildren().add(bt3);
        Vcenter.getChildren().add(bt4);
    
    }
    
    private void mostrarComprador() {
    
            Button bt1 = new Button("Registrar un nuevo comprador");
            Button bt2 = new Button("Ofertar por un vehículo");
            Button bt3 = new Button("Regresar");
            Vcenter.getChildren().clear();
            Vcenter.getChildren().add(bt1);
            Vcenter.getChildren().add(bt2);
            Vcenter.getChildren().add(bt3);
  
                
    }
    
    private void mostrarAmbos()
    {
        Button bt1 = new Button("Registrar un nuevo vendedor");
        Button bt2 = new Button("Ingresar un nuevo vehículo");
        Button bt3 = new Button("Aceptar oferta");
        
        Vcenter.getChildren().clear();
        Vcenter.getChildren().add(bt1);
        Vcenter.getChildren().add(bt2);
        Vcenter.getChildren().add(bt3);
        
        Button btt1 = new Button("Registrar un nuevo comprador");
        Button btt2 = new Button("Ofertar por un vehículo");
        Button btt3 = new Button("Regresar");
        
        Vcenter.getChildren().add(btt1);
        Vcenter.getChildren().add(btt2);
        Vcenter.getChildren().add(btt3);
    }
}


   