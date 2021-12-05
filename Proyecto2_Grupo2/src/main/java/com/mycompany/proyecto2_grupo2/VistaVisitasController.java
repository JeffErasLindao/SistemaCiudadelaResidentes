/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.proyecto2_grupo2;

import static com.mycompany.proyecto2_grupo2.VistaAdministradorController.enviarCorreo;
import com.mycompany.proyecto2_grupo2.VistaVisitasController.Visita;
import com.mycompany.proyecto2_grupo2.data.VehiculosData;
import com.mycompany.proyecto2_grupo2.data.VisitantesData;
import com.mycompany.proyecto2_grupo2.modelo.Residente;
import com.mycompany.proyecto2_grupo2.modelo.Vehiculo;
import com.mycompany.proyecto2_grupo2.modelo.Visitante;
import java.io.IOException;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Alert;

import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;


import java.util.Properties;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Properties;
import javafx.application.Platform;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.ListChangeListener;
import javafx.event.EventHandler;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
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
public class VistaVisitasController implements Initializable {


    @FXML
    private Menu btnVisitas;
    @FXML
    private MenuItem btnDatos;
    @FXML
    private MenuItem btnVehiculos;
    @FXML
    private Button btnRegistrarVisita;
    @FXML
    private TextField txtfechaInicio;
    @FXML
    private TextField txtfechaFin;
    @FXML
    private Button btnBuscarVisitas;
    @FXML
    private TextField txtNombre;
    @FXML
    private TextField txtCedula;
    @FXML
    private TextField txtCorreo;
    @FXML
    private TextField txtFecha;
    
    private Residente residente;
    @FXML
    private TextField txtHora;
    
    private Visitante visitanteNuevo;
    
    private Visitante visitanteActual;
    @FXML
    private TableView<Visita> tvVisitas;
    @FXML
    private Button btnRemove;
    @FXML
    private Pane paneVisitas;
    @FXML
    private TableColumn<Visita,String> tcNombre;
    @FXML
    private TableColumn<Visita,String> tcCedula;
    @FXML
    private TableColumn<Visita,String> tcCodigo;
    @FXML
    private TableColumn<Visita,String> tcFecha;
    @FXML
    private TableColumn<Visita,String> tcEstado;
    /**
     *
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
   
               
        //tcNombre.setCellValueFactory(new PropertyValueFactory<Visita,String>("nombre"));
        //tvVisitas1.getColumns().addAll(tcNombre);
        //paneVisitas.getChildren().addAll(tvVisitas1);
        
      /* ObservableList<Visita> visitas = FXCollections.observableArrayList(
                    new Visita("Juan","095sad2","111","2021-10-10","SI"),
                    new Visita("CARLOS","095a2","112","2021-10-11","NO"),
                    new Visita("pedro","aaa","113","2021-10-12","SI"),
                    new Visita("oso","095sss02","114","2021-10-13","NO"),
                    new Visita("Jessica","09ddqq502","115","2021-10-14","NO")
        );*/
        
        /*tvVisitas.setItems(visitas);
        tcNombre.setCellValueFactory(new PropertyValueFactory<Visita, String>("nombre"));
        tcCedula.setCellValueFactory(new PropertyValueFactory<Visita, String>("cedula"));
        tcCodigo.setCellValueFactory(new PropertyValueFactory<Visita, String>("codigoAcceso"));
        tcFecha.setCellValueFactory(new PropertyValueFactory<Visita, String>("fecha"));
        tcEstado.setCellValueFactory(new PropertyValueFactory<Visita, String>("estado"));/*
      
        //tvVisitas.getColumns().addAll(tcNombre,tcCedula,tcCodigo,tcFecha,tcEstado);*/
       
        
        //Remove Row from TableView
        
