/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.proyecto2_grupo2;

import java.time.LocalDate;
import java.time.LocalTime;

/**
 *
 * @author jeras
 */
public class ClaveTemporal {
        String clave;
        LocalDate fecha;
        LocalTime hora;
        boolean activa=true;
        
        public ClaveTemporal(String clave,LocalDate fecha,LocalTime hora){
            this.clave = clave;
            this.fecha = fecha;
            this.hora = hora;
        }

        public String getClave() {
            return clave;
        }

        public void setClave(String clave) {
            this.clave = clave;
        }

        public LocalDate getFecha() {
            return fecha;
        }

        public void setFecha(LocalDate fecha) {
            this.fecha = fecha;
        }

        public LocalTime getHora() {
            return hora;
        }

        public void setHora(LocalTime hora) {
            this.hora = hora;
        }
        
        public boolean getActivo() {
            return activa;
        }

        public void setActivo(boolean v) {
            this.activa = v;
        }
        
}
