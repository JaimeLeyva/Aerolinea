/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aerolinea;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Scanner;

/**
 *
 * @author Jaime Leyva
 * @author Felipe
 */
public class Aerolinea {
    
    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args) {
        // TODO code application logic here
        /*
        El codigo te pregunta que si quieres ver el aeropuerto destino o
        origen (Pienso dejar unicamente, origen), (NOTA: lo que sigue es si
        seleccionas "origen") despues entra en el metodo "verDia()" y luego
        de seleccionar un dia, te pide el aeropuerto y aqui, si pulsas "0" 
        imprime mas nombres de aeropuertos, copia y pega el nombre. Finalmente
        imprime el nombre del aeropuerto que pegaste, solo que, lo busca en el 
        archivo que especificaste con los metodos "menu()" y "verDia()", y se 
        imprime cada vez que encuentra una linea con ese nombre. 
        
        NOTA:El codigo ahora debe usar la variable "aeropuerto" para futuras
        busquedas como la de "destino", el problema es la codificacion, no
        guarda acentos. Intenten repararlo.
        */
        
        
        
        System.out.println("Aerolinea ISI:");
        int respuesta = 0;
        String opcion = "";  
        String aeropuerto = "";
        
        archivos a = new archivos();       
        respuesta = a.menu(); //regresa "respuesta" y lo recibe "verDia()"
        
        
        switch(respuesta){
            
            case 1: //destino
                System.out.println("Escoja el dia con los vuelos "
                        + "disponibles hacia un destino:");
                opcion = a.verDia(respuesta);
                System.out.println("");
                System.out.println("");
                a.aeropuertoDestino(opcion);
                break;
            
            case 2: //origen
                System.out.println("Escoja el dia para ver los "
                        + "aeropuertos con vuelos disponibles:");
                opcion = a.verDia(respuesta);
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
