/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.proyecto2_grupo2.data;

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
public class EntradaVisitanteData {
     static String ruta = "entradasvisitantes.dat";
     public static void escribirEntradasVisitantes(ArrayList<EntradaUsuario> entradaVisitante){
        try (ObjectOutputStream objOutputStream =
            new ObjectOutputStream(new FileOutputStream(ruta))){
            objOutputStream.writeObject(entradaVisitante);
            System.out.println("... written to entradasvisitantes.dat.");
        }catch(IOException ex){
            ex.getMessage();
            System.out.println("... no se pudo escribir en entradasvisitantes.dat.");
        }
    }
     
     public static ArrayList<EntradaUsuario> leerEntradasVisitantes() 
        throws IOException, ClassNotFoundException{
        ArrayList<EntradaUsuario> entradasVisitantes = null;
        try(ObjectInputStream objInputStream 
                = new ObjectInputStream(new FileInputStream(ruta))) {
          entradasVisitantes = (ArrayList<EntradaUsuario>)objInputStream.readObject();
        }
        return entradasVisitantes;
    }
}
