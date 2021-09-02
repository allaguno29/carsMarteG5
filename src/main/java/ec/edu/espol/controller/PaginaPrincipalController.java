/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espol.controller;

import ec.edu.espol.model.Autos;
import ec.edu.espol.model.Camioneta;
import ec.edu.espol.model.Comprador;
import ec.edu.espol.model.Motos;
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
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
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
    @FXML
    private ScrollPane scrollpane; // Ajustar el tamañano para que se vea bien en pantalla completa ARIANA!!!!!
    

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
    private void botonRegistrarVendedor(MouseEvent event) 
    {
        //////////////////////////////////////
        
        VBox vbox= new VBox();
        vbox.setAlignment(Pos.CENTER);
        scrollpane.setContent(vbox);
        vbox.setPadding(new Insets(45, 0, 0, 45));
        
        
        ////////////////////////////////////////
        
        HBox hbox1 = new HBox();
        hbox1.setSpacing(60);
        Text nombret = new Text("Nombres:");
        TextField nombretf = new TextField();
        hbox1.getChildren().add(nombret);
        hbox1.getChildren().add(nombretf);
        
        HBox hbox2 = new HBox();
        hbox2.setSpacing(60);
        Text apellidot= new Text("Apellidos:");
        TextField apellidotf = new TextField();
        hbox2.getChildren().add(apellidot);
        hbox2.getChildren().add(apellidotf);
        
        HBox hbox3 = new HBox();
        hbox3.setSpacing(60);
        Text correot = new Text("Correo:");
        TextField correotf = new TextField();
        hbox3.getChildren().add(correot);
        hbox3.getChildren().add(correotf);
        
        HBox hbox4 = new HBox();
        
        hbox4.setSpacing(60);
        Text orgt= new Text("Organización:");
        TextField orgtf = new TextField();
        hbox4.getChildren().add(orgt);
        hbox4.getChildren().add(orgtf);
        
        HBox hbox5 = new HBox();
        hbox5.setSpacing(60);
        Text clavet = new Text("Clave:");
        PasswordField clavetf = new PasswordField();
        hbox5.getChildren().add(clavet);
        hbox5.getChildren().add(clavetf);     
        
        HBox hbox6 = new HBox();
        
        hbox6.setSpacing(60);
        CheckBox checkV = new CheckBox("Vendedor");
        CheckBox checkC = new CheckBox("Comprador");
        hbox6.getChildren().add(checkV);
        hbox6.getChildren().add(checkC);
        Button btnRegister = new Button("Registrar");
          
        
        //////////////////////////////////////////////////
        
        vbox.getChildren().clear();
        vbox.getChildren().add(hbox1);
        vbox.getChildren().add(hbox2);
        vbox.getChildren().add(hbox3);
        vbox.getChildren().add(hbox4);
        vbox.getChildren().add(hbox5);
        vbox.getChildren().add(hbox6);
        
        ///////////////////////////////////////////////////
        
        String nombre = nombretf.getText();
        String apellido = apellidotf.getText();
        String organizacion = orgtf.getText();
        String correo = correotf.getText();   
        String cla = clavetf.getText();
        
        ///////////////////////////////////////////////////
        btnRegister.setOnMouseClicked((MouseEvent evento)-> 
        {
            if(!nombretf.getText().isEmpty() && !apellidotf.getText().isEmpty() &&
                !correotf.getText().isEmpty() && !orgtf.getText().isEmpty() &&
                !clavetf.getText().isEmpty())
            {  
                if (checkV.isSelected() && !checkC.isSelected()) 
                {

                   //Solo si el registro fue exitoso la funcion devuelve true y se cambia al login
                    if(Vendedor.RegistrarVendedor(nombre, apellido, organizacion, correo, cla, Rol.VENDEDOR))
                    {
                        Alert a = new Alert(AlertType.INFORMATION, "¡Registro exitoso!"); 
                        a.show();
                    }

                }

                if (checkC.isSelected() && !checkV.isSelected()) 
                {
                    //Solo si el registro fue exitoso la funcion devuelve true y se cambia al login
                    if(Comprador.registrarComprador(nombre, apellido, organizacion, correo, cla))
                    {
                        Alert a = new Alert(AlertType.INFORMATION, "¡Registro exitoso!"); 
                        a.show();  
                    }

                }

                if (checkV.isSelected() && checkC.isSelected()) 
                {


                    //Solo si el registro fue exitoso la funcion devuelve true y se cambia al login
                    if(Vendedor.RegistrarVendedor(nombre, apellido, organizacion, correo, cla, Rol.AMBOS))
                    {
                        Alert a = new Alert(AlertType.INFORMATION, "¡Registro exitoso!"); 
                        a.show();   
                    }

                }
            }
            else if (!checkV.isSelected() && !checkC.isSelected()) 
            {
                //System.out.println("Rol vacio");
                Util.mostrarRolNoEleg();
            }
            else
            {    
                Util.mostrarLlenar();
            }    
        });
        vbox.getChildren().add(btnRegister);
        
        
    }

    @FXML
    private void botonIngresarVehiculo(MouseEvent event) {
        scrollpane.setContent(null);
        HBox hbox= new HBox();
        hbox.setAlignment(Pos.CENTER);
        scrollpane.setPadding(new Insets(80));
        scrollpane.setContent(hbox);
        Button auto= new Button("Auto");
        Button camioneta= new Button("Camioneta");
        Button moto= new Button("Moto");
        hbox.getChildren().add(auto);
        hbox.getChildren().add(camioneta);
        hbox.getChildren().add(moto);
        hbox.setPadding(new Insets(20));
        hbox.setSpacing(20);
        auto.setOnMouseClicked((MouseEvent evento)->{
            Autos.registrarAuto(scrollpane);
        });
        camioneta.setOnMouseClicked((MouseEvent evento)->{
            Camioneta.registrarCamioneta(scrollpane);
        });
        moto.setOnMouseClicked((MouseEvent evento)->{
            Motos.registrarMoto(scrollpane);
        });
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


   