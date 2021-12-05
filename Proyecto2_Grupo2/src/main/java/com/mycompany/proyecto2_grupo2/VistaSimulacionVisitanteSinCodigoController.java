/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.proyecto2_grupo2;

import static com.mycompany.proyecto2_grupo2.VistaAdministradorController.enviarCorreo;
import com.mycompany.proyecto2_grupo2.data.ResidentesData;
import com.mycompany.proyecto2_grupo2.modelo.Residente;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Properties;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 * FXML Controller class
 *
 * @author jeras
 */
public class VistaSimulacionVisitanteSinCodigoController implements Initializable {

    @FXML
    private TextField txtNombreVisitante;
    @FXML
    private Button btnIngresar;
    @FXML
    private Button btnTerminarSimulacion;
    @FXML
    private TextField txtCedulaVisitante;
    @FXML
    private TextField txtNombreResidente;
    @FXML
    private TextField txtManzanaResidente;
    @FXML
    private TextField txtVillaResidente;
    @FXML
    private Button btnRegresarPunto;
    
    private Residente residenteEncontrado = null;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
    
    public void soliciarIngreso(MouseEvent event) throws IOException, ClassNotFoundException{
        //ESTE METODO VALIDA SI ExITE EL RESIDENTE EN CASO DE ExISTIR SOLICITA
        //AL RESIDENTE QUE ENVIE UN MENSAJE CON CLAVE DE ACTIVACION
        String nombre = txtNombreResidente.getText();
        String mz = txtManzanaResidente.getText();
        String vil = txtVillaResidente.getText();
        
        if (validarDatos()) {
            if (buscarResidente()) {
                Thread t1 = new Thread(new notificarResidente());
                t1.setDaemon(true);
                t1.start();
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText("Search error");
                alert.setTitle("INFORMATION ERROR..!");
                alert.setContentText("La informacion ingresada NO COINCIDE con ningun Residente, por favor corriga los datos");
                alert.showAndWait();
                txtNombreVisitante.clear();
                txtCedulaVisitante.clear();
                txtNombreResidente.clear();
                txtManzanaResidente.clear();
                txtVillaResidente.clear();
            }//FIN DEL IF DE LA BUSQUEDA DE RESIDENTE
            
        }//IF DE LA VALIDACION DE DATOS
        
        
    
    }
    
    public boolean buscarResidente() throws IOException, ClassNotFoundException{
        boolean encontrado = false;
        residenteEncontrado = null;
        
        List<Residente> residentes = ResidentesData.leerResidentes();
        for(Residente r: residentes){
                String nResidente = r.getNombre().toLowerCase();
                String nResidenteBuscar = txtNombreResidente.getText().toLowerCase();
                Double manz = Double.parseDouble(txtManzanaResidente.getText());
                Double vil = Double.parseDouble(txtVillaResidente.getText());
                Double rMz = r.getCasa().getUbicacion().getX();
                Double rVilla = r.getCasa().getUbicacion().getY();
            if (nResidente.equals(nResidenteBuscar)) {
                if (manz.equals(rMz)) {
                    if (vil.equals(rVilla)) {
                        System.out.println("SI SE ENCONTRO Y SE ENVIARA MSJ");
                        residenteEncontrado = r;
                        encontrado = true;
                        Alert alert = new Alert(Alert.AlertType.INFORMATION);
                        alert.setHeaderText("SUCESS");
                        alert.setContentText("SE HA ENVIADO UNA SOLICITUD AL RESIDENTE, EN CASO DE APROBACION,"
                                + "El Residente le enviará un correo, con validez de 15 minutos!");
                        alert.showAndWait();
                        return encontrado;
                    }

                }
            }
            System.out.println("NO SE ENCUENTRA...");
        }
        
        return encontrado;
    }
    
