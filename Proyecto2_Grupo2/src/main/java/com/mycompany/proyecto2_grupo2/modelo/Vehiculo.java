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
public class Vehiculo implements Serializable{
    private String matricula;
    private Residente residente;

    public Vehiculo(String matricula, Residente residente) {
        this.matricula = matricula;
        this.residente = residente;
    }

    public String getMatricula() {
        return matricula;
    }

    public Residente getResidente() {
        return residente;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public void setResidente(Residente residente) {
        this.residente = residente;
    }

    @Override
    public String toString() {
        return "Vehiculo{" + "matricula=" + matricula + ", residente=" + residente + '}';
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + Objects.hashCode(this.matricula);
        hash = 97 * hash + Objects.hashCode(this.residente);
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
        final Vehiculo other = (Vehiculo) obj;
        if (!Objects.equals(this.matricula, other.matricula)) {
            return false;
        }
        if (!Objects.equals(this.residente, other.residente)) {
            return false;
        }
        return true;
    }
}
