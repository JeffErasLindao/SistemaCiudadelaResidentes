/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.proyecto2_grupo2.data;

import static com.mycompany.proyecto2_grupo2.data.AdminsData.escribirAdmins;
import static com.mycompany.proyecto2_grupo2.data.CasasData.escribirCasas;
import static com.mycompany.proyecto2_grupo2.data.EntradaResidenteData.escribirEntradasResidentes;
import static com.mycompany.proyecto2_grupo2.data.EntradaVisitanteData.escribirEntradasVisitantes;
import static com.mycompany.proyecto2_grupo2.data.ResidentesData.escribirResidentes;
import static com.mycompany.proyecto2_grupo2.data.VehiculosData.escribirVehiculos;
import static com.mycompany.proyecto2_grupo2.data.VisitantesData.escribirVisitantes;
import com.mycompany.proyecto2_grupo2.modelo.Administrador;
import com.mycompany.proyecto2_grupo2.modelo.Casa;
import com.mycompany.proyecto2_grupo2.modelo.EntradaUsuario;
import com.mycompany.proyecto2_grupo2.modelo.Residente;
import com.mycompany.proyecto2_grupo2.modelo.Ubicacion;
import com.mycompany.proyecto2_grupo2.modelo.Vehiculo;
import com.mycompany.proyecto2_grupo2.modelo.Visitante;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author andya
 */
public class InicializarSistema {
    
    public static List<Visitante> visitantesCopia = new ArrayList<>();
    
