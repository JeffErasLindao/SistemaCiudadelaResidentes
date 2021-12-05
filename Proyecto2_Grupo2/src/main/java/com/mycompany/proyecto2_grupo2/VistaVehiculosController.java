/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.proyecto2_grupo2;

import com.mycompany.proyecto2_grupo2.data.VehiculosData;
import com.mycompany.proyecto2_grupo2.modelo.Residente;
import com.mycompany.proyecto2_grupo2.modelo.Vehiculo;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author andya
 */
public class VistaVehiculosController implements Initializable {

    @FXML
    private TextField txtMatricula;
    @FXML
    private Button btnRegistrarVehiculo;
    
    private static Residente residente;
    @FXML
    private Menu btnRegistroVehiculos;
    @FXML
    private MenuItem btnDatos;
    @FXML
    private MenuItem btnVisitas;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
    }    

    public void setResidente(Residente residente){
        this.residente=residente;
    }

    public Residente getResidente(){
        return residente;
    }
    
    
    @FXML
    private void RegistrarnuevoVehiculo(MouseEvent event) throws IOException, ClassNotFoundException {
        //ArrayList<Vehiculo> vehiculos = new ArrayList<Vehiculo>();
        
        if (txtMatricula.getText().trim().isEmpty()) {
            Alert al = new Alert(Alert.AlertType.ERROR);
            al.setHeaderText("VEHICULO ERROR");
            al.setTitle("Error al registrar");
            al.setContentText("CAMPO VACIO DEBE INGRESAR DATOS...!");
            al.showAndWait();
            txtMatricula.clear();
        } else {
            Vehiculo v = new Vehiculo(txtMatricula.getText(), residente);
            if (validarVehiculo(v)) {
                ArrayList<Vehiculo> vehiculos = VehiculosData.leerVehiculos();
                vehiculos.add(v);
                VehiculosData.escribirVehiculos(vehiculos);
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setHeaderText("SUCESSFULL");
                alert.setContentText("SU VEHICULO SE REGISTRO CORRECTAMENTE..!");
                alert.showAndWait();
                txtMatricula.clear();
            } else {
                Alert al = new Alert(Alert.AlertType.ERROR);
                al.setHeaderText("VEHICULO ERROR");
                al.setTitle("Error al registrar");
                al.setContentText("La matrícula ingresada ya existe");
                al.showAndWait();
                txtMatricula.clear();
            }

        }
        

        
        
    }

    @FXML
    private void mostrarDatos(ActionEvent event) {
         try{
                        FXMLLoader loader= new FXMLLoader(App.class.getResource("VistaResidente.fxml"));
            
                        Parent root = loader.load();
                        VistaResidenteController ic = loader.<VistaResidenteController>getController();
                        System.out.println(ic);
                        //ic.setResidente(VistaVehiculosController.);
                        ic.setResidente(VistaInicioSesionController.getResidenteEncontrado());
                        App.scene.setRoot(root);
            
                        }catch(IOException ex){
                        System.out.println("no se ha podido cargar la vista");
                        }
    }

    @FXML
    private void MostrarVisitas(ActionEvent event) {
        try{
                        FXMLLoader loader= new FXMLLoader(App.class.getResource("VistaVisitas.fxml"));
            
                        Parent root = loader.load();
                        VistaVisitasController vc = loader.<VistaVisitasController>getController();
                        System.out.println(vc);
                        vc.setResidente(VistaInicioSesionController.getResidenteEncontrado());
                        App.scene.setRoot(root);
                        
                    }catch(IOException ex){
                        System.out.println("no se ha podido cargar la vista");
                    }
    }
    
    
    private boolean validarVehiculo(Vehiculo vNuevo) throws IOException, ClassNotFoundException{
        ArrayList<Vehiculo> vehiculos = VehiculosData.leerVehiculos();
        
        for(Vehiculo v:vehiculos){
            if(v.getMatricula().toLowerCase().equals(vNuevo.getMatricula().toLowerCase())){
                return false;
            }
        }
        return true;
    }
}
