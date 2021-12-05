/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.proyecto2_grupo2.data;

import com.mycompany.proyecto2_grupo2.modelo.Casa;
import com.mycompany.proyecto2_grupo2.modelo.EntradaUsuario;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/**
 *
 * @author jeras
 */
public class EntradaResidenteData {
     static String ruta = "entradasresidentes.dat";
     
     public static void escribirEntradasResidentes(ArrayList<EntradaUsuario> entradaResidente){
        try (ObjectOutputStream objOutputStream =
            new ObjectOutputStream(new FileOutputStream(ruta))){
            objOutputStream.writeObject(entradaResidente);
            System.out.println("... written to entradasresidentes.dat.");
        }catch(IOException ex){
            ex.getMessage();
            System.out.println("... no se pudo escribir en casas.dat.");
        }
    }
     
     public static ArrayList<EntradaUsuario> leerEntradasResidentes() 
        throws IOException, ClassNotFoundException{
        ArrayList<EntradaUsuario> entradasResidentes = null;
        try(ObjectInputStream objInputStream 
                = new ObjectInputStream(new FileInputStream(ruta))) {
          entradasResidentes = (ArrayList<EntradaUsuario>)objInputStream.readObject();
        }
        return entradasResidentes;
    }
    
}
