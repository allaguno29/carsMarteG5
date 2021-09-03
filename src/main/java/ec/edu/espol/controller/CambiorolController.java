/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espol.controller;

import ec.edu.espol.model.*;
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
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.Window;

/**
 * FXML Controller class
 *
 * @author ANDRES PORRAS
 */
public class CambiorolController implements Initializable {

    private ArrayList<Persona> personas;
    private String correo;
    private Persona p;
    @FXML
    private CheckBox compch;
    @FXML
    private CheckBox vendch;
    @FXML
    private Button aceptar;
    @FXML
    private Button cancelbtn;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) 
    {

    }    

    @FXML
    private void aceptarCambio(MouseEvent event) 
    {
       

                if(compch.isSelected() && !vendch.isSelected())
                {
                    if(!p.getRol().equals(Rol.COMPRADOR))
                    {
                        Comprador newc = new Comprador(p.getNombres(),p.getApellidos(),p.getCorreo(),p.getOrganizacion(),"clave");
                        newc.setClave(p.getClave());
                        Persona.removerPersona("usuarios.ser", p);
                        newc.saveFile("usuarios.ser");
                    }
                }
                else if(!compch.isSelected() && vendch.isSelected())
                {
                    if(!p.getRol().equals(Rol.VENDEDOR))
                    {
                        Vendedor newc = new Vendedor(p.getNombres(),p.getApellidos(),p.getCorreo(),p.getOrganizacion(),"clave", Rol.VENDEDOR);
                        newc.setClave(p.getClave());
                        Persona.removerPersona("usuarios.ser", p);
                        newc.saveFile("usuarios.ser");
                    }
                }
                else if(compch.isSelected() && vendch.isSelected())
                {
                    if(!p.getRol().equals(Rol.AMBOS))
                    {
                        Vendedor newc = new Vendedor(p.getNombres(),p.getApellidos(),p.getCorreo(),p.getOrganizacion(),"clave", Rol.AMBOS);
                        newc.setClave(p.getClave());
                        Persona.removerPersona("usuarios.ser", p);
                        newc.saveFile("usuarios.ser");
                    }
                }
                else
                {
                    Util.mostrarRolNoEleg();
                }
                Alert al = new Alert(AlertType.INFORMATION, "Por favor, cierre y vuelva a iniciar sesión para aplicarlos.");
                al.setTitle("");
                al.setHeaderText("Éxito");
                al.show();
                
                Window owner =compch.getScene().getWindow();
                owner.hide();

        
    }


    @FXML
    private void cancelar(MouseEvent event) 
    {
        Window owner = compch.getScene().getWindow();
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
