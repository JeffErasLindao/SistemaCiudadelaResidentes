/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.proyecto2_grupo2.data;

import com.mycompany.proyecto2_grupo2.modelo.Administrador;
import com.mycompany.proyecto2_grupo2.modelo.Residente;
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
public class AdminsData {
    static String ruta = "admins.dat";
     public static void escribirAdmins(ArrayList<Administrador> admins){
        try (ObjectOutputStream objOutputStream =
            new ObjectOutputStream(new FileOutputStream(ruta))){
            objOutputStream.writeObject(admins);
            System.out.println("... written to admins.dat.");
        }catch(IOException ex){
            ex.getMessage();
        }
    }
     
    public static ArrayList<Administrador> leerAdmins() 
        throws IOException, ClassNotFoundException{
        ArrayList<Administrador> admins = null;
        try(ObjectInputStream objInputStream 
                = new ObjectInputStream(new FileInputStream(ruta))) {
          admins = (ArrayList<Administrador>)objInputStream.readObject();
        }
        return admins;
    }
}
