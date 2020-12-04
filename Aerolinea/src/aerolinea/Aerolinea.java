/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Aerolinea;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Scanner;

/**
 *
 * @author Usuario
 */
public class Aerolinea {
    
    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args) {
        // TODO code application logic here
        
        System.out.println("Aerolinea ISI:");
        int respuesta = 0;
        String opcion = "";  
        String aeropuerto = "";
        
        archivos a = new archivos();
        
        respuesta = a.menu();
        
        switch(respuesta){
                   
            case 1: //origen
                System.out.println("Escoja el dia para ver los "
                        + "aeropuertos con vuelos disponibles:");
                opcion = a.verDia(respuesta); //2
                System.out.println("");
                System.out.println("");
                aeropuerto = a.seleccionaAeropuerto(respuesta); 
                a.aeropuertoOrigen(opcion, aeropuerto);
                break;
            
                
        }
      
        System.out.println("");
        System.out.println("");
        System.out.println("-------------------------");
        
        
    }
    
}