    public boolean validarDatos(){
        Alert fail= new Alert(Alert.AlertType.INFORMATION);
        fail.setHeaderText("ERROR!");
        if ((txtNombreVisitante.getText().trim().isEmpty()) &&(txtCedulaVisitante.getText().trim().isEmpty()) 
                &&(txtNombreResidente.getText().trim().isEmpty())&&(txtManzanaResidente.getText().trim().isEmpty())
                &&(txtVillaResidente.getText().trim().isEmpty())) {
            fail.setContentText("CAMPOS VACIOS, POR FAVOR INGRESE DATOS...!");
            fail.showAndWait();
        }else if(txtNombreVisitante.getText().trim().isEmpty()){
            fail.setContentText("FALTA DATOS, POR FAVOR INGRESE DATOS...!");
            fail.showAndWait();
        }else if(txtCedulaVisitante.getText().trim().isEmpty()){
            fail.setContentText("FALTA DATOS, POR FAVOR INGRESE DATOS...!");
            fail.showAndWait();
        }else if(txtNombreResidente.getText().trim().isEmpty()){
            fail.setContentText("FALTA DATOS, POR FAVOR INGRESE DATOS...!");
            fail.showAndWait();
        }else if(txtManzanaResidente.getText().trim().isEmpty()){
            fail.setContentText("FALTA DATOS, POR FAVOR INGRESE DATOS...!");
            fail.showAndWait();
        }else if(!isNumeric(txtManzanaResidente.getText())){
            fail.setContentText("DATO INCORRECTO, INGRESE SOLO NUMEROS...!");
            fail.showAndWait();
        }else if(txtVillaResidente.getText().trim().isEmpty()){
            fail.setContentText("FALTA DATOS, POR FAVOR INGRESE DATOS...!");
            fail.showAndWait();
        }else if(!isNumeric(txtVillaResidente.getText())){
            fail.setContentText("DATO INCORRECTO, INGRESE SOLO NUMEROS...!");
            fail.showAndWait();
        } else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText("DATA VALIDATION OK");
            alert.setContentText("Datos Ingresados correctamente, a continuacion se buscará en nuestra Base de datos coincidencias....");
            alert.showAndWait();
            return true;
        }
        
        return false;
    
    }
    
    
        
   public boolean isNumeric(String cadena){
      try{
          double d = Double.parseDouble(cadena);
      }catch(NumberFormatException nfe){  
          return false;
      }
      return true;
  }
    
    public  void enviarCorreo() {
        //Inicializamos nuestras credenciales de remitente
        String remitente = "sistemabienesraicesg6@gmail.com";
        String clave = "sbr123456.";
        //String destino = "jeraslindao@gmail.com"; //A quien le quieres escribir.
        String asunto = "Alerta de Propiedades - Sistema Bienes Raicez";
        String residente = residenteEncontrado.getNombre();
        String destino = residenteEncontrado.getCorreo();
        String visitante = txtNombreVisitante.getText();
        String cedulaVisitante = txtCedulaVisitante.getText();
        String claveTemporal =String8Character();
        LocalDate fe= LocalDate.now();
        LocalTime ho= LocalTime.now();
        ClaveTemporal c = new ClaveTemporal(claveTemporal,fe,ho);
        App.agregarClaveTemporal(new ClaveTemporal(claveTemporal,fe,ho));
        
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
            mensaje.setText("Estimado Sr."+residente+"Le informamos que el Sr."+visitante+
                    ",Desea visitarlo\n\n SI autoriza su ingreso por favor enviele la siguiente clave de acceso"
                            + "\n\nCLAVE ="+claveTemporal);
            Transport transport = session.getTransport("smtp");
            transport.connect("smtp.gmail.com",remitente,clave);
            transport.sendMessage(mensaje,mensaje.getAllRecipients());
            transport.close();
            System.out.println("\n*** Correo Enviado ****");
        }catch(Exception e){
            e.printStackTrace(); 
        }
        
    }
    
    @FXML
    public String String8Character() {
        String alphanumeric;
        StringBuilder builder;

        alphanumeric = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
                + "0123456789";

        //create the StringBuffer
        builder = new StringBuilder(8);

        for (int m = 0; m < 8; m++) {

            // generate numeric
            int myindex
                    = (int) (alphanumeric.length()
                    * Math.random());

            // add the characters
            builder.append(alphanumeric.charAt(myindex));
        }

        return builder.toString();
    }
    
    @FXML
    public void regresarPuntoAcceso(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(App.class.getResource("VistaSimulacionVisitantes.fxml"));
            Parent root = loader.load();
            VistaSimulacionVisitantesController vsv = loader.<VistaSimulacionVisitantesController>getController();
            System.out.println(vsv);
            //vsrc.setResidente(VistaResidenteController.getResidente());
            App.scene.setRoot(root);

        } catch (IOException ex) {
            System.out.println("no se ha podido cargar la vista");
        }

    }
    
    @FXML
    public void terminarSimulacion(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(App.class.getResource("VistaInicio.fxml"));
            Parent root = loader.load();
            VistaInicioController vi = loader.<VistaInicioController>getController();
            System.out.println(vi);
            //vsrc.setResidente(VistaResidenteController.getResidente());
            App.scene.setRoot(root);

        } catch (IOException ex) {
            System.out.println("no se ha podido cargar la vista");
        }

    }
    
    
    
    
    class notificarResidente implements Runnable {

        @Override
        public void run() {
            try {
                Platform.runLater(() -> {
                    enviarCorreo();
                });

                Thread.sleep(500);

            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }

        }

    }
    
}
