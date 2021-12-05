/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.proyecto2_grupo2;

import com.mycompany.proyecto2_grupo2.data.EntradaResidenteData;
import static com.mycompany.proyecto2_grupo2.data.EntradaResidenteData.leerEntradasResidentes;
import com.mycompany.proyecto2_grupo2.data.EntradaVisitanteData;
import com.mycompany.proyecto2_grupo2.modelo.EntradaUsuario;
import java.io.IOException;
import java.net.URL;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

/**
 * FXML Controller class
 *
 * @author andya
 */
public class VistaReportesController implements Initializable {

    @FXML
    private MenuItem btnMapa;
    @FXML
    private Pane paneGrafico1;
    @FXML
    private Pane paneGrafico2;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            cargarGraficos();
        } catch (IOException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
    }    

    @FXML
    private void mostrarMapa(ActionEvent event) {
         try{
                            FXMLLoader loader= new FXMLLoader(App.class.getResource("VistaAdministrador.fxml"));
            
                            Parent root = loader.load();
                            VistaAdministradorController ic = loader.<VistaAdministradorController>getController();
                            System.out.println(ic);
                            App.scene.setRoot(root);
            
                        }catch(IOException ex){
                        System.out.println("no se ha podido cargar la vista");
                        }
    }
    
    
    private void cargarGraficos() throws IOException, ClassNotFoundException{
    graficoIngresoHora();
    graficoResidentesVsVisitantes();
    }
    
    private void graficoIngresoHora() throws IOException, ClassNotFoundException{
        int num;
        CategoryAxis x = new CategoryAxis();
        x.setLabel("HORAS");  
        NumberAxis y = new NumberAxis();
        y.setLabel("INGRESOS");
        
        BarChart bc = new BarChart(x, y);
        bc.setTitle("INGRESO POR HORAS DE RESIDENTES Y VISITANTES");
        
        XYChart.Series rs = new XYChart.Series();
        rs.setName("RESIDENTES");
               
        num = buscarEntradasPorHoraResidentes("00");
        rs.getData().add(new XYChart.Data("00-01",num));
        num = buscarEntradasPorHoraResidentes("01");
        rs.getData().add(new XYChart.Data("01:02",num));
        num = buscarEntradasPorHoraResidentes("02");
        rs.getData().add(new XYChart.Data("02-03",num));
        num = buscarEntradasPorHoraResidentes("03");
        rs.getData().add(new XYChart.Data("03-04",num));
        num = buscarEntradasPorHoraResidentes("04");
        rs.getData().add(new XYChart.Data("04-05",num));
        num = buscarEntradasPorHoraResidentes("05");
        rs.getData().add(new XYChart.Data("05-06",num));
        num = buscarEntradasPorHoraResidentes("06");
        rs.getData().add(new XYChart.Data("06-07",num));
        num = buscarEntradasPorHoraResidentes("07");
        rs.getData().add(new XYChart.Data("07-08",num));
        num = buscarEntradasPorHoraResidentes("08");
        rs.getData().add(new XYChart.Data("08-09",num));
        num = buscarEntradasPorHoraResidentes("09");
        rs.getData().add(new XYChart.Data("09-10",num));
        num = buscarEntradasPorHoraResidentes("10");
        rs.getData().add(new XYChart.Data("10-11",num));
        num = buscarEntradasPorHoraResidentes("11");
        rs.getData().add(new XYChart.Data("11-12",num));
        num = buscarEntradasPorHoraResidentes("12");
        rs.getData().add(new XYChart.Data("12-13",num));
        num = buscarEntradasPorHoraResidentes("13");
        rs.getData().add(new XYChart.Data("13-14",num));
        num = buscarEntradasPorHoraResidentes("14");
        rs.getData().add(new XYChart.Data("14-15",num));
        num = buscarEntradasPorHoraResidentes("15");
        rs.getData().add(new XYChart.Data("15-16",num));
        num = buscarEntradasPorHoraResidentes("16");
        rs.getData().add(new XYChart.Data("16-17",num));
        num = buscarEntradasPorHoraResidentes("17");
        rs.getData().add(new XYChart.Data("17-18",num));
        num = buscarEntradasPorHoraResidentes("18");
        rs.getData().add(new XYChart.Data("18-19",num));
        num = buscarEntradasPorHoraResidentes("19");
        rs.getData().add(new XYChart.Data("19-20",num));
        num = buscarEntradasPorHoraResidentes("20");
        rs.getData().add(new XYChart.Data("20-21",num));
        num = buscarEntradasPorHoraResidentes("21");
        rs.getData().add(new XYChart.Data("21-22",num));
        num = buscarEntradasPorHoraResidentes("22");
        rs.getData().add(new XYChart.Data("22-23",num));
        num = buscarEntradasPorHoraResidentes("23");
        rs.getData().add(new XYChart.Data("23-00",num));
       
        
        XYChart.Series vs = new XYChart.Series();
        vs.setName("VISITANTES");
        
        num = buscarEntradasPorHoraVisitantes("00");
        vs.getData().add(new XYChart.Data("00-01",num));
        num = buscarEntradasPorHoraVisitantes("01");
        vs.getData().add(new XYChart.Data("01:02",num));
        num = buscarEntradasPorHoraVisitantes("02");
        vs.getData().add(new XYChart.Data("02-03",num));
        num = buscarEntradasPorHoraVisitantes("03");
        vs.getData().add(new XYChart.Data("03-04",num));
        num = buscarEntradasPorHoraVisitantes("04");
        vs.getData().add(new XYChart.Data("04-05",num));
        num = buscarEntradasPorHoraVisitantes("05");
        vs.getData().add(new XYChart.Data("05-06",num));
        num = buscarEntradasPorHoraVisitantes("06");
        vs.getData().add(new XYChart.Data("06-07",num));
        num = buscarEntradasPorHoraVisitantes("07");
        vs.getData().add(new XYChart.Data("07-08",num));
        num = buscarEntradasPorHoraVisitantes("08");
        vs.getData().add(new XYChart.Data("08-09",num));
        num = buscarEntradasPorHoraVisitantes("09");
        vs.getData().add(new XYChart.Data("09-10",num));
        num = buscarEntradasPorHoraVisitantes("10");
        vs.getData().add(new XYChart.Data("10-11",num));
        num = buscarEntradasPorHoraVisitantes("11");
        vs.getData().add(new XYChart.Data("11-12",num));
        num = buscarEntradasPorHoraVisitantes("12");
        vs.getData().add(new XYChart.Data("12-13",num));
        num = buscarEntradasPorHoraVisitantes("13");
        vs.getData().add(new XYChart.Data("13-14",num));
        num = buscarEntradasPorHoraVisitantes("14");
        vs.getData().add(new XYChart.Data("14-15",num));
        num = buscarEntradasPorHoraVisitantes("15");
        vs.getData().add(new XYChart.Data("15-16",num));
        num = buscarEntradasPorHoraVisitantes("16");
        vs.getData().add(new XYChart.Data("16-17",num));
        num = buscarEntradasPorHoraVisitantes("17");
        vs.getData().add(new XYChart.Data("17-18",num));
        num = buscarEntradasPorHoraVisitantes("18");
        vs.getData().add(new XYChart.Data("18-19",num));
        num = buscarEntradasPorHoraVisitantes("19");
        vs.getData().add(new XYChart.Data("19-20",num));
        num = buscarEntradasPorHoraVisitantes("20");
        vs.getData().add(new XYChart.Data("20-21",num));
        num = buscarEntradasPorHoraVisitantes("21");
        vs.getData().add(new XYChart.Data("21-22",num));
        num = buscarEntradasPorHoraVisitantes("22");
        vs.getData().add(new XYChart.Data("22-23",num));
        num = buscarEntradasPorHoraVisitantes("23");
        vs.getData().add(new XYChart.Data("23-00",num));
       
        
        bc.setPrefWidth(651);
        bc.setPrefHeight(300);
        
        bc.getData().addAll(rs,vs);
        paneGrafico1.getChildren().addAll(bc);

    }
    
    private void graficoResidentesVsVisitantes() throws IOException, ClassNotFoundException{
        int num;
        final CategoryAxis xAxis = new CategoryAxis();
        final NumberAxis yAxis = new NumberAxis();
         xAxis.setLabel("HORAS");
        final LineChart<String,Number> lineChart = 
                new LineChart<String,Number>(xAxis,yAxis);
       
        lineChart.setTitle("MONITOREO DE INGRESOS RESIDENTES vs VISITANTES");
                          
        XYChart.Series series1 = new XYChart.Series();
        series1.setName("RESIDENTES");
        
        /*series1.getData().add(new XYChart.Data("1", 23));
        series1.getData().add(new XYChart.Data("2", 14));
        series1.getData().add(new XYChart.Data("3", 15));
        series1.getData().add(new XYChart.Data("4", 24));
        series1.getData().add(new XYChart.Data("5", 34));
        series1.getData().add(new XYChart.Data("6", 36));
        series1.getData().add(new XYChart.Data("7", 22));
        series1.getData().add(new XYChart.Data("8", 25));
        series1.getData().add(new XYChart.Data("9", 13));
        series1.getData().add(new XYChart.Data("10", 17));
        series1.getData().add(new XYChart.Data("11", 29));
        series1.getData().add(new XYChart.Data("12", 25));
        series1.getData().add(new XYChart.Data("13", 23));
        series1.getData().add(new XYChart.Data("14", 14));
        series1.getData().add(new XYChart.Data("15", 15));
        series1.getData().add(new XYChart.Data("16", 24));
        series1.getData().add(new XYChart.Data("17", 34));
        series1.getData().add(new XYChart.Data("18", 36));
        series1.getData().add(new XYChart.Data("19", 22));
        series1.getData().add(new XYChart.Data("20", 15));
        series1.getData().add(new XYChart.Data("21", 13));
        series1.getData().add(new XYChart.Data("22", 17));
        series1.getData().add(new XYChart.Data("23", 29));*/
        
        num = buscarEntradasPorHoraResidentes("00");
        series1.getData().add(new XYChart.Data("0",num));
        num = buscarEntradasPorHoraResidentes("01");
        series1.getData().add(new XYChart.Data("1",num));
        num = buscarEntradasPorHoraResidentes("02");
        series1.getData().add(new XYChart.Data("2",num));
        num = buscarEntradasPorHoraResidentes("03");
        series1.getData().add(new XYChart.Data("3",num));
        num = buscarEntradasPorHoraResidentes("04");
        series1.getData().add(new XYChart.Data("4",num));
        num = buscarEntradasPorHoraResidentes("05");
        series1.getData().add(new XYChart.Data("5",num));
        num = buscarEntradasPorHoraResidentes("06");
        series1.getData().add(new XYChart.Data("6",num));
        num = buscarEntradasPorHoraResidentes("07");
        series1.getData().add(new XYChart.Data("7",num));
        num = buscarEntradasPorHoraResidentes("08");
        series1.getData().add(new XYChart.Data("8", num));
        num = buscarEntradasPorHoraResidentes("09");
        series1.getData().add(new XYChart.Data("9",num));
        num = buscarEntradasPorHoraResidentes("10");
        series1.getData().add(new XYChart.Data("10",num));
        num = buscarEntradasPorHoraResidentes("11");
        series1.getData().add(new XYChart.Data("11",num));
        num = buscarEntradasPorHoraResidentes("12");
        series1.getData().add(new XYChart.Data("12",num));
        num = buscarEntradasPorHoraResidentes("13");
        series1.getData().add(new XYChart.Data("13",num));
        num = buscarEntradasPorHoraResidentes("14");
        series1.getData().add(new XYChart.Data("14",num));
        num = buscarEntradasPorHoraResidentes("15");
        series1.getData().add(new XYChart.Data("15",num));
        num = buscarEntradasPorHoraResidentes("16");
        series1.getData().add(new XYChart.Data("16",num));
        num = buscarEntradasPorHoraResidentes("17");
        series1.getData().add(new XYChart.Data("17",num));
        num = buscarEntradasPorHoraResidentes("18");
        series1.getData().add(new XYChart.Data("18",num));
        num = buscarEntradasPorHoraResidentes("19");
        series1.getData().add(new XYChart.Data("19",num));
        num = buscarEntradasPorHoraResidentes("20");
        series1.getData().add(new XYChart.Data("20",num));
        num = buscarEntradasPorHoraResidentes("21");
        series1.getData().add(new XYChart.Data("21",num));
        num = buscarEntradasPorHoraResidentes("22");
        series1.getData().add(new XYChart.Data("22",num));
        num = buscarEntradasPorHoraResidentes("23");
        series1.getData().add(new XYChart.Data("23",num));
        
        
        
        
        
        XYChart.Series series2 = new XYChart.Series();
        
        /*series2.getData().add(new XYChart.Data("1", 1));
        series2.getData().add(new XYChart.Data("2", 10));
        series2.getData().add(new XYChart.Data("3", 1));
        series2.getData().add(new XYChart.Data("4", 24));
        series2.getData().add(new XYChart.Data("5", 31));
        series2.getData().add(new XYChart.Data("6", 10));
        series2.getData().add(new XYChart.Data("7", 22));
        series2.getData().add(new XYChart.Data("8", 1));
        series2.getData().add(new XYChart.Data("9", 13));
        series2.getData().add(new XYChart.Data("10", 17));
        series2.getData().add(new XYChart.Data("11", 20));
        series2.getData().add(new XYChart.Data("12", 21));
        series2.getData().add(new XYChart.Data("13", 23));
        series2.getData().add(new XYChart.Data("14", 14));
        series2.getData().add(new XYChart.Data("15", 15));
        series2.getData().add(new XYChart.Data("16", 24));
        series2.getData().add(new XYChart.Data("17", 14));
        series2.getData().add(new XYChart.Data("18", 16));
        series2.getData().add(new XYChart.Data("19", 17));
        series2.getData().add(new XYChart.Data("20", 4));
        series2.getData().add(new XYChart.Data("21", 21));
        series2.getData().add(new XYChart.Data("22", 17));
        series2.getData().add(new XYChart.Data("23", 19));*/
        
        num = buscarEntradasPorHoraVisitantes("00");
        series2.getData().add(new XYChart.Data("0",num));
        num = buscarEntradasPorHoraVisitantes("01");
        series2.getData().add(new XYChart.Data("1",num));
        num = buscarEntradasPorHoraVisitantes("02");
        series2.getData().add(new XYChart.Data("2",num));
        num = buscarEntradasPorHoraVisitantes("03");
        series2.getData().add(new XYChart.Data("3",num));
        num = buscarEntradasPorHoraVisitantes("04");
        series2.getData().add(new XYChart.Data("4",num));
        num = buscarEntradasPorHoraVisitantes("05");
        series2.getData().add(new XYChart.Data("5",num));
        num = buscarEntradasPorHoraVisitantes("06");
        series2.getData().add(new XYChart.Data("6",num));
        num = buscarEntradasPorHoraVisitantes("07");
        series2.getData().add(new XYChart.Data("7",num));
        num = buscarEntradasPorHoraVisitantes("08");
        series2.getData().add(new XYChart.Data("8", num));
        num = buscarEntradasPorHoraVisitantes("09");
        series2.getData().add(new XYChart.Data("9",num));
        num = buscarEntradasPorHoraVisitantes("10");
        series2.getData().add(new XYChart.Data("10",num));
        num = buscarEntradasPorHoraVisitantes("11");
        series2.getData().add(new XYChart.Data("11",num));
        num = buscarEntradasPorHoraVisitantes("12");
        series2.getData().add(new XYChart.Data("12",num));
        num = buscarEntradasPorHoraVisitantes("13");
        series2.getData().add(new XYChart.Data("13",num));
        num = buscarEntradasPorHoraVisitantes("14");
        series2.getData().add(new XYChart.Data("14",num));
        num = buscarEntradasPorHoraVisitantes("15");
        series2.getData().add(new XYChart.Data("15",num));
        num = buscarEntradasPorHoraVisitantes("16");
        series2.getData().add(new XYChart.Data("16",num));
        num = buscarEntradasPorHoraVisitantes("17");
        series2.getData().add(new XYChart.Data("17",num));
        num = buscarEntradasPorHoraVisitantes("18");
        series2.getData().add(new XYChart.Data("18",num));
        num = buscarEntradasPorHoraVisitantes("19");
        series2.getData().add(new XYChart.Data("19",num));
        num = buscarEntradasPorHoraVisitantes("20");
        series2.getData().add(new XYChart.Data("20",num));
        num = buscarEntradasPorHoraVisitantes("21");
        series2.getData().add(new XYChart.Data("21",num));
        num = buscarEntradasPorHoraVisitantes("22");
        series2.getData().add(new XYChart.Data("22",num));
        num = buscarEntradasPorHoraVisitantes("23");
        series2.getData().add(new XYChart.Data("23",num));

        
        Scene scene  = new Scene(lineChart,800,600);       
        lineChart.getData().addAll(series1, series2);
        lineChart.setPrefWidth(651);
        lineChart.setPrefHeight(300);
        paneGrafico2.getChildren().add(lineChart);
    }
    
    public int buscarEntradasPorHoraResidentes(String hora) throws IOException, ClassNotFoundException{
        int entradas = 0;
        ArrayList<EntradaUsuario> entradasResidentes = EntradaResidenteData.leerEntradasResidentes();
        for(EntradaUsuario eU: entradasResidentes){
            LocalTime h = eU.getHentrada();
            String horaEncontrada = h.toString();
            System.out.println(horaEncontrada);
            System.out.println("HORA A COMPARAR="+hora);
            String[] a = horaEncontrada.split(":");
            System.out.println(a[0]);System.out.println(a[1]);
            if(a[0].equals(hora)){
                entradas +=1;
            }
        }
        
        return entradas;
    }
    
    
    public int buscarEntradasPorHoraVisitantes(String hora) throws IOException, ClassNotFoundException {
        int entradas = 0;
        ArrayList<EntradaUsuario> entradasVisitantes = EntradaVisitanteData.leerEntradasVisitantes();
        for (EntradaUsuario eU : entradasVisitantes) {
            LocalTime h = eU.getHentrada();
            String horaEncontrada = h.toString();
            System.out.println(horaEncontrada);
            System.out.println("HORA A COMPARAR="+hora);
            String[] a = horaEncontrada.split(":");
            System.out.println(a[0]);System.out.println(a[1]);
            if (a[0].equals(hora)) {
                entradas += 1;
            }
        }

        return entradas;
    }
    
    
    
}
