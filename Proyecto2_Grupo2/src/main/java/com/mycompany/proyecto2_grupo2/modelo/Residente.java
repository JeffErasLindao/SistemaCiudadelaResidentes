/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.proyecto2_grupo2.modelo;

import java.util.Objects;

/**
 *
 * @author andya
 */
public class Residente extends Usuario{
    private String nombre;
    private String correo;
    private String genero;
    private String pin;
    private Casa casa;
    
    public Residente(String user, String contraseña) {
        super(user, contraseña);
    }

    public Residente(String user, String contraseña, String nombre, String correo, String genero, String pin){
        super(user, contraseña);
        this.nombre = nombre;
        this.correo = correo;
        this.genero = genero;
        this.pin= pin;
        this.casa=null;
    }
    
    public Residente(String user, String contraseña, String nombre, String correo, String genero, String pin, Casa casa){
        super(user, contraseña);
        this.nombre = nombre;
        this.correo = correo;
        this.genero = genero;
        this.pin= pin;
        this.casa=casa;
    }

    public void setCasa(Casa casa) {
        this.casa = casa;
    }

    public Casa getCasa() {
        return casa;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

    public String getPin() {
        return pin;
    }

    public String getNombre() {
        return nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public String getGenero() {
        return genero;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 41 * hash + Objects.hashCode(this.nombre);
        hash = 41 * hash + Objects.hashCode(this.correo);
        hash = 41 * hash + Objects.hashCode(this.genero);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
       if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Residente other = (Residente) obj;
        if (!Objects.equals(this.nombre, other.nombre)) {
            return false;
        }
        if (!Objects.equals(this.correo, other.correo)) {
            return false;
        }
        if (!Objects.equals(this.genero, other.genero)) {
            return false;
        }
        return true;
       
    }

    @Override
    public String toString() {
        return "Residente{" + "nombre=" + nombre + ", correo=" + correo + ", genero=" + genero + '}';
    }
    
    public String getManzana(){
        Integer manzana = (int)casa.getUbicacion().getX();
        return "Mz. "+manzana.toString();
    }
    
    public String getVilla(){
        Integer villa = (int)casa.getUbicacion().getY();
        return "Vill. "+villa.toString();
    }
    
    public String getUbiMz(){
        Double x = casa.getUbicacion().getX();
        String ubi = x.toString();
        return ubi;
    }
    
    public String getUbiVil() {
        Double y = casa.getUbicacion().getY();
        String ubi = y.toString();
        return ubi;
    }
   
}
