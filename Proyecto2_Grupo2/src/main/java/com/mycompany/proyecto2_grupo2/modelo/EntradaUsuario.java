/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.proyecto2_grupo2.modelo;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;

/**
 *
 * @author jeras
 */
public class EntradaUsuario implements Serializable {
    String nombre;
    LocalDate fentrada;
    LocalTime hentrada;
    
    public EntradaUsuario(String nombre, LocalDate fentrada,LocalTime hentrada){
        this.nombre = nombre;
        this.fentrada = fentrada;
        this.hentrada = hentrada;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public LocalDate getFentrada() {
        return fentrada;
    }

    public void setFentrada(LocalDate fentrada) {
        this.fentrada = fentrada;
    }

    public LocalTime getHentrada() {
        return hentrada;
    }

    public void setHentrada(LocalTime hentrada) {
        this.hentrada = hentrada;
    }
    
    
    
}
