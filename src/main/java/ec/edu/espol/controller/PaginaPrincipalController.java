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
import ec.edu.espol.model.Oferta;
import ec.edu.espol.model.Persona;
import ec.edu.espol.model.Vehiculo;
import ec.edu.espol.model.Vendedor;
import ec.edu.espol.util.Rol;
import ec.edu.espol.util.Util;
import static ec.edu.espol.util.Util.mostrarWarning;
import ec.edu.espol.vendedorcarrosg5.App;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
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
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.Window;
import javax.mail.MessagingException;

/**
 * FXML Controller class
 *
 * @author Ariana Llaguno
 */
public class PaginaPrincipalController implements Initializable 
{
    private ArrayList<Oferta> ofertas;
    private ArrayList<Persona> personas;
    private Persona usuario;
    private String correoUser;
    private String vehactual;

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
    @FXML
    private VBox vboxexpoveh;
    @FXML
    private HBox plabox;
    @FXML
    private Text plabox_t;
    @FXML
    private TextField plabox_tf;
    @FXML
    private HBox marbox;
    @FXML
    private Text marbox_t;
    @FXML
    private TextField marbox_tf;
    @FXML
    private HBox modbox;
    @FXML
    private Text modbox_t;
    @FXML
    private TextField modbox_tf;
    @FXML
    private HBox tmotorbox;
    @FXML
    private Text tmotor_t;
    @FXML
    private TextField tmotorbox_tf;
    @FXML
    private HBox aniobox;
    @FXML
    private Text aniobox_t;
    @FXML
    private TextField aniobox_tf;
    @FXML
    private HBox recorbox;
    @FXML
    private Text recorbox_t;
    @FXML
    private TextField recorbox_tf;
    @FXML
    private HBox tcombox;
    @FXML
    private Text tcombox_t;
    @FXML
    private TextField tcombox_tf;
    @FXML
    private HBox colbox;
    @FXML
    private Text colbox_t;
    @FXML
    private TextField colbox_tf;
    @FXML
    private HBox vidbox;
    @FXML
    private Text vidbox_t;
    @FXML
    private TextField vidbox_tf;
    @FXML
    private HBox transbox;
    @FXML
    private Text transbox_t;
    @FXML
    private TextField transbox_tf;
    @FXML
    private HBox tracbox;
    @FXML
    private Text tracbox_t;
    @FXML
    private TextField tracbox_tf;
    @FXML
    private HBox prebox;
    @FXML
    private Text prebox_t;
    @FXML
    private TextField prebox_tf;
    @FXML
    private Button regvehbtn;
    @FXML
    private HBox fotobox;
    @FXML
    private Button fotobox_btn;
    @FXML
    private TextField fotobox_tf;
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) 
    {  
        this.personas = Util.readPersonasFile("usuarios.ser");
        this.ofertas=Util.readOfertasFile("ofertas.ser");
        scrollpane.setContent(null);

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
        double wrappingW = 80;
        double spacing = 60;
        VBox vbox= new VBox();
        vbox.setAlignment(Pos.CENTER);
        scrollpane.setContent(vbox);
        vbox.setPadding(new Insets(45, 0, 0, 45));
        
        
        ////////////////////////////////////////
        
        HBox hbox1 = new HBox();
        hbox1.setSpacing(spacing);
        hbox1.setPadding(new Insets(30,0,0,0));
        Text nombret = new Text("Nombres:");
        nombret.setWrappingWidth(wrappingW);
        
        TextField nombretf = new TextField();
        hbox1.getChildren().add(nombret);
        hbox1.getChildren().add(nombretf);
        
        HBox hbox2 = new HBox();
        hbox2.setSpacing(spacing);
        hbox2.setPadding(new Insets(30,0,0,0));
        Text apellidot= new Text("Apellidos:");
        
        apellidot.setWrappingWidth(wrappingW);
        TextField apellidotf = new TextField();
        hbox2.getChildren().add(apellidot);
        hbox2.getChildren().add(apellidotf);
        
        HBox hbox3 = new HBox();
        hbox3.setSpacing(spacing);
        
        hbox3.setPadding(new Insets(30,0,0,0));
        Text correot = new Text("Correo:");
        
        correot.setWrappingWidth(wrappingW);
        TextField correotf = new TextField();
        hbox3.getChildren().add(correot);
        hbox3.getChildren().add(correotf);
        
        HBox hbox4 = new HBox();
        
        hbox4.setSpacing(spacing);
        hbox4.setPadding(new Insets(30,0,0,0));
        Text orgt= new Text("Organización:");
        
        orgt.setWrappingWidth(wrappingW);
        TextField orgtf = new TextField();
        hbox4.getChildren().add(orgt);
        hbox4.getChildren().add(orgtf);
        
        HBox hbox5 = new HBox();
        hbox5.setSpacing(spacing);
        hbox5.setPadding(new Insets(30,0,0,0));
        Text clavet = new Text("Clave:");
        
        clavet.setWrappingWidth(wrappingW);
        PasswordField clavetf = new PasswordField();
        hbox5.getChildren().add(clavet);
        hbox5.getChildren().add(clavetf);     
        
        HBox hbox6 = new HBox();
        
        hbox6.setSpacing(spacing);
        hbox6.setPadding(new Insets(30,0,0,0));
        CheckBox checkV = new CheckBox("Vendedor");
        CheckBox checkC = new CheckBox("Comprador");
        hbox6.getChildren().add(checkV);
        hbox6.getChildren().add(checkC);
        Button btnRegister = new Button("Registrar");
        
        VBox.setMargin(btnRegister,new Insets(30,0,0,0));
        
        //////////////////////////////////////////////////
        
        vbox.getChildren().clear();
        vbox.getChildren().add(hbox1);
        vbox.getChildren().add(hbox2);
        vbox.getChildren().add(hbox3);
        vbox.getChildren().add(hbox4);
        vbox.getChildren().add(hbox5);
        vbox.getChildren().add(hbox6);
        
        ///////////////////////////////////////////////////
        
        
        ///////////////////////////////////////////////////
        btnRegister.setOnMouseClicked((MouseEvent evento)-> 
        {
            String nombre = nombretf.getText();
            String apellido = apellidotf.getText();
            String organizacion = orgtf.getText();
            String correo = correotf.getText();   
            String cla = clavetf.getText();
            System.out.println(correo);
            System.out.println(cla);
            System.out.println(correo);
            
            if(!nombretf.getText().isEmpty() && !apellidotf.getText().isEmpty() &&
                !correotf.getText().isEmpty() && !orgtf.getText().isEmpty() &&
                !clavetf.getText().isEmpty())
            {  
                if (checkV.isSelected() && !checkC.isSelected()) 
                {

                   //Solo si el registro fue exitoso la funcion devuelve true 
                    if(Vendedor.RegistrarVendedor(nombre, apellido, organizacion, correo, cla, Rol.VENDEDOR))
                    {
                        //Alert a = new Alert(AlertType.INFORMATION, "¡Registro exitoso!"); 
                        //a.show();
                    }

                }

                if (checkC.isSelected() && !checkV.isSelected()) 
                {
                    //Solo si el registro fue exitoso la funcion devuelve true 
                    if(Comprador.registrarComprador(nombre, apellido, organizacion, correo, cla))
                    {
                        //Alert a = new Alert(AlertType.INFORMATION, "¡Registro exitoso!"); 
                        //a.show();  
                    }

                }

                if (checkV.isSelected() && checkC.isSelected()) 
                {


                    //Solo si el registro fue exitoso la funcion devuelve true 
                    if(Vendedor.RegistrarVendedor(nombre, apellido, organizacion, correo, cla, Rol.AMBOS))
                    {
                        //Alert a = new Alert(AlertType.INFORMATION, "¡Registro exitoso!"); 
                        //a.show();   
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
    private void botonIngresarVehiculo(MouseEvent event) 
    {
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
        //Vehiculo container = new Vehiculo("","","","",0,0,"","",0);
        fotobox_btn.setOnMouseClicked(evento -> { 
                FileChooser fileChooser = new FileChooser();
                fileChooser.setTitle("Buscar Imagen");

                // Agregar filtros para facilitar la busqueda
                fileChooser.getExtensionFilters().addAll(
                        new FileChooser.ExtensionFilter("All Images", "*.*"),
                        new FileChooser.ExtensionFilter("JPG", "*.jpg"),
                        new FileChooser.ExtensionFilter("PNG", "*.png")
                );

                //hbox.getChildren().add(imagen);
                // Obtener la imagen seleccionada
                Window owner = Stage.getWindows().stream().filter(Window::isShowing).findFirst().orElse(null);
                File imgFile = fileChooser.showOpenDialog(owner);
                

                // Mostar la imagen
                if (imgFile != null) {
                    Image img = new Image("file:" + imgFile.getAbsolutePath());
                    String imgpath = img.getUrl().substring(5,img.getUrl().length());
                    fotobox_tf.setText(imgpath);
                    copyFile(imgpath, "images/"+plabox_tf.getText() + ".jpg");//);
                    //container.setFoto(img);

                }
                else
                {
                    mostrarWarning("Error", "Foto no encontrada");
                }
            });
        //SE DESPLIEGAN LOS FORMULARIOS DE AUTO
        auto.setOnMouseClicked((MouseEvent evento)->
            {
                vehactual = "auto";
                scrollpane.setContent(null);
                
                tracbox_tf.setEditable(false);
                vidbox_tf.setEditable(true);
                transbox_tf.setEditable(true);
                
                scrollpane.setContent(vboxexpoveh);
            });
                ///////////CONTROLADOR DEL BOTON CAMIONETA
        camioneta.setOnMouseClicked((MouseEvent evento2)->
            {
                scrollpane.setContent(null);
                //scrollpane.setContent(vboxexpoveh);
                tracbox_tf.setEditable(true);
                vidbox_tf.setEditable(true);
                transbox_tf.setEditable(true);
                
                vehactual = "camioneta";
                Window owner = Stage.getWindows().stream().filter(Window::isShowing).findFirst().orElse(null);
                owner.setHeight(620);
                
                scrollpane.setContent(vboxexpoveh);
                //Camioneta.registrarCamioneta(scrollpane);
            });
        moto.setOnMouseClicked((MouseEvent evento3)->
            {   
                vehactual = "moto";
                scrollpane.setContent(null);
                //scrollpane.setContent(vboxexpoveh);
                tracbox_tf.setEditable(false);
                vidbox_tf.setEditable(false);
                transbox_tf.setEditable(false);
                
                scrollpane.setContent(vboxexpoveh);
               // Motos.registrarMoto(scrollpane);
            });
        
        
    }
    
    
      
    @FXML
    private void botonAceptarOfertas(MouseEvent event) {
        scrollpane.setContent(null);
        ofertas.sort(Oferta:: compareTo);
        VBox vbox= new VBox();
        scrollpane.setContent(vbox);
        for(Oferta o:ofertas){
                HBox hbox = new HBox();
                Image foto= new Image("img/"+o.getPlaca()+".jpg");
                ImageView im= new ImageView(foto);
                Text comprador= new Text(o.getCorreo());
                Text precio= new Text(""+o.getPrecio());
                Text placa= new Text(o.getPlaca());
                Button boton= new Button();
                boton.setText("Aceptar");
                boton.setOnMouseClicked((MouseEvent evento)->{
                    Oferta.removerOferta("ofertas.ser", o);
                try {
                    Util.enviarCorreo(o.getCorreo(),usuario.getCorreo());
                } catch (MessagingException ex) {
                    Util.mostrarWarning("ERROR DE MENSAJERIA",ex.getMessage());
                }
                this.botonAceptarOfertas(event);
                });
                hbox.getChildren().add(im);
                hbox.getChildren().add(comprador);
                hbox.getChildren().add(precio);
                hbox.getChildren().add(placa);
                hbox.getChildren().add(boton);
                vbox.getChildren().add(hbox);
        }
    }
    

    @FXML
    private void botonRegistrarComprador(MouseEvent event) {
        //////////////////////////////////////
        double wrappingW = 80;
        double spacing = 60;
        VBox vbox= new VBox();
        vbox.setAlignment(Pos.CENTER);
        scrollpane.setContent(vbox);
        vbox.setPadding(new Insets(45, 0, 0, 45));
        
        
        ////////////////////////////////////////
        
        HBox hbox1 = new HBox();
        hbox1.setSpacing(spacing);
        hbox1.setPadding(new Insets(30,0,0,0));
        Text nombret = new Text("Nombres:");
        nombret.setWrappingWidth(wrappingW);
        
        TextField nombretf = new TextField();
        hbox1.getChildren().add(nombret);
        hbox1.getChildren().add(nombretf);
        
        HBox hbox2 = new HBox();
        hbox2.setSpacing(spacing);
        hbox2.setPadding(new Insets(30,0,0,0));
        Text apellidot= new Text("Apellidos:");
        
        apellidot.setWrappingWidth(wrappingW);
        TextField apellidotf = new TextField();
        hbox2.getChildren().add(apellidot);
        hbox2.getChildren().add(apellidotf);
        
        HBox hbox3 = new HBox();
        hbox3.setSpacing(spacing);
        
        hbox3.setPadding(new Insets(30,0,0,0));
        Text correot = new Text("Correo:");
        
        correot.setWrappingWidth(wrappingW);
        TextField correotf = new TextField();
        hbox3.getChildren().add(correot);
        hbox3.getChildren().add(correotf);
        
        HBox hbox4 = new HBox();
        
        hbox4.setSpacing(spacing);
        hbox4.setPadding(new Insets(30,0,0,0));
        Text orgt= new Text("Organización:");
        
        orgt.setWrappingWidth(wrappingW);
        TextField orgtf = new TextField();
        hbox4.getChildren().add(orgt);
        hbox4.getChildren().add(orgtf);
        
        HBox hbox5 = new HBox();
        hbox5.setSpacing(spacing);
        hbox5.setPadding(new Insets(30,0,0,0));
        Text clavet = new Text("Clave:");
        
        clavet.setWrappingWidth(wrappingW);
        PasswordField clavetf = new PasswordField();
        hbox5.getChildren().add(clavet);
        hbox5.getChildren().add(clavetf);     
        
        HBox hbox6 = new HBox();
        
        
        Button btnRegister = new Button("Registrar");
        
        VBox.setMargin(btnRegister,new Insets(30,0,0,0));
        
        //////////////////////////////////////////////////
        
        vbox.getChildren().clear();
        vbox.getChildren().add(hbox1);
        vbox.getChildren().add(hbox2);
        vbox.getChildren().add(hbox3);
        vbox.getChildren().add(hbox4);
        vbox.getChildren().add(hbox5);
        
        ///////////////////////////////////////////////////
        
        
        ///////////////////////////////////////////////////
        btnRegister.setOnMouseClicked((MouseEvent evento)-> 
        {
            String nombre = nombretf.getText();
            String apellido = apellidotf.getText();
            String organizacion = orgtf.getText();
            String correo = correotf.getText();   
            String cla = clavetf.getText();
            System.out.println(correo);
            System.out.println(cla);
            System.out.println(correo);
            
            if(!nombretf.getText().isEmpty() && !apellidotf.getText().isEmpty() &&
                !correotf.getText().isEmpty() && !orgtf.getText().isEmpty() &&
                !clavetf.getText().isEmpty())
            {  

                    if(Comprador.registrarComprador(nombre, apellido, organizacion, correo, cla))
                    {
                        //Alert a = new Alert(AlertType.INFORMATION, "¡Registro exitoso!"); 
                        //a.show();  
                    }

            }

        });
        vbox.getChildren().add(btnRegister);
        
    }

    public static void copyFile(String inputPath, String outputPath) 
    {

        InputStream in = null;
        OutputStream out = null;
        try {
            in = new FileInputStream(inputPath);
            out = new FileOutputStream(outputPath);

            byte[] buffer = new byte[1024];
            int read;
            while ((read = in.read(buffer)) != -1) {
                out.write(buffer, 0, read);
            }
            in.close();
            in = null;

            // write the output file (You have now copied the file)
            out.flush();
            out.close();
            out = null;

            System.out.println("Copied file to " + outputPath);

        } catch (FileNotFoundException fnfe1) {
            System.out.println(fnfe1.getMessage());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    @FXML
    private void botonRealizarOferta(MouseEvent event) {
        Oferta.realizarOferta(scrollpane,correoUser);
    }

    @FXML
    private void btnregveh(MouseEvent event) 
    {
        if(!marbox_tf.getText().isEmpty() && !modbox_tf.getText().isEmpty() &&
                   !tmotorbox_tf.getText().isEmpty() && !aniobox_tf.getText().isEmpty() &&
                   !recorbox_tf.getText().isEmpty()&&!tcombox_tf.getText().isEmpty()&&
                   !colbox_tf.getText().isEmpty() && !prebox_tf.getText().isEmpty() && !vidbox_tf.getText().isEmpty()&&
                   !transbox_tf.getText().isEmpty()  && !plabox_tf.getText().isEmpty() && !fotobox_tf.getText().equals("") && vehactual.equals("auto"))
                {
                    try
                    {
                        int añov= Integer.parseInt(aniobox_tf.getText());
                        double recorridov= Double.parseDouble(recorbox_tf.getText());
                        double preciov=Double.parseDouble(prebox_tf.getText());
                        Autos autoR= new Autos(vidbox_tf.getText(), plabox_tf.getText(), marbox_tf.getText(), 
                                modbox_tf.getText(),tmotorbox_tf.getText(),añov,recorridov,colbox_tf.getText(),
                                        tcombox_tf.getText(), preciov, transbox_tf.getText());



                        //autoR.setFoto(container.getFoto());
                        autoR.saveFile("vehiculos.ser");
                        autoR.saveFile("autos.ser");
                        Alert a = new Alert(AlertType.INFORMATION, "Creado exitosamente");
                        a.show();
                        scrollpane.setContent(null);
                    }
                    catch(NumberFormatException e)
                    {
                        Util.mostrarWarning("ERROR AL LLENAR CAMPOS", "Año solo permite numeros enteros y kilotraje y precio solo permite decimales.");
                    }
                    catch(Exception e)
                    {
                         Util.mostrarWarning("ERROR", e.getMessage());
                    }
                }
        else if(!marbox_tf.getText().isEmpty() && !modbox_tf.getText().isEmpty() &&
                   !tmotorbox_tf.getText().isEmpty() && !aniobox_tf.getText().isEmpty() &&
                   !recorbox_tf.getText().isEmpty()&&!tcombox_tf.getText().isEmpty()&&
                   !colbox_tf.getText().isEmpty() && !prebox_tf.getText().isEmpty() && !vidbox_tf.getText().isEmpty()&&
                   !transbox_tf.getText().isEmpty()  && !plabox_tf.getText().isEmpty() && !fotobox_tf.getText().equals("") && 
                    !tracbox_tf.getText().isEmpty() && vehactual.equals("camioneta"))
                {
                    try
                    {
                        int añov= Integer.parseInt(aniobox_tf.getText());
                        double recorridov= Double.parseDouble(recorbox_tf.getText());
                        double preciov=Double.parseDouble(prebox_tf.getText());
                        Camioneta cam= new Camioneta(vidbox_tf.getText(), plabox_tf.getText(), marbox_tf.getText(), 
                                modbox_tf.getText(),tmotorbox_tf.getText(),añov,recorridov,colbox_tf.getText(),
                                        tcombox_tf.getText(), preciov, transbox_tf.getText(), tracbox_tf.getText());



                        cam.saveFile("vehiculos.ser");
                        cam.saveFile("camionetas.ser");
                        Alert a = new Alert(AlertType.INFORMATION, "Creado exitosamente");
                        a.show();
                        scrollpane.setContent(null);
                    }
                    catch(NumberFormatException e)
                    {
                        Util.mostrarWarning("ERROR AL LLENAR CAMPOS", "Año solo permite numeros enteros y kilotraje y precio solo permite decimales.");
                    }
                    catch(Exception e)
                    {
                         Util.mostrarWarning("ERROR", e.getMessage());
                    }
                }
        else if(!marbox_tf.getText().isEmpty() && !modbox_tf.getText().isEmpty() &&
                   !tmotorbox_tf.getText().isEmpty() && !aniobox_tf.getText().isEmpty() &&
                   !recorbox_tf.getText().isEmpty()&&!tcombox_tf.getText().isEmpty()&&
                   !colbox_tf.getText().isEmpty() && !prebox_tf.getText().isEmpty() &&
                   !plabox_tf.getText().isEmpty() && !fotobox_tf.getText().equals("") && vehactual.equals("moto"))
                {
                    try
                    {
                        int añov= Integer.parseInt(aniobox_tf.getText());
                        double recorridov= Double.parseDouble(recorbox_tf.getText());
                        double preciov=Double.parseDouble(prebox_tf.getText());
                        Motos mot= new Motos(plabox_tf.getText(), marbox_tf.getText(), 
                                modbox_tf.getText(),tmotorbox_tf.getText(),añov,recorridov,colbox_tf.getText(),
                                        tcombox_tf.getText(), preciov);



                        //autoR.setFoto(container.getFoto());
                        mot.saveFile("vehiculos.ser");
                        mot.saveFile("motos.ser");
                        Alert a = new Alert(AlertType.INFORMATION, "Creado exitosamente");
                        a.show();
                        scrollpane.setContent(null);
                    }
                    catch(NumberFormatException e)
                    {
                        Util.mostrarWarning("ERROR AL LLENAR CAMPOS", "Año solo permite numeros enteros y kilotraje y precio solo permite decimales.");
                    }
                    catch(Exception e)
                    {
                         Util.mostrarWarning("ERROR", e.getMessage());
                    }
                }
    }
}


   