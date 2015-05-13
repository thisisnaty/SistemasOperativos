
/*
    Lee el archivo y va llamando al metodo que se necesita,
    checa las instrucciones para ver que sean correctas.
*/
package finaloperativos;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Scanner;
/**
 *
 * @author nataliagarcia
 */
public class LeeArchivo {
    Procedimiento p;                    // Variable que tiene la memoria y los metodos proceso, acceso, liberar
    String nombreArchivo;           //nombre del archivo que se asigan en el main de FinalOperativos
    Scanner scan;                       //un scanner para leer cada linea del archivo
    LinkedList<Proceso> lklProcesos;            //una lista encadenada donde se guardan los procesos
    int pId;                                  //identificacion del proceso
    int pTam;                              //tamano del proceso
    String line;                            //se guarda la linea del archivo en este string
    String[] word;                        //se guarda la palabra del archivo en este string
    int direccion;                         //la direccion se asigna con el comando A
    boolean bitMod;                    //el bit de modificacion que se asigna con el comando A
    Conjunto con;                        //donde se guardan los datos para el reporte del conjunto hasta fin
    
    
    /**
     * LeeArchivo
     * Constructor de la clase <code> LeeArchivo </code>, se inicializan los valores
     * @param nombreArchivo 
     */
    public LeeArchivo (String nombreArchivo) {
        this.nombreArchivo = nombreArchivo;
        line = null;
        word = new String[4];
        scan = null;
        lklProcesos = new LinkedList();
        pId = -1;
        pTam = -1;
        p = new Procedimiento();
        con = new Conjunto();
    }
    
