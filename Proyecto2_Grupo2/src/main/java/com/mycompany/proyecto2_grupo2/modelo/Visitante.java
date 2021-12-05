/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.proyecto2_grupo2.modelo;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Objects;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author andya
 */
public class Visitante implements Serializable{
    private String nombre;
    private String cedula;
    private String correo;
    private  LocalDate fecha;
    private  LocalTime hora;
    private String codigoAcceso;
    private boolean validezCodigo;
    //private 

    public Visitante(String nombre, String cedula, String correo,LocalDate fecha, LocalTime hora,String codigoAcceso) {
        this.nombre = nombre;
        this.cedula = cedula;
        this.correo =correo;
        this.fecha = fecha;
        this.hora = hora;
        this.codigoAcceso =codigoAcceso;
        this.validezCodigo = true;
        
    }

    public String getNombre() {
        return nombre;
    }

    public String getCedula() {
        return cedula;
    }

    public String getCorreo() {
        return correo;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCedula(String strcedula) {
        this.cedula = strcedula;
    }

    public void setCorreo(String correo) {
        this.correo =correo;
    }
    
    public LocalDate getFecha(){
        return fecha;
    }
    
    public void setFecha(LocalDate f){
        this.fecha = f;
    }
    
    
    public LocalTime getHora(){
        return hora;
    }
    public void setHora(LocalTime h){
        this.hora = h;
    }
    
    public String getCodigo(){
        return codigoAcceso;
    }
    
    public boolean getValidezCodigo(){
        return validezCodigo;
    }
    public void setValidesCodigo(Boolean v){
        this.validezCodigo=v;
    }
    
    

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + Objects.hashCode(this.nombre);
        hash = 97 * hash + Objects.hashCode(this.cedula);
        hash = 97 * hash + Objects.hashCode(this.correo);
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
        final Visitante other = (Visitante) obj;
        if (!Objects.equals(this.nombre, other.nombre)) {
            return false;
        }
        if (!Objects.equals(this.cedula, other.cedula)) {
            return false;
        }
        if (!Objects.equals(this.correo, other.correo)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Visitante{" + "nombre=" + nombre + ", cedula=" + cedula + ", correo=" + correo + '}';
    }
    
    
    
}