        /*btnRemove.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent t) {
                if(tvVisitas.getSelectionModel().isEmpty()){
                    Alert al = new Alert(Alert.AlertType.ERROR);
                    al.setHeaderText("ERROR");
                    al.setTitle("REMOVE ERROR");
                    al.setContentText("Tiene que seleccionar un item de la lista");
                    al.showAndWait();
                }else{
                    visitas.remove(tvVisitas.getSelectionModel().getSelectedItem());
                }
                
            }
        });*/
        
        
        /*visitas.addListener(new ListChangeListener() {
 
            @Override
            public void onChanged(ListChangeListener.Change change) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setHeaderText("SUCESS");
                alert.setContentText("LA FILA SE BORRO CON EXITO!");
            }
        });*/
        
    }    
    
    public void setResidente(Residente r){
        this.residente=residente;
        
    }
    
    public Residente getResidente(){
        return residente;
    }
    @FXML
    private void VerDatos(ActionEvent event) {
        try{
                        FXMLLoader loader= new FXMLLoader(App.class.getResource("VistaResidente.fxml"));
            
                        Parent root = loader.load();
                        VistaResidenteController ic = loader.<VistaResidenteController>getController();
                        System.out.println(ic);
                        ic.setResidente(getResidente());
                        App.scene.setRoot(root);
            
                        }catch(IOException ex){
                        System.out.println("no se ha podido cargar la vista");
                        }
    }

    @FXML
    private void registrarVehiculo(ActionEvent event) {
        try{
                        FXMLLoader loader= new FXMLLoader(App.class.getResource("VistaVehiculos.fxml"));
            
                        Parent root = loader.load();
                        VistaVehiculosController vc = loader.<VistaVehiculosController>getController();
                        System.out.println(vc);
                        vc.setResidente(getResidente());
                        App.scene.setRoot(root);
            
                        }catch(IOException ex){
                        System.out.println("no se ha podido cargar la vista");
                        }
    }

    @FXML
    private void registrarVisitas(MouseEvent event) throws ParseException, IOException, ClassNotFoundException{
        validarEntradaDatos();
    }
    
        
    public static boolean isInteger(String cadena) {
        int numero;
        try {
            numero = Integer.parseInt(cadena);
            return true;
        } catch (NumberFormatException ex) {
            return false;
        }
    }
    
    
    public static boolean validarFecha(String cadena) throws ParseException{
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
             try{
                df.parse(cadena);
                return true;
            }catch(DateTimeParseException n){
                return false;
            }catch(ParseException e){
                return false;
            }
    }
    
    public static boolean validarHora(String cadena){    
        SimpleDateFormat tf = new SimpleDateFormat("HH:mm:ss");
        try{
            LocalTime.parse(cadena);
            return true;
        }catch(DateTimeParseException n){
            return false;
        }
    }
    
    public void validarEntradaDatos() throws ParseException, IOException, ClassNotFoundException{
        Thread t2 = new Thread();
        if ((txtNombre.getText().trim().isEmpty()) && (txtCedula.getText().trim().isEmpty())
                && (txtCorreo.getText().trim().isEmpty()) && (txtFecha.getText().trim().isEmpty())) {
            Alert al = new Alert(Alert.AlertType.ERROR);
            al.setHeaderText("DATA ERROR");
            al.setTitle("Error al registrar");
            al.setContentText("CAMPOS VACIO DEBE INGRESAR DATOS...!");
            al.showAndWait();
        } else if (txtNombre.getText().trim().isEmpty()) {
            Alert al = new Alert(Alert.AlertType.ERROR);
            al.setHeaderText("DATA ERROR");
            al.setTitle("Error al registrar");
            al.setContentText("Faltan datos por ingresar, por favor llene los datos que faltan...!");
            al.showAndWait();
        } else if (txtCedula.getText().trim().isEmpty()) {
            Alert al = new Alert(Alert.AlertType.ERROR);
            al.setHeaderText("DATA ERROR");
            al.setTitle("Error al registrar");
            al.setContentText("Faltan datos por ingresar, por favor llene los datos que faltan...!");
            al.showAndWait();
        } else if (!isInteger(txtCedula.getText())) {
            Alert al = new Alert(Alert.AlertType.ERROR);
            al.setHeaderText("DATA ERROR");
            al.setTitle("Error al registrar");
            al.setContentText("INGRESA SOLO NUMEROS...!, Por favor ingrese nuevamente!");
            al.showAndWait();
            txtCedula.clear();
        } else if (txtCorreo.getText().trim().isEmpty()) {
            Alert al = new Alert(Alert.AlertType.ERROR);
            al.setHeaderText("DATA ERROR");
            al.setTitle("Error al registrar");
            al.setContentText("Faltan datos por ingresar, por favor llene los datos que faltan...!");
            al.showAndWait();
        } else if (txtFecha.getText().trim().isEmpty()) {
            Alert al = new Alert(Alert.AlertType.ERROR);
            al.setHeaderText("DATA ERROR");
            al.setTitle("Error al registrar");
            al.setContentText("Faltan datos por ingresar, por favor llene los datos que faltan...!");
            al.showAndWait();

        } else if (!validarFecha(txtFecha.getText())) {
            Alert al = new Alert(Alert.AlertType.ERROR);
            al.setHeaderText("DATA ERROR");
            al.setTitle("Error al registrar");
            al.setContentText("El formato de la fecha es INCORRECTA por favor Ingrese <yyyy-MM-dd>..!");
            al.showAndWait();
        } else if (txtHora.getText().trim().isEmpty()) {
            Alert al = new Alert(Alert.AlertType.ERROR);
            al.setHeaderText("DATA ERROR");
            al.setTitle("Error al registrar");
            al.setContentText("Faltan datos por ingresar, por favor llene los datos que faltan...!");
            al.showAndWait();
        } else if (!validarHora(txtHora.getText())) {
            Alert al = new Alert(Alert.AlertType.ERROR);
            al.setHeaderText("DATA ERROR");
            al.setTitle("Error al registrar");
            al.setContentText("El formato de la hora es INCORRECTA por favor Ingrese <HH:mm:ss>..!");
            al.showAndWait();
        } else {
            String nombre = txtNombre.getText();
            String cedula = txtCedula.getText();
            String correo = txtCorreo.getText();
            LocalDate fec = LocalDate.parse(txtFecha.getText());
            LocalTime hor = LocalTime.parse(txtHora.getText());
            String codigo = randomString();
            Visitante vi = new Visitante(nombre, cedula, correo, fec, hor, codigo);
            if (validarVisitante(vi)) {
                ArrayList<Visitante> visitantes = VisitantesData.leerVisitantes();
                visitantes.add(vi);
                VisitantesData.escribirVisitantes(visitantes);
                visitanteNuevo = vi;
                enviarClaveAcceso eCA = new enviarClaveAcceso();
                t2 = new Thread(eCA);
                t2.setDaemon(true);
                t2.start();
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setHeaderText("SUCESSFULL");
                alert.setContentText("Su VISITANTE Se registro correctament..!");
                alert.showAndWait();
                txtNombre.clear();
                txtCedula.clear();
                txtCorreo.clear();
                txtFecha.clear();
                txtHora.clear();
            } else {
                Alert al = new Alert(Alert.AlertType.ERROR);
                al.setHeaderText("VISITANTE ERROR");
                al.setTitle("Error al registrar");
                al.setContentText("Ya existe un visitante paara éste día, solo una visita diaria");
                al.showAndWait();
                txtFecha.clear();
                txtHora.clear();
            }

        }
    }
    
    public static boolean validarVisitante(Visitante newVisitante) throws IOException, ClassNotFoundException{
        ArrayList<Visitante> visitantes = VisitantesData.leerVisitantes();
        for(Visitante v:visitantes){
            if(v.getNombre().toLowerCase().equals(newVisitante.getNombre().equals(v))){
                if(v.getFecha().toString().equals(v.getFecha().toString())){
                    return false;
                }
            
            }
        }
        return true;
    
    }
    
    public String randomString() {
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
    
    
    public static void enviarCorreo(Visitante v) {
        
        //Inicializamos nuestras credenciales de remitente
        String remitente = "sistemabienesraicesg6@gmail.com";
        String clave = "sbr123456.";
        //String destino = "jeraslindao@gmail.com"; //A quien le quieres escribir.
        String destino = v.getCorreo();
        String asunto = "PROYECTO POO - 2DO PARCIAL - GRUPO 2";
        String visitante = v.getNombre();
        String fecha = v.getFecha().toString();
        String hora= v.getHora().toString();
        String codigo = v.getCodigo();
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
            mensaje.setText("Estimado Sr/a." +visitante+",\n\nSu visita esta programada para el dia, "+
                    fecha+"a las: "+hora+"\n\n\n no olvide su clave la cual es la siguiente\n\n:"+
                    "Password\t="+codigo);
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
    public void buscar(ActionEvent event) throws ParseException, IOException, ClassNotFoundException
    ,DateTimeParseException{
        
        if ((txtfechaInicio.getText().trim().isEmpty()) &&(txtfechaFin.getText().trim().isEmpty()) ) {
            Alert al = new Alert(Alert.AlertType.ERROR);
            al.setHeaderText("DATA ERROR");
            al.setTitle("Error al BUSCAR");
            al.setContentText("NO HA INGRESADO NADA..!");
            al.showAndWait();
        }else if(txtfechaInicio.getText().trim().isEmpty()){
            Alert al = new Alert(Alert.AlertType.ERROR);
            al.setHeaderText("DATA ERROR");
            al.setTitle("Error al BUSCAR");
            al.setContentText("No ha ingresado RANGO de FECHA DE INICIO..!");
            al.showAndWait();
        }else if(txtfechaFin.getText().trim().isEmpty()){
            Alert al = new Alert(Alert.AlertType.ERROR);
            al.setHeaderText("DATA ERROR");
            al.setTitle("Error al BUSCAR");
            al.setContentText("No ha ingresado RANGO de FECHA FINAL..!");
            al.showAndWait();
        } else if (!validarFecha(txtfechaInicio.getText())) {
            Alert al = new Alert(Alert.AlertType.ERROR);
            al.setHeaderText("DATA ERROR");
            al.setTitle("Error al BUSCAR");
            al.setContentText("El formato de la fecha es INCORRECTA por favor Ingrese <yyyy-MM-dd>..!");
            al.showAndWait();
        }else if(!validarFecha(txtfechaFin.getText())){
            Alert al = new Alert(Alert.AlertType.ERROR);
            al.setHeaderText("DATA ERROR");
            al.setTitle("Error al BUSCAR");
            al.setContentText("El formato de la fecha es INCORRECTA por favor Ingrese <yyyy-MM-dd>..!");
            al.showAndWait();      
        }else{
            LocalDate   fechaIn= LocalDate.parse(txtfechaInicio.getText());
            LocalDate fechaFinal= LocalDate.parse(txtfechaFin.getText());
            
            if(fechaIn.isAfter(fechaFinal)){
            Alert al = new Alert(Alert.AlertType.ERROR);
            al.setHeaderText("DATA ERROR");
            al.setTitle("Error al BUSCAR");
            al.setContentText("La Fecha final debe ser mayor que la inicial");
            al.showAndWait();    
            }else{
            System.out.println("ENTRO Y DEBE MOSTRAR TABLA");
                fechaIn= LocalDate.parse(txtfechaInicio.getText());
                fechaFinal= LocalDate.parse(txtfechaFin.getText());
                List<Visitante> listaFiltrada = filtrarVisitasIntervalo(fechaIn,fechaFinal); // AQUI FALTA TERMINAR EL METODO filtrarVisitasIntervalo();
                ObservableList<Visita> listaObservable = crearListaVisita(listaFiltrada);
                mostrarTabla(listaObservable);
            }
        }


    }
    
    
    public List<Visitante> filtrarVisitasIntervalo(LocalDate fInicio, LocalDate fFinal) throws IOException, ClassNotFoundException{
        List<Visitante> listaVisitas = VisitantesData.leerVisitantes();
        List<Visitante> listaFiltrada = new ArrayList<>();
        
        for(Visitante v:listaVisitas){
            LocalDate fechaVisitante = v.getFecha();
            LocalTime horaVisitante = v.getHora();
            System.out.println(v.getNombre());
            System.out.println(v.getFecha());
            System.out.println("fechavisitante"+fechaVisitante);
            System.out.println(fInicio);
            System.out.println("fechafinal"+fFinal);
            
            if (fechaVisitante.isAfter(fInicio) && fechaVisitante.isBefore(fFinal)) {
                System.out.println("EN RANGO");;
            }
            
            if((fechaVisitante.isAfter(fInicio))&&(fechaVisitante.isBefore(fFinal))){
                listaFiltrada.add(v);
                System.out.println(v.getNombre());
            }
        
        }
        return listaFiltrada;

    }
    
    
    public ObservableList<Visita> crearListaVisita(List<Visitante> visitantes){
        ObservableList<Visita> visitasGeneradas = FXCollections.observableArrayList();
        String nombre;String cedula; String codigoAcceso;String fecha;String estado;
        
        for(Visitante v:visitantes){
            nombre = v.getNombre();
            cedula = v.getCedula();
            codigoAcceso = v.getCodigo();
            fecha = v.getFecha().toString();
            if(v.getValidezCodigo()){
                estado = "ACTIVO";
            }else{
                estado = "INACTIVO";
            }
            Visita visita = new Visita(nombre,cedula,codigoAcceso,fecha,estado);
            visitasGeneradas.add(visita);
            System.out.println(visita.getNombre());
            System.out.println(visita.getFecha());
            System.out.println(visita.getCodigoAcceso());
        }
        
        return visitasGeneradas;
    
        
    }
    
    public void mostrarTabla(ObservableList<Visita> visitaObservable){
        
        tvVisitas.setItems(visitaObservable);
        tcNombre.setCellValueFactory(new PropertyValueFactory<Visita, String>("nombre"));
        tcCedula.setCellValueFactory(new PropertyValueFactory<Visita, String>("cedula"));
        tcCodigo.setCellValueFactory(new PropertyValueFactory<Visita, String>("codigoAcceso"));
        tcFecha.setCellValueFactory(new PropertyValueFactory<Visita, String>("fecha"));
        tcEstado.setCellValueFactory(new PropertyValueFactory<Visita, String>("estado"));
        //tvVisitas.getColumns().addAll(tcNombre,tcCedula,tcCodigo,tcFecha,tcEstado);*/
       
        
        //Remove Row from TableView
        btnRemove.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent t) {
                if(tvVisitas.getSelectionModel().isEmpty()){
                    Alert al = new Alert(Alert.AlertType.ERROR);
                    al.setHeaderText("ERROR");
                    al.setTitle("REMOVE ERROR");
                    al.setContentText("Tiene que seleccionar un item de la lista");
                    al.showAndWait();
                }else{
                    Visita newVisita = tvVisitas.getSelectionModel().getSelectedItem();
                    if(newVisita.getEstado().equals("ACTIVO")){
                        visitaObservable.remove(tvVisitas.getSelectionModel().getSelectedItem());
                        try {
                            if(borrarVisita(newVisita)){
                                Alert al = new Alert(Alert.AlertType.INFORMATION);
                                al.setHeaderText("REMOVE");
                                al.setTitle("REMOVING");
                                al.setContentText("LA VISITA SE BORRO DE LA BASE DE DATOS");
                                al.showAndWait();
                            }else{
                                
                            }
                        } catch (IOException ex) {
                            ex.printStackTrace();
                        } catch (ClassNotFoundException ex) {
                            ex.printStackTrace();
                        }
                    }else{
                        Alert al = new Alert(Alert.AlertType.ERROR);
                        al.setHeaderText("ERROR");
                        al.setTitle("REMOVE ERROR");
                        al.setContentText("NO PUEDES BORRAR UNA VISITA QUE YA INGRESO");
                        al.showAndWait();
                    }
                }
                
            }
        });
        
        
        visitaObservable.addListener(new ListChangeListener() {
 
            @Override
            public void onChanged(ListChangeListener.Change change) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setHeaderText("SUCESS");
                alert.setContentText("LA FILA SE BORRO CON EXITO!");
            }
        });
    
    }
    
   class enviarClaveAcceso implements Runnable {

        @Override
        public void run() {
            try {
                Platform.runLater(() -> {
                    enviarCorreo(visitanteNuevo);
                });

                Thread.sleep(500);

            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }

        }

    }
   
   public boolean borrarVisita(Visita visitaBorrar) throws IOException, ClassNotFoundException{
       ArrayList<Visitante> visitantes= VisitantesData.leerVisitantes();
       int pos = 0;
       boolean e = false;
       for(Visitante v:visitantes){
           String nombre = visitaBorrar.getNombre();
           String cedula = visitaBorrar.getCedula();
           if(v.getNombre().toLowerCase().equals(nombre.toLowerCase())){
               if(v.getCedula().toLowerCase().equals(cedula.toLowerCase())){
                   e = true;
                   visitantes.remove(pos);
                   VisitantesData.escribirVisitantes(visitantes);
                   return e;
               }
           }
           pos+=1;
       }
       return false;
       
   }
    
  
   
   //CLASE VISITA PARA MOSTRAR EN TABLE VIEW
    public static class Visita {

        private final SimpleStringProperty nombre;
        private final SimpleStringProperty cedula;
        private final SimpleStringProperty codigoAcceso;
        private final SimpleStringProperty fecha;
        private final SimpleStringProperty estado;

        private Visita(String strNombre, String strCedula, String strCodigoAcceso, String strFecha,String strEstado) {
            this.nombre = new SimpleStringProperty(strNombre);
            this.cedula = new SimpleStringProperty(strCedula);
            this.codigoAcceso = new SimpleStringProperty(strCodigoAcceso);
            this.fecha = new SimpleStringProperty(strFecha);
            this.estado = new SimpleStringProperty(strEstado);

        }

        public String getNombre() {
            return nombre.get();
        }

        public String getCedula() {
            return cedula.get();
        }

        public String getCodigoAcceso() {
            return codigoAcceso.get();
        }

        public String getFecha() {
            return fecha.get();
        }
        
        public String getEstado() {
            return estado.get();
        }

        public void setNombre(String strNombre) {
            nombre.set(strNombre);
        }

        public void setCedula(String strCedula) {
            cedula.set(strCedula);
        }

        public void setCodigoAcceso(String strCodigoAcceso) {
            codigoAcceso.set(strCodigoAcceso);
        }

        public void setFecha(String strFecha) {
            fecha.set(strFecha);
        }
        
        public void setEstado(String strEstado) {
            fecha.set(strEstado);
        }
    }

   
   
   
   
   
   
    
}//FIN DE LA CLASE
