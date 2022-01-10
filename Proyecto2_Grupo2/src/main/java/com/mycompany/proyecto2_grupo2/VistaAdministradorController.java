/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.proyecto2_grupo2;

import com.mycompany.proyecto2_grupo2.data.CasasData;
import com.mycompany.proyecto2_grupo2.data.ResidentesData;
import com.mycompany.proyecto2_grupo2.modelo.Casa;
import com.mycompany.proyecto2_grupo2.modelo.Residente;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.concurrent.ThreadLocalRandom;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

//LIBRERIAS PARA ENVIAR CORREO
import java.util.Properties;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Properties;
import javafx.application.Platform;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.MessagingException;




/**
 * FXML Controller class
 *
 * @author andya
 */
public class VistaAdministradorController implements Initializable {

    @FXML
    private Pane paneMapa;
    @FXML
    private Menu btnMapa;
    @FXML
    private MenuItem btnReportes;
    @FXML
    private MenuItem btnInicio;
    @FXML
    private GridPane formularioRegistro;
    @FXML
    private Button btnGuardar;
    @FXML
    private TextField txtNombre;
    @FXML
    private TextField txtCorreo;
    @FXML
    //private TextField txtGenero;
    private ComboBox<String> cmbxGenero;
    
    private Casa casaSeleccionada;
    private Residente residenteNuevo;
    private static List<String> generos;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        cargarGeneros(); // carga la Info del ComboBox
              
        try {
            ArrayList<Casa> casas = CasasData.leerCasas();
            
            for (Casa ca : casas) {
                ImageView casa = crearCasa();
                paneMapa.getChildren().add(casa);
                casa.setLayoutX(ca.getUbicacion().getX());
                casa.setLayoutY(ca.getUbicacion().getY());
                Tooltip t = new Tooltip(ca.verResidente()+ ca.getUbicacion().toString());
                Tooltip.install(casa, t);

                casa.setOnMouseClicked((MouseEvent ev) -> {
                    
                    formularioRegistro.setDisable(false);
                    formularioRegistro.setVisible(true);
                    casaSeleccionada = ca;
                    
                    btnGuardar.setOnMouseClicked((MouseEvent ev1) -> {
                    
                        String nombre = txtNombre.getText();
                        String correo = txtCorreo.getText();
                        String genero = cmbxGenero.getValue();
                        Thread t1 = new Thread();
                        
                        if (ca.getResidente() == null) { // ENTRA AL IF SI LA CASA ESTA VACIA
                            double fiveDigits = 10000 + Math.random() * 90000;
                            int contraseña = (int) fiveDigits;
                            double fourDigits = 1000 + Math.random() * 9000;
                            int pin = (int) fourDigits;

                            try {
                                ArrayList<Residente> residentes = ResidentesData.leerResidentes();
                                
                                Residente r1 = new Residente(nombre+randomString(), String.valueOf(contraseña), nombre, correo, genero, String.valueOf(pin),casaSeleccionada);
                                if (residenteIsValid(r1)) { // ENTRA AL IF SI EL RESIDENTE ES VALIDO Y NO ESTA REPETIDO
                                    residenteNuevo = r1;
                                    residentes.add(r1);
                                    ResidentesData.escribirResidentes(residentes);
                                    ca.setResidente(r1);
                                    System.out.println("Usuario: " + r1.getUser() + "\n" + "Contraseña: " + r1.getContrasenia() + "\n" + "Pin: " + r1.getPin());
                                    CasasData.escribirCasas(casas);
                                    
                                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                                    alert.setHeaderText("SUCESS");
                                    alert.setContentText("LOS DATOS SE GUARDARON CON EXITO!");
                                    
                                    enviarCredenciales eC = new enviarCredenciales();
                                    t1 = new Thread(eC);
                                    t1.setDaemon(true);
                                    t1.start();
                                    
                                    
                                    alert.showAndWait();
                                    txtNombre.clear();
                                    txtCorreo.clear();
                                    cmbxGenero.getItems().clear();
                                    cargarGeneros();
                                    formularioRegistro.setDisable(true);
                                    formularioRegistro.setVisible(false);
                                }else{
                                    Alert al = new Alert(Alert.AlertType.ERROR);
                                    al.setHeaderText("Generation error");
                                    al.setTitle("Datos ó dato Existente");
                                    al.setContentText("Estos datos ya se han ingresado, anteriormente\nPor favor, Ingrese nuevamente");
                                    al.showAndWait();
                                    txtNombre.clear();
                                    txtCorreo.clear();
                                    cmbxGenero.getItems().clear();
                                    cargarGeneros();
                                    formularioRegistro.setDisable(true);
                                    formularioRegistro.setVisible(false);
                                }//IF QUE GENERA SI EL RESIDENTE ES VALIDO
                                

                            } catch (IOException ex) {
                                ex.printStackTrace();
                                System.out.println("No se leyo algo en la linea 115");
                            } catch (ClassNotFoundException ex) {
                                ex.printStackTrace();
                                System.out.println("No se leyo algo en la linea 115");
                            }

                        } else {
                            Alert al = new Alert(Alert.AlertType.ERROR); 
                            al.setHeaderText("Generation error");
                            al.setTitle("Residente Error");
                            al.setContentText("LA CASA ESTA OCUPADA, el Residente es: " + ca.getResidente().getNombre());
                            al.showAndWait();
                            txtNombre.clear();
                            txtCorreo.clear();
                            cmbxGenero.getItems().clear();
                            cargarGeneros();
                            formularioRegistro.setDisable(true);
                            formularioRegistro.setVisible(false);
                        }//FIN DEL IF
                        
                    }); //FIN DEL EVENTO GUARDAR

                }); // FIN DEL EVENTO CLICKED
            
            }//FIN DEL RECORRIDO DEL FOR
           
        } catch (IOException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        
        
    }
    
