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
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.PasswordField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Window;

/**
 * FXML Controller class
 *
 * @author ANDRES PORRAS
 */
public class CambioclaveController implements Initializable {

    private ArrayList<Persona> personas;
    private String correo;
    private Persona p;
    @FXML
    private Button aceptar;
    @FXML
    private Button cancelbtn;
    @FXML
    private VBox mvbox;
    @FXML
    private PasswordField anteriorpf;
    @FXML
    private PasswordField nuevopf;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void aceptarCambio(MouseEvent event) 
    {
        String claveObtenida = anteriorpf.getText();
        String claveCifrada = Util.convertirSHA256(claveObtenida);
        
        String nuevaClave = Util.convertirSHA256(nuevopf.getText());
        
        if(anteriorpf.getText().equals("") && nuevopf.getText().equals(""))
        {
            Util.mostrarWarning("Error de tipeo", "Debe llenar todos los campos");
        }
        else if(Util.credencialEsValida("usuarios.ser", correo, claveObtenida))
        {
            if(p.getRol().equals(Rol.COMPRADOR))
            {
                Comprador newc = new Comprador(p.getNombres(),p.getApellidos(),p.getCorreo(),p.getOrganizacion(),"clave");
                newc.setClave(nuevaClave);
                
                
                Persona.removerPersona("usuarios.ser", p);
                
                newc.saveFile("usuarios.ser");
            }
            else if(p.getRol().equals(Rol.AMBOS))
            {
                Vendedor newc = new Vendedor(p.getNombres(),p.getApellidos(),p.getCorreo(),p.getOrganizacion(),"clave", Rol.AMBOS);
                newc.setClave(nuevaClave);
                Persona.removerPersona("usuarios.ser", p);
                newc.saveFile("usuarios.ser");
            }
            else if(p.getRol().equals(Rol.VENDEDOR))
            {
                Vendedor newc = new Vendedor(p.getNombres(),p.getApellidos(),p.getCorreo(),p.getOrganizacion(),"clave", Rol.VENDEDOR);
                newc.setClave(nuevaClave);
                Persona.removerPersona("usuarios.ser", p);
                newc.saveFile("usuarios.ser");
            }
            Alert al = new Alert(AlertType.INFORMATION, "Ha cambiado su clave satisfactoriamente.");
            al.setTitle("");
            al.setHeaderText("Éxito");
            al.show();
            Window owner = mvbox.getScene().getWindow();
            owner.hide();
        }
        
    }

    @FXML
    private void cancelar(MouseEvent event) {
        Window owner = mvbox.getScene().getWindow();
        owner.hide();
    }
    public void setCorreoActual(String correo)
    {
        this.correo = correo;
        
        personas = Util.readPersonasFile("usuarios.ser");
        for(Persona p: personas)
        {
            if(p.getCorreo().equals(correo))
            {
                this.p = p;
            }
        }
    }
    
}
