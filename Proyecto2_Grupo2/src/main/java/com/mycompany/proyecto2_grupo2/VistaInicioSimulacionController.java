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
public class VistaInicioSimulacionController implements Initializable {

    @FXML
    private Button btnResidentes;
    @FXML
    private Button btnVisitantes;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    public void irSimuResidentes(ActionEvent event){
        try {
            FXMLLoader loader = new FXMLLoader(App.class.getResource("VistaSimulacionResidentes.fxml"));
            Parent root = loader.load();
            VistaSimulacionResidentesController vsrc = loader.<VistaSimulacionResidentesController>getController();
            System.out.println(vsrc);
            //vsrc.setResidente(VistaResidenteController.getResidente());
            App.scene.setRoot(root);

        } catch (IOException ex) {
            System.out.println("no se ha podido cargar la vista");
        }
    
    }
    
    @FXML
    public void irSimuVisitantes(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(App.class.getResource("VistaSimulacionVisitantes.fxml"));
            Parent root = loader.load();
            VistaSimulacionVisitantesController vsvc = loader.<VistaSimulacionVisitantesController>getController();
            System.out.println(vsvc);
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
