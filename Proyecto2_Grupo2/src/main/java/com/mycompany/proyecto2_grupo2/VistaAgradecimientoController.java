/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.proyecto2_grupo2;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

/**
 * FXML Controller class
 *
 * @author jeras
 */
public class VistaAgradecimientoController implements Initializable {

    @FXML
    private Pane paneAgradecimiento;
    @FXML
    private AnchorPane paneFondo;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        // TODO
        Image image1 = new Image(getClass().getResourceAsStream("saludo.png"));
        ImageView imageView1 = new ImageView(image1);
        imageView1.setX(66);
        imageView1.setY(250);
        paneFondo.getChildren().add(imageView1);
        
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


    
}
