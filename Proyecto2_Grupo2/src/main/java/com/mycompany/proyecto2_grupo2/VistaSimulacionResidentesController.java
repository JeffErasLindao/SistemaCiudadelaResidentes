/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.proyecto2_grupo2;

import static com.mycompany.proyecto2_grupo2.data.EntradaResidenteData.escribirEntradasResidentes;
import static com.mycompany.proyecto2_grupo2.data.EntradaVisitanteData.escribirEntradasVisitantes;
import com.mycompany.proyecto2_grupo2.data.ResidentesData;
import com.mycompany.proyecto2_grupo2.data.VehiculosData;
import com.mycompany.proyecto2_grupo2.modelo.EntradaUsuario;
import com.mycompany.proyecto2_grupo2.modelo.Residente;
import com.mycompany.proyecto2_grupo2.modelo.Vehiculo;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

/**
 * FXML Controller class
 *
 * @author jeras
 */
public class VistaSimulacionResidentesController implements Initializable {

    @FXML
    private Tab tabVehiculo;
    @FXML
    private Pane paneVehiculo;
    @FXML
    private TextField txtMatricula;
    @FXML
    private Tab tabPeaton;
    @FXML
    private Pane panePeaton;
    @FXML
    private Button btn_1;
    @FXML
    private Button btn_2;
    @FXML
    private Button btn_3;
    @FXML
    private Button btn_4;
    @FXML
    private Button btn_5;
    @FXML
    private Button btn_6;
    @FXML
    private Button btn_7;
    @FXML
    private Button btn_8;
    @FXML
    private Button btn_9;
    @FXML
    private Button btn_0;
    @FXML
    private Label lblPinPantalla;
    @FXML
    private Button btnTerminarSimulacion;
    @FXML
    private Button btnIngresar;
    @FXML
    private TextField txtPinPantalla;
    @FXML
    private Button btnScanearMatricula;
    @FXML
    private Button btnClear;
    
    private boolean digito = false;
    
    private Residente residenteIngresado;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
    
    @FXML
    public void scanearPin(MouseEvent event) throws IOException, ClassNotFoundException{
        String pin =  lblPinPantalla.getText();
        if(buscarPin(pin)){
            mostrarIngresoPeaton();
        }else{
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("Authentication error");
            alert.setTitle("PIN ERROR..!");
            alert.setContentText("El PIN ingresado es INCORRECTO, porfavor vuelva a ingresar correctamente");
            alert.showAndWait();
            lblPinPantalla.setText("");
            txtPinPantalla.clear();
        
        }
        
    }
    
    
    public void mostrarIngresoPeaton(){
        //IMPLEMENTAR ANIMACION DE INGRESO DE IUN PEATON
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText("SUCESS");
        alert.setContentText("INGRESASTE CON EXITO A LA CIUDADELA!");
        alert.showAndWait();
        
        ArrayList<EntradaUsuario> entradasResidentes = new ArrayList<EntradaUsuario>();
        LocalDate fechaActual = LocalDate.now();
        LocalTime horaActual = LocalTime.now();
        entradasResidentes.add(new EntradaUsuario(residenteIngresado.getNombre(),fechaActual,horaActual));     
        escribirEntradasResidentes(entradasResidentes);
        
        try {
            FXMLLoader loader = new FXMLLoader(App.class.getResource("VistaAgradecimiento.fxml"));
            Parent root = loader.load();
            VistaAgradecimientoController vi = loader.<VistaAgradecimientoController>getController();
            System.out.println(vi);
            //vsrc.setResidente(VistaResidenteController.getResidente());
            App.scene.setRoot(root);

        } catch (IOException ex) {
            System.out.println("no se ha podido cargar la vista");
        }
    
    }
    
    public void mostrarIngresoVehiculo(){
        //IMPLEMENTAR ANIMACION DE INGRESO DE UN VEHICULO
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText("SUCESS");
        alert.setContentText("TU VEHICULO INGRESO CON EXITO A LA CIUDADELA!");
        try {
            FXMLLoader loader = new FXMLLoader(App.class.getResource("VistaAgradecimiento.fxml"));
            Parent root = loader.load();
            VistaAgradecimientoController vi = loader.<VistaAgradecimientoController>getController();
            System.out.println(vi);
            //vsrc.setResidente(VistaResidenteController.getResidente());
            App.scene.setRoot(root);

        } catch (IOException ex) {
            System.out.println("no se ha podido cargar la vista");
        }
        
    }
    
    public boolean buscarPin(String pin) throws IOException, ClassNotFoundException{
        boolean encontrado = false;
        List<Residente> residentes = ResidentesData.leerResidentes();
        
        for(Residente r:residentes){
            System.out.println(r.getPin());
            System.out.println(pin);
            if(r.getPin().equals(pin)){
                encontrado = true;
                residenteIngresado = r;
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                        alert.setHeaderText("SUCESS");
                        alert.setContentText("EL PIN ES VALIDO");
                        alert.showAndWait();
                        return encontrado;
            }
        }
        
        return encontrado;
    }
    
    @FXML
    public void scanearMatricula(MouseEvent event) throws IOException, ClassNotFoundException{
        
        if(buscarMatricula(txtMatricula.getText())){
            mostrarIngresoVehiculo();
        }else{
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("Authentication error");
            alert.setTitle("MATRICULA ERROR..!");
            alert.setContentText("No existe ningun auto con la MATRICULA INGRESADA, porfavor vuelva a ingresar correctamente");
            alert.showAndWait();
            txtMatricula.clear();
        }
    }
    
    public boolean buscarMatricula(String cadena) throws IOException, ClassNotFoundException{
        boolean encontrado = false;
        
        List<Vehiculo> vehiculos = VehiculosData.leerVehiculos();
        
        for(Vehiculo v:vehiculos){
        
            if(v.getMatricula().toLowerCase().equals(cadena.toLowerCase())){
                encontrado = true;
                return encontrado;
            }
        }
        
        //IMPLEMENTAR EL METODO BUSCAR MATRICULA DE LOS VEHICULOS DE LA BASE DE DATOS
        // vehiculos.dat
        
        return encontrado;
    }
    
    
    //MANEJO DE EVENTOS DE LOS BOTONES
    public void click_cero(ActionEvent event){
        digitoPantalla("0");
    }
    
    public void click_uno(ActionEvent event) {
        digitoPantalla("1");
    }

    public void click_dos(ActionEvent event) {
        digitoPantalla("2");
    }

    public void click_tres(ActionEvent event) {
        digitoPantalla("3");
    }

    public void click_cuatro(ActionEvent event) {
        digitoPantalla("4");
    }

    public void click_cinco(ActionEvent event) {
        digitoPantalla("5");
    }

    public void click_seis(ActionEvent event) {
        digitoPantalla("6");
    }

    public void click_siete(ActionEvent event) {
        digitoPantalla("7");
    }

    public void click_ocho(ActionEvent event) {
        digitoPantalla("8");
    }

    public void click_nueve(ActionEvent event) {
        digitoPantalla("9");
    }
    
   public void click_Clear(ActionEvent event) {
       lblPinPantalla.setText("");
    }
    
    public void digitoPantalla(String numero){
        String valorActual;
            if(!digito ){
                lblPinPantalla.setText("");
            }
        valorActual = lblPinPantalla.getText();
        lblPinPantalla.setText(valorActual+numero);
        
        digito = true;
    }


    

    
    
    @FXML
    public void terminarSimulacion(ActionEvent event){
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
    
}