     public static void main(String[] args){
         //Creo mis admins
        
        ArrayList<Administrador> admins = new ArrayList<Administrador>();
        admins.add(new Administrador("admin", "admin"));
        escribirAdmins(admins);
        
       
        //Creo mis residentes
        ArrayList<Residente> residentes = new ArrayList<Residente>();
        residentes.add(new Residente("andaapol", "1234", "Andre", "andyagpolo@gmail.com", "masculino","4567"));
        residentes.add(new Residente("jeferas", "1234", "Jefferson", "jeraslindao@gmail.com", "masculino","4321"));
        escribirResidentes(residentes);
        
        //Creo mis casas
        ArrayList<Casa> casas = new ArrayList<Casa>();
        casas.add(new Casa(residentes.get(0),new Ubicacion(70.0,93.0))); // casa 1
        casas.add(new Casa(new Ubicacion(250.0,93.0))); // casa 2
        casas.add(new Casa(new Ubicacion(550.0,93.0))); // casa 3
        casas.add(new Casa(residentes.get(1),new Ubicacion(167.0,301.0))); // casa 4
        casas.add(new Casa(new Ubicacion(390.0,301.0))); // casa 5
        escribirCasas(casas);
        
        residentes.get(0).setCasa(casas.get(0));
        residentes.get(1).setCasa(casas.get(3));
        escribirResidentes(residentes);
        
        ArrayList<Vehiculo> vehiculos = new ArrayList<Vehiculo>();
        escribirVehiculos(vehiculos);
        
        ArrayList<Visitante> visitantes = new ArrayList<Visitante>();
        visitantes.add(new Visitante("CARLITO","09502966654","carlitos@gmail.com",LocalDate.parse("2021-09-05"),LocalTime.parse("02:14:00"),"12345678"));
        visitantes.add(new Visitante("ANDRESITO","091234567","andresito@gmail.com",LocalDate.parse("2021-09-06"),LocalTime.parse("02:20:00"),"abcd1234"));
        visitantes.add(new Visitante("JUANITO","091234550","juanito@gmail.com",LocalDate.parse("2021-09-03"),LocalTime.parse("08:25:00"),"11111111"));
        visitantes.add(new Visitante("PEDRIO","091234510","pedrito@gmail.com",LocalDate.parse("2021-09-04"),LocalTime.parse("12:01:00"),"ASSS14D78"));
        visitantes.add(new Visitante("SERGIO","091234100","serguito@gmail.com",LocalDate.parse("2021-09-01"),LocalTime.parse("15:30:00"),"ASSS14D14"));
        visitantes.add(new Visitante("MARIA","09502966650","maria@gmail.com",LocalDate.parse("2021-09-02"),LocalTime.parse("16:50:00"),"ASSS14DQ1"));
        escribirVisitantes(visitantes);
        visitantesCopia = visitantes;
        
        ArrayList<EntradaUsuario> entradasResidentes = new ArrayList<EntradaUsuario>();
        entradasResidentes.add(new EntradaUsuario("CARLOS",LocalDate.parse("2021-09-04"),LocalTime.parse("09:30:00")));
        entradasResidentes.add(new EntradaUsuario("JAIME",LocalDate.parse("2021-09-04"),LocalTime.parse("10:30:00")));
        entradasResidentes.add(new EntradaUsuario("GERARDO",LocalDate.parse("2021-09-04"),LocalTime.parse("11:30:00")));
        entradasResidentes.add(new EntradaUsuario("MARIA",LocalDate.parse("2021-09-04"),LocalTime.parse("11:30:00")));
        entradasResidentes.add(new EntradaUsuario("SEBASTIAN",LocalDate.parse("2021-09-04"),LocalTime.parse("15:30:00")));
        entradasResidentes.add(new EntradaUsuario("MARIAANGELA",LocalDate.parse("2021-09-04"),LocalTime.parse("15:30:00")));
        entradasResidentes.add(new EntradaUsuario("JEFF",LocalDate.parse("2021-09-04"),LocalTime.parse("15:30:00")));
        entradasResidentes.add(new EntradaUsuario("MARIO",LocalDate.parse("2021-09-04"),LocalTime.parse("20:30:00")));
        entradasResidentes.add(new EntradaUsuario("NICOL",LocalDate.parse("2021-09-04"),LocalTime.parse("20:30:00")));
        entradasResidentes.add(new EntradaUsuario("DOMENICA",LocalDate.parse("2021-09-04"),LocalTime.parse("20:30:00")));
        entradasResidentes.add(new EntradaUsuario("JUSTIN",LocalDate.parse("2021-09-04"),LocalTime.parse("23:30:00")));
        escribirEntradasResidentes(entradasResidentes);
        
        ArrayList<EntradaUsuario> entradasVisitantes = new ArrayList<EntradaUsuario>();
        entradasVisitantes.add(new EntradaUsuario("VISITANTE1",LocalDate.parse("2021-09-04"),LocalTime.parse("07:30:00")));
        entradasVisitantes.add(new EntradaUsuario("VISITANTE2",LocalDate.parse("2021-09-04"),LocalTime.parse("07:30:00")));
        entradasVisitantes.add(new EntradaUsuario("VISITANTE3",LocalDate.parse("2021-09-04"),LocalTime.parse("18:30:00")));
        entradasVisitantes.add(new EntradaUsuario("VISITANTE4",LocalDate.parse("2021-09-04"),LocalTime.parse("18:30:00")));
        entradasVisitantes.add(new EntradaUsuario("VISITANTE5",LocalDate.parse("2021-09-04"),LocalTime.parse("18:30:00")));
        entradasVisitantes.add(new EntradaUsuario("VISITANTE6",LocalDate.parse("2021-09-04"),LocalTime.parse("19:30:00")));
        entradasVisitantes.add(new EntradaUsuario("VISITANTE7",LocalDate.parse("2021-09-04"),LocalTime.parse("20:30:00")));
        entradasVisitantes.add(new EntradaUsuario("VISITANTE8",LocalDate.parse("2021-09-04"),LocalTime.parse("20:30:00")));
        entradasVisitantes.add(new EntradaUsuario("VISITANTE9",LocalDate.parse("2021-09-04"),LocalTime.parse("20:30:00")));
        entradasVisitantes.add(new EntradaUsuario("VISITANTE10",LocalDate.parse("2021-09-04"),LocalTime.parse("21:30:00")));
        entradasVisitantes.add(new EntradaUsuario("VISITANTE11",LocalDate.parse("2021-09-04"),LocalTime.parse("22:30:00")));
        escribirEntradasVisitantes(entradasVisitantes);
        
        
        //Administrador.enviarCorreo();

    }
     
     public static List<Visitante> getListaVisitante(){
         return visitantesCopia;
     }
     
     public static void setVisitante(int pos, Visitante v){
         visitantesCopia.set(pos, v);
         
     }
     
     
}
