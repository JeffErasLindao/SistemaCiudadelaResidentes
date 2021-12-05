/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.proyecto2_grupo2.data;

import com.mycompany.proyecto2_grupo2.modelo.Residente;
import com.mycompany.proyecto2_grupo2.modelo.Visitante;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author jeras
 */
public class VisitantesData {
        static String ruta = "visitantes.dat";
     public static void escribirVisitantes(ArrayList<Visitante> visitantes){
        try (ObjectOutputStream objOutputStream =
            new ObjectOutputStream(new FileOutputStream(ruta))){
            objOutputStream.writeObject(visitantes);
            System.out.println("... written to visitantes.dat.");
        }catch(IOException ex){
            ex.getMessage();
        }
    }
     
    public static ArrayList<Visitante> leerVisitantes() 
        throws IOException, ClassNotFoundException{
        ArrayList<Visitante> visitantes = null;
        try(ObjectInputStream objInputStream 
                = new ObjectInputStream(new FileInputStream(ruta))) {
          visitantes = (ArrayList<Visitante>)objInputStream.readObject();
        }
        return visitantes;
    }
    

}
