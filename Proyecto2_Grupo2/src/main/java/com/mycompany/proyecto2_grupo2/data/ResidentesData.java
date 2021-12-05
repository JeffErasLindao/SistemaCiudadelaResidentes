/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.proyecto2_grupo2.data;

import static com.mycompany.proyecto2_grupo2.data.CasasData.escribirCasas;
import static com.mycompany.proyecto2_grupo2.data.CasasData.ruta;
import com.mycompany.proyecto2_grupo2.modelo.Casa;
import com.mycompany.proyecto2_grupo2.modelo.Residente;
import com.mycompany.proyecto2_grupo2.modelo.Ubicacion;
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
public class ResidentesData {
    static String ruta = "residentes.dat";
     public static void escribirResidentes(ArrayList<Residente> residentes){
        try (ObjectOutputStream objOutputStream =
            new ObjectOutputStream(new FileOutputStream(ruta))){
            objOutputStream.writeObject(residentes);
            System.out.println("... written to residentes.dat.");
        }catch(IOException ex){
            ex.getMessage();
        }
    }
     
    public static ArrayList<Residente> leerResidentes() 
        throws IOException, ClassNotFoundException{
        ArrayList<Residente> residentes = null;
        try(ObjectInputStream objInputStream 
                = new ObjectInputStream(new FileInputStream(ruta))) {
          residentes = (ArrayList<Residente>)objInputStream.readObject();
        }
        return residentes;
    }
    
}
