/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.proyecto2_grupo2;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;

/**
 * FXML Controller class
 *
 * @author jeras
 */
public class VistaSimulacionVisitantesController implements Initializable {

    @FXML
    private Button btnConCodigo;
    @FXML
    private Button btnSinCodigo;
    @FXML
    private Button btnTerminarSimulacion;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    
    @FXML
    public void irConCodigo(ActionEvent event){
        try {
            FXMLLoader loader = new FXMLLoader(App.class.getResource("VistaSimulacionVisitanteConCodigo.fxml"));
            Parent root = loader.load();
            VistaSimulacionVisitanteConCodigoController vsvcc = loader.<VistaSimulacionVisitanteConCodigoController>getController();
            System.out.println(vsvcc);
            //vsrc.setResidente(VistaResidenteController.getResidente());
            App.scene.setRoot(root);

        } catch (IOException ex) {
            System.out.println("no se ha podido cargar la vista");
        }
    
    }
    
    @FXML
    public void irSinCodigo(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(App.class.getResource("VistaSimulacionVisitanteSinCodigo.fxml"));
            Parent root = loader.load();
            VistaSimulacionVisitanteSinCodigoController vsvsc = loader.<VistaSimulacionVisitanteSinCodigoController>getController();
            System.out.println(vsvsc);
            //vsrc.setResidente(VistaResidenteController.getResidente());
            App.scene.setRoot(root);

        } catch (IOException ex) {
            System.out.println("no se ha podido cargar la vista");
        }
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
