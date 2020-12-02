/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aerolinea;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.Scanner;

/**
 *
 * @author Usuario
 */

//REVISAR EL METODO "seleccionaAeropuerto"
public class archivos {
    
    int a = 1;
    int b = 5;
    String cadenaGlobal = "";
    
    public int menu(){
        /*
        Este metodo se encarga de regresar un "int" dependiendo de lo que elijas,
        si pones 1 entonces marca 1 en "respuesta" y esta variable es la que regresa 
        el metodo y se usara como la variable que exige el metodo "verDia", esta 
        sirve para indicar si el programa debe leer el "Origen" o el "Destino"
        */
        int respuesta = 0;
        System.out.println("***************************");
        System.out.println("******* Bienvenidos *******");
        System.out.println("***************************");
        System.out.println("Elija la opcion que le interese:");
        System.out.println("1. ¿Hacia donde quieres ir? Selecciona un aeropuerto."); //Destino
        System.out.println("2. Consultar el aeropuerto de salida."); //Origen
        System.out.println("3. Salir");
        Scanner sc = new Scanner(System.in);
        int opcion = sc.nextInt();
        
        System.out.println("");
        System.out.println("");
        
        if ((opcion != 0) || (opcion <= 3)) {
            
            switch(opcion){
                
                case 1:
                    respuesta = 1;
                    break;
                
                case 2:
                    respuesta = 2;
                    break;
                
                case 3:
                    System.exit(0);
                    break;
                
                default:
                    System.out.println("Por favor, elija las opciones que se muestran.");
                    break;
            }
            
        }
        return respuesta;
        
    }
    
    
    public void aeropuertoOrigen(String dia, String buscar){ //NOTA: POR AHORA, ESTE METODO MUESTRA EL AEROPUERTO QUE INDICA CON LA VARIABLE "buscar"
        //buscar = "A.I ANGEL ALBINO CORZO"; //esta variable es la que regresa el metodo "seleccionaAeropuerto"
        //"aeropuertoOrigen" hace lo mismo que "aeropuertoDestino" por eso aun no actualizo el metodo
        System.out.println("");
        System.out.println("");
        
        try{
                        
            FileReader fr = new FileReader("\\Users\\Usuario\\Documents\\NetBeansProjects\\proyectoFC3\\listas\\" + dia +".txt");
            BufferedReader br = new BufferedReader(fr); //creamos el objeto "br" que lee el documento
            String cadena= "";        
            int limiteDocumento = (int) cadena.lines().count(); 
            //int limite = (int) br.lines().count(); // cuenta las lineas pero por alguna razón que no entiendo, causa conflicto con "limiteDocumento", asi que ignorenlo
                       
            System.out.println("¿En que aeropuerto te gustaria tomar tu avion?");                                
            
            /*
            el metodo de busqueda ha "mejorado", ahora con el "for" lee las lineas 
            del archivo .txt y con la variable String "buscar" revisa cada linea del 
            archivo y si encuentra una linea igual a "buscar", imprime esa linea,
            incluso si estas estan separadas por otras lineas diferentes.
            */
            for (int i = 0; i <= limiteDocumento; i--) {
                
                cadena = br.readLine();
                
                if (cadena.equals(null)) { //si marca "null", detiene el ciclo
                   
                    System.out.println("Estos son los vuelos disponibles.");
                    System.out.println("");
                    System.out.println("Sino aparece el aeropuerto que te interesa");
                    System.out.println("buscalo en otro dia.");
                    break;
                
                }else{
                    if (cadena.startsWith(buscar)) { //si la linea empieza con "buscar"
                        //entonces imprimela
                        System.out.println(cadena);                                             
                    }
                        
                }                                                
            }

           
        }catch(Exception ex){
           
           
        }
        
        System.out.println("");
        System.out.println("");
        
        
    }
    
    
    public void aeropuertoDestino(String dia){
        /*
        Este metodo recibe una cadena "dia", "dia" se agrega a la ruta en donde
        se busca un documento dependiendo del dia valga la redundancia
        */
        System.out.println("");
        System.out.println("");
        
        try{
            
            //en la fila de abajo es donde hacemos lo de la ruta
            FileReader fr = new FileReader("\\Users\\Usuario\\Documents\\NetBeansProjects\\proyectoFC3\\listas\\" + dia +".txt");
            BufferedReader br = new BufferedReader(fr); //creamos el objeto que nos servira para leer el .txt
            String cadena= ""; //cadena se encargara de leer las lineas del documento 
            int limiteDocumento = (int) cadena.lines().count(); //cuenta el numero de lineas que tiene el .txt
            
            System.out.println("¿Hacia donde quieres viajar?");
            System.out.println("Estos son los aeropuertos disponibles a donde puedes ir:");
            System.out.println("");
            
            
            for (int i = 0; i <= 2; i++) {
                cadena = br.readLine();
                System.out.println(cadena);
                limiteDocumento--;
            }
            
            limiteDocumento = (int) cadena.lines().count();
            System.out.println("++++++++++++++++++++++");
            /*
            El "for" inicia en 0 y mientras sea menor o igual que el limiteDocumento,
            cuando inicia el "for", "cadena" lee la linea y después comprueba si hay 
            contenido dentro de la linea, sino detiene el "for". Si el "if" no se 
            cumple entonces imprime la linea que contiene "cadena".            
            */
            for (int i = 0; i <= limiteDocumento; i--) {
                cadena = br.readLine();
                if (cadena.equals(null)) {
                    break;
                }
                
                System.out.println(cadena);
                
            }
            
        }catch(Exception ex){
           /*
           Si mal no recuerdo, aqui hay un problema por que siempre manda los mensajes 
           independientemente de si el "try" se ejecuta correctamente.
           */
           
           //System.out.println("Hubo un problema buscando la ubicacion de tu aeropuerto.");
           //System.out.println("Intenta cargar la aplicacion de nuevo");
            
        }
        
        System.out.println("");
        System.out.println("");
    }
    
    
    public void tiempoViaje(){
        
    }
    
    
    public String seleccionaAeropuerto(int resp){ //NOTA:El metodo tiene problemas de codificacion y no guarda los acentos
        //NOTA2:Al no poder guardar acentos, ocasiona conflictos con las futuras busquedas, intenten repararlo
        
        //el chiste es que tome la opcion del usuario y guarde esa opcion y con eso le indique
        //al metodo "aeropuertoDestino" y "aeropuertoOrigen" que aeropuertos deben imprimir
        String aeropuerto = "";
        
        
        try{
            
            cadenaGlobal = cadenaGlobal + b;
            FileReader fr = new FileReader("\\Users\\Usuario\\Documents\\NetBeansProjects\\proyectoFC3\\listas\\AeropuertoOrigenLista.txt");
            BufferedReader br = new BufferedReader(fr);           
            int limiteDocumento = (int) cadenaGlobal.lines().count();
            String opcion;
            String cadena = "";
            int indice = 0;
            
            System.out.println("***************************");
            System.out.println("******* Aeropuertos *******");
            System.out.println("***************************");
            System.out.println("Estos son todos los aeropuertos:");
            System.out.println("-------------------------");
            
            do{
                
            for (int i = a; i <= b; i++) {
                
                indice++;
                cadenaGlobal = br.readLine();
                System.out.println(indice + ": " + cadenaGlobal);
                limiteDocumento--;                    
                
            }
            
            System.out.println("-------------------------");
            System.out.println("0. Ver mas.");            
            System.out.println("Por favor copia el nombre del aeropuerto que desees");
            System.out.println("y colocalo abajo:");
            
            Scanner sc = new Scanner(System.in);
            opcion = sc.nextLine();
            
            a = a + 6;
            b = b + 6;
            
            System.out.println("");
            System.out.println("-------------------------");
            
            
            if (opcion.startsWith("0")) {
                //Sale del "if", hace la vuelta y muestra los siguientes aeropuertos
            }else{                
                
                aeropuerto = opcion;
                break;
                                               
            }
            
            }while((cadenaGlobal != "") && (opcion.startsWith("0")));
            
        
        }catch(Exception ex){
            
        }
        
        return aeropuerto;
    
    }
    
    
    public String verDia(int modo){
        
        String dia = ""; //esta variable contendrá el dia seleccionado por los usuarios
        String tipo = ""; //la variable indica si será "Destino" u "Origen" en las rutas de los archivos
        
        System.out.println("");
        System.out.println("");
        System.out.println("***********************************");
        System.out.println("******* Vuelos de la semana *******");
        System.out.println("***********************************");
        System.out.println("Seleccione los vuelos de un dia:");
        System.out.println("1. Lunes");
        System.out.println("2. Martes");
        System.out.println("3. Miercoles");
        System.out.println("4. Jueves");
        System.out.println("5. Viernes");
        System.out.println("6. Sabado");
        System.out.println("7. Domingo");
        System.out.println("Elige una opción escribiendo el \"numero del dia\": ");
        Scanner sc = new Scanner(System.in);
        int opcion = sc.nextInt(); //toma la respuesta del usuario
       
        
        switch(modo){
            
            case 1:
                tipo = "-AeropuertoDestino";
                break;
                
            case 2:
                tipo = "-AeropuertoOrigen";
                break;
                
                
        }
        
        //mientras la respuesta sea diferente de 0 y menor o igual que 7, entra al switch
        if ((opcion != 0) || (opcion <= 7)) { 
           
            //en caso de que la respuesta este dentro de alguno de estos casos, le dará la fecha a la variable "dia"
            //NOTA: Solo muestra las listas de "destino" (por ahora)
            switch(opcion){ 
                
                case 0:
                    System.out.println("Por favor, elija las opciones que se muestran.");
                    break; 
                    
                case 1:
                    dia = "Lunes" + tipo;
                    break;
                    
                case 2:
                    dia = "Martes" + tipo;
                    break;
                
                case 3:
                    dia = "Miercoles" + tipo;
                    break;
                
                case 4:
                    dia = "Jueves" + tipo;
                    break; 
                
                case 5:
                    dia = "Viernes" + tipo;
                    break;
                
                case 6:
                    dia = "Sabado" + tipo;
                    break;
                
                case 7:
                    dia = "Domingo" + tipo;
                    break;    
                
                default:
                    System.out.println("Por favor, elija las opciones que se muestran.");
                    break;
            }
            
        }
        
        
        return dia;
    }
    
                
}