    /**
     * leer
     * Metodo que al leer el archivo valida los comandos y llama a las funciones indicadas 
     * @throws FileNotFoundException
     * @throws IOException 
     */
    void leer() throws FileNotFoundException, IOException{
        
        if (checaArchivo()) {
            //se lee la primera linea
            line = scan.nextLine();
            //se eliminan espacios
            line = line.trim();
            
            //se leera el archivo hasta llegar a E
            while (!line.equals("E")) {
                
                //se guardan las palabras en el arreglo word
                word = line.split(" ");
                
                //se evalua la primera palabra
                switch (word[0]) {
                    
                    //si la primera palabra es P
                    case "P":
                        
                        //se checa si la instruccion es valida
                        if (checaP()) {
                            //se imprime la instruccion
                            System.out.println(line);
                            //se crea un proceso con los valores que le son asignados por el archivo
                            Proceso proceso = new Proceso(pId, pTam);
                            //se llama a la funcion que le corresponde en procedimiento
                            p.procP(proceso, con);
                            //se agrega el proceso a la lista encadenada de procesos
                            lklProcesos.add(proceso);
                        }
                        break;
                        
                    //si la primera palabra es A
                    case "A":
                        
                        //se checa que la instruccion sea valida
                        if (checaA()) {
                            //se imprime la instruccion
                            System.out.println(line);
                            //se llama a la funcion que le corresponde en procedimiento
                            p.accesar(direccion, pId, bitMod, lklProcesos, con);
                        }
                        break;
                        
                        //si la primera palabra es L
                    case "L":
                        //se checa que la instruccion sea valida
                        if (checaL()) {
                            //se imprime la instruccion
                            System.out.println(line);
                            //se llama a la funcion que le corresponde en procedimiento
                            p.liberar(pId, con, lklProcesos);
                        }
                        break;
                        
                        //si la primera palabra es F
                    case "F":
                        //se checa que la instruccion sea valida
                        if (line.equals("F")) {
                            //se imprime la instruccion
                            System.out.println("Fin");
                            //se llama a la funcion que le corresponde en procedimiento;
                            p.fin(lklProcesos, con);
                            //se reinicializa la variable <con> de tipo Conjunto
                            con = new Conjunto();
                            //se reinicializa la variable <p> de tipo Procedimiento
                            p = new Procedimiento();
                        }
                        break;
                        
                        //la palabra E es valida
                    case "E":
                        break;
                        
                        //si la palabra no es igual a ninguna de las anteriores, se marca un error
                    default:
                        //se imprime la instruccion
                        System.out.println(line);
                        //se imprime la razon del error
                        System.out.println("ERROR: el comando '" + word[0] + "' no fue encontrado");
                        break;
                }
                //se lee la siguiente linea del archivo
                line = scan.nextLine();
                //se eliminan los espacios
                line = line.trim();
            }
            //se cierra scan
            scan.close();
        }
    }
    /**
     * checaArchivo
     * Metodo de tipo <code> boolean </code> que regresa true si el archivo fue leido <br>
     * correctamente
     * @return 
     */
    boolean checaArchivo() {
        //intenta leer el archivo
        try {
            scan = new Scanner(new File(nombreArchivo));
            return true;
        } 
        //funciona si encuentra un archivo valido, si no reporta el error
        catch (FileNotFoundException e){
            //imprime el error
            System.out.println("ERROR: No existe el archivo de nombre '" + nombreArchivo + "'");
            return false;
        }
    }
    /**
     * checaL
     * Metodo de tipo <code> boolean </code> que regresa true si el comando L fue <br>
     * hecho correctamente, false si no
     * @return 
     */
    boolean checaL() {
        //se guarda line en temp
        String temp = line;
        //se cuentan las palabras sin espacios, y se valida si es un numero valido de palabras
        if (temp.trim().split("\\s+").length != 2) {
            //se imprime el tipo de error
            System.out.println("ERROR: faltan/sobran datos");
            return false;
        }
        
        try {
            pId = Integer.parseInt(word[1]);
        } 
        //si la palabra no es un numero…
        catch(NumberFormatException e) {
            //se imprime el tipo de error
            System.out.println("ERROR: '" + word[1] + "' no es un ID valido");
            return false;
        }
        return true;
    }
    /**
     * checaA
     * Metodo de tipo <code> boolean </code> que regresa true si el comando A fue <br>
     * hecho correctamente, false si no
     * @return 
     */
    boolean checaA() {
        //se guarda line en temp
        String temp = line;
        //se cuentan las palabras sin espacios, y se valida si es un numero valido de palabras
        if (temp.trim().split("\\s+").length != 4) {
            //se imprime el tipo de error
            System.out.println("ERROR: faltan/sobran datos");
            return false;
        }
        try {
            direccion = Integer.parseInt(word[1]);
        } 
        //si la palabra no es un numero…
        catch(NumberFormatException e) {
            //se imprime el tipo de error
            System.out.println("ERROR: '" + word[1] + "' no es una direccion valida");
            return false;
        }
        
        try {
            pId = Integer.parseInt(word[2]);
        } 
        //si la palabra no es un numero…
        catch(NumberFormatException e) {
            //se imprime el tipo de error
            System.out.println("ERROR: '" + word[2] + "' no es un ID valido");
            return false;
        }
        
        try {
            switch (word[2]) {
                case "0":
                    bitMod = false;
                    break;
                case "1":
                    bitMod = true;
                    break;
                default:
                    return false;
            }
        } 
        //si la palabra no es un numero…
        catch(NumberFormatException e) {
            //se imprime el tipo de error
            System.out.println("ERROR: '" + word[1] + "' no es un bit valido");
            return false;
        }
        return true;
    }
    /**
     * checaP
     * Metodo de tipo <code> boolean </code> que regresa true si el comando P fue <br>
     * hecho correctamente, false si no
     * @return 
     */
    boolean checaP() {
        //se guarda line en temp
        String temp = line;
        //se cuentan las palabras sin espacios, y se valida si es un numero valido de palabras
        if (temp.trim().split("\\s+").length != 3) {
            //se imprime el tipo de error
            System.out.println("ERROR: faltan/sobran datos");
            return false;
        }
        try {
            pTam = Integer.parseInt(word[1]);
            if (pTam > 2048) {
                //se imprime el tipo de error
                System.out.println("ERROR: El tamaño '" + pTam + "' es mayor a 2048");
                return false;
            }
        } 
        //si la palabra no es un numero…
        catch(NumberFormatException e) {
            //se imprime el tipo de error
            System.out.println("ERROR: '" + word[1] + "' no es un tamaño valido");
            return false;
        }
        try {
            pId = Integer.parseInt(word[2]);
        } 
        //si la palabra no es un numero…
        catch(NumberFormatException e) {
            //se imprime el tipo de error
            System.out.println("ERROR: '" + word[2] + "' no es un ID valido");
            return false;
        }
        return true;
    }
}