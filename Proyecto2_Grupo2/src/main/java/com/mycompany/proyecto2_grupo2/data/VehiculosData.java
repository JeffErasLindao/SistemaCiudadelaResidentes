/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.proyecto2_grupo2.data;

import com.mycompany.proyecto2_grupo2.modelo.Residente;
import com.mycompany.proyecto2_grupo2.modelo.Vehiculo;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/**
 *
 * @author andya
 */
public class VehiculosData {
    static String ruta = "vehiculos.dat";
     public static void escribirVehiculos(ArrayList<Vehiculo> vehiculos){
        try (ObjectOutputStream objOutputStream =
            new ObjectOutputStream(new FileOutputStream(ruta))){
            objOutputStream.writeObject(vehiculos);
            System.out.println("... written to vehiculos.dat.");
        }catch(IOException ex){
            ex.getMessage();
        }
    }
     
    public static ArrayList<Vehiculo> leerVehiculos() 
        throws IOException, ClassNotFoundException{
        ArrayList<Vehiculo> vehiculos = null;
        try(ObjectInputStream objInputStream 
                = new ObjectInputStream(new FileInputStream(ruta))) {
          vehiculos = (ArrayList<Vehiculo>)objInputStream.readObject();
        }
        return vehiculos;
    }
}
