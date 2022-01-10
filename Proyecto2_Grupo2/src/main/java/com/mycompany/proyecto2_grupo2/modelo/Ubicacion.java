/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.proyecto2_grupo2.modelo;

import java.io.Serializable;

/**
 *
 * @author rociomera
 */
public class Ubicacion implements Serializable{
    private double x; //Manzana
    private double y; //Villa
    public Ubicacion(double x, double y){
        this.x = x;
        this.y = y;
    }
    public double getX() {
        return x;
    }
    public void setX(double x) {
        this.x = x;
    }
    public double getY() { 
        return y;
    }
    public void setY(double y) {
        this.y = y;
    }

    public double calcularDistanciaCartesiana(){
        return Math.sqrt(Math.pow(this.x-this.x,2) + Math.pow(this.y - this.y,2));
    }

    @Override
    public String toString() {
        return "\nMz= " +x+",\nVilla="+y;
    }
    
    public String toCSV() {
        return getX()+":"+getY();
    }
    
    
}