    public void cargarGeneros(){
        try {
            generos = new ArrayList<>();
            generos.add("MASCULINO");
            generos.add("FEMENINO");
            cmbxGenero.getItems().addAll(generos);
        } catch (Exception ex) {
            ex.printStackTrace();
        }//TRY-CATCH DEL COMBOBOx
    
    }
    
    public ImageView crearCasa(){
        Image img = new Image(App.class.getResourceAsStream("Casa.png"));
        ImageView imgview = new ImageView(img);
        imgview.setFitHeight(100.0);
        imgview.setFitWidth(100.0);
        return imgview;
    }

    @FXML
    private void MostrarReportes(ActionEvent event) {
        try{
            FXMLLoader loader= new FXMLLoader(App.class.getResource("VistaReportes.fxml"));
            Parent root = loader.load();
            VistaReportesController ic = loader.<VistaReportesController>getController();
            System.out.println(ic);
            App.scene.setRoot(root);
            
        }catch(IOException ex){
            System.out.println("no se ha podido cargar la vista");
        }
    }
    
    @FXML
    private void MostrarMenuInicial(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(App.class.getResource("VistaInicio.fxml"));
            Parent root = loader.load();
            VistaInicioController ic = loader.<VistaInicioController>getController();
            System.out.println(ic);
            App.scene.setRoot(root);
            

        } catch (IOException ex) {
            System.out.println("no se ha podido cargar la vista");
        }
    }
    
    @FXML
    private void initialize(ActionEvent event) {
    }
    

    @FXML
    public String randomString() {
        String alphanumeric;
        StringBuilder builder;

        alphanumeric = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
                + "0123456789";

        //create the StringBuffer
        builder = new StringBuilder(4);

        for (int m = 0; m < 4; m++) {

            // generate numeric
            int myindex
                    = (int) (alphanumeric.length()
                    * Math.random());

            // add the characters
            builder.append(alphanumeric.charAt(myindex));
        }

        return builder.toString();
    }

    
    public boolean residenteIsValid(Residente r) throws IOException, ClassNotFoundException{
        ArrayList<Residente> residentes= ResidentesData.leerResidentes();
        
        for(Residente re : residentes){
            if(re.getNombre().toLowerCase().equals(r.getNombre().toLowerCase())){
                return false;
            }else if(re.getCorreo().toLowerCase().equals(r.getCorreo().toLowerCase())){
                return false;
            }else if(re.getUser().equals(r.getUser())){
                return false;
            }
        }
        return true;
    }
    
    
    public static void enviarCorreo(Residente r) {
        
        //Inicializamos nuestras credenciales de remitente
        String remitente = "sistemabienesraicesg6@gmail.com";
        String clave = "sbr123456.";
        //String destino = "jeraslindao@gmail.com"; //A quien le quieres escribir.
        String destino = r.getCorreo();
        String asunto = "PROYECTO POO - 2DO PARCIAL - GRUPO 2";
        String usuario = r.getUser();
        String contrasenia = r.getContrasenia();
        String pin = r.getPin();
        //Configuramos las credenciales, host, puerto para enviar correo, usando smtp de Gmail
        Properties props = new Properties();
            props.put("mail.smtp.host", "smtp.gmail.com");
            props.put("mail.smtp.port", "465");
            props.put("mail.smtp.auth", "true");
            props.put("mail.smtp.starttls.enable", "true");
            props.put("mail.smtp.starttls.required", "false");
            props.put("mail.smtp.ssl.protocols", "TLSv1.2");
            props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
            props.put("mail.smtp.user", remitente);
            props.put("mail.smtp.clave", clave);
            

        
        Session session = Session.getDefaultInstance(props);
        MimeMessage mensaje = new MimeMessage(session); //mensaje basado con la configuracion inicial que creamos

        //Controlamos el envio smtp con un try-catch
        try{
            mensaje.addRecipient(Message.RecipientType.TO,new InternetAddress(destino));
            mensaje.setSubject(asunto);
            mensaje.setText("Estimado Residente se ha llevado a cabo con exito su registro\n\n"
                    + "Su credenciales son:\n\nUsuario    = "+usuario+"\nPassword = "+contrasenia+
                    "\nPIN          = "+pin);
            Transport transport = session.getTransport("smtp");
            transport.connect("smtp.gmail.com",remitente,clave);
            transport.sendMessage(mensaje,mensaje.getAllRecipients());
            transport.close();
            System.out.println("\n*** Correo Enviado ****");
        }catch(Exception e){
            e.printStackTrace(); 
        }
        
    }
   
    
    
    class enviarCredenciales implements Runnable {

        @Override
        public void run() {
            try {
                Platform.runLater(() -> {
                    enviarCorreo(residenteNuevo);
                });

                Thread.sleep(500);

            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }

        }

    }
    
    
}
