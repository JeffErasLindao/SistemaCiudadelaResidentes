/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.proyecto2_grupo2;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author andya
 */
public class VistaInicioController implements Initializable {

    @FXML
    private Button btnIniciosesion;
    @FXML
    private Button btnSimulacion;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void IniciarSesion(MouseEvent event) {
        try{
            FXMLLoader loader= new FXMLLoader(App.class.getResource("VistaInicioSesion.fxml"));
            
            Parent root = loader.load();
            VistaInicioSesionController ic = loader.<VistaInicioSesionController>getController();
            System.out.println(ic);
            App.scene.setRoot(root);
            
        }catch(IOException ex){
            System.out.println("no se ha podido cargar la vista");
        }
    }

    @FXML
    private void Simular(MouseEvent event) {
        try{
            FXMLLoader loader= new FXMLLoader(App.class.getResource("VistaInicioSimulacion.fxml"));
            
            Parent root = loader.load();
            VistaInicioSimulacionController vis = loader.<VistaInicioSimulacionController>getController();
            System.out.println(vis);
            App.scene.setRoot(root);
        }catch(IOException ex){
            System.out.println("no se ha podido cargar la vista");
        }
    }
}
