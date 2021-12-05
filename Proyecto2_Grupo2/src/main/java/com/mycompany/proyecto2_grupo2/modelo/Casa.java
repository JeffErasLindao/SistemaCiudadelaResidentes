/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.proyecto2_grupo2.modelo;

import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author andya
 */
public class Casa implements Serializable{
    private Residente residente;
    private Ubicacion ubicacion;

    public Casa(Residente residente, Ubicacion ubicacion) {
        this.residente = residente;
        this.ubicacion = ubicacion;
    }
    
    public Casa(Ubicacion ubicacion) {
        this.residente = null;
        this.ubicacion = ubicacion;
    }

    public Residente getResidente() {
        return residente;
    }

    public Ubicacion getUbicacion() {
        return ubicacion;
    }

    public void setResidente(Residente residente) {
        this.residente = residente;
    }

    public void setUbicacion(Ubicacion ubicacion) {
        this.ubicacion = ubicacion;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 29 * hash + Objects.hashCode(this.residente);
        hash = 29 * hash + Objects.hashCode(this.ubicacion);
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
        final Casa other = (Casa) obj;
        if (!Objects.equals(this.residente, other.residente)) {
            return false;
        }
        if (!Objects.equals(this.ubicacion, other.ubicacion)) {
            return false;
        }
        return true;
    }
    
    public boolean Ocupada(){
        if(residente!=null){
            return true;
        }
        return false;
    }
    
    public String verResidente(){
        if(residente==null){
            return "DESOCUPADA";
        }
        return residente.getNombre();

    }
    
    
    
}
