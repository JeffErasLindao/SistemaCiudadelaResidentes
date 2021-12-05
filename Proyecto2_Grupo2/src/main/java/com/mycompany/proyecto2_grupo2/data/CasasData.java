/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.proyecto2_grupo2.data;

import com.mycompany.proyecto2_grupo2.modelo.Casa;
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
public class CasasData {
    static String ruta = "casas.dat";
     public static void escribirCasas(ArrayList<Casa> casas){
        try (ObjectOutputStream objOutputStream =
            new ObjectOutputStream(new FileOutputStream(ruta))){
            objOutputStream.writeObject(casas);
            System.out.println("... written to casas.dat.");
        }catch(IOException ex){
            ex.getMessage();
            System.out.println("... no se pudo escribir en casas.dat.");
        }
    }
     
     public static ArrayList<Casa> leerCasas() 
        throws IOException, ClassNotFoundException{
        ArrayList<Casa> casas = null;
        try(ObjectInputStream objInputStream 
                = new ObjectInputStream(new FileInputStream(ruta))) {
          casas = (ArrayList<Casa>)objInputStream.readObject();
        }
        return casas;
    }
    
     
}
