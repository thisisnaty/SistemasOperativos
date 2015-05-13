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
    // Variable que tiene la memoria y los metodos proceso, acceso, liberar
    Procedimiento p;
    // Variables para la lectura del archivo
    String nombreArchivo;
    Scanner scan;
    Scanner scan2;
    int pId;
    int pTam;
    String line;
    String[] word;
    int direccion;
    boolean bitMod;
    // Lista encadenada que va a tener todos los procesos
    LinkedList<Proceso> lklProcesos;
    // Guarda la informacion del conjunto de instrucciones
    // Turnarround, num de swaps in y out, page faults
    Conjunto con;
    
    public LeeArchivo (String nombreArchivo) {
        this.nombreArchivo = nombreArchivo;
        line = null;
        word = new String[4];
        scan = null;
        scan2 = null;
        lklProcesos = new LinkedList();
        pId = -1;
        pTam = -1;
        p = new Procedimiento();
        con = new Conjunto();
    }
    
    void leer() throws FileNotFoundException, IOException{
        
        if (checaArchivo()) {
            //line es para leer cada linea del archivo de texto
            line = scan.nextLine();
            
            //se leera el archivo hasta llegar a E
            while (!line.equals("E")) {
                word = line.split(" ");
                switch (word[0]) {
                    case "P":
                        if (checaP()) {
                            System.out.println(line);
                            Proceso proceso = new Proceso(pId, pTam);
                            p.procP(proceso);
                            lklProcesos.add(proceso);
                        }
                        break;
                    case "A":
                        if (checaA()) {
                            System.out.println(line);
                            p.accesar(direccion, pId, bitMod, lklProcesos);
                        }
                        break;
                    case "L":
                        if (checaL()) {
                            System.out.println(line);
                            p.liberar(pId, con, lklProcesos);
                        }
                        break;
                    case "F":
                        //reporte
                        if (line.equals("F")) {
                            con = new Conjunto();
                            //Reporte r = new Reporte();
                        }
                        break;
                    case "E":
                        break;
                    default:
                        System.out.println("Error en la instruccion");
                        break;
                }
                line = scan.nextLine();
            }
            
            scan.close();
        }
    }
    
    boolean checaArchivo() {
        try {
            scan = new Scanner(new File(nombreArchivo));
            scan2 = new Scanner(new File(nombreArchivo));
            return true;
        } catch (FileNotFoundException e){
            System.out.println("No existe el archivo de nombre " + nombreArchivo);
            return false;
        }
    }
    
    boolean checaL() {
        String temp = line;
        if (temp.trim().split("\\s+").length != 2) {
            System.out.println("Operacion invalida, faltan datos");
            return false;
        }
        
        try {
            pId = Integer.parseInt(word[1]);
        } catch(NumberFormatException e) {
            System.out.println("Operacion invalida, no es un numero (direccion)");
            return false;
        }
        return true;
    }
    
    boolean checaA() {
        String temp = line;
        if (temp.trim().split("\\s+").length != 4) {
            System.out.println("Operacion invalida, faltan datos");
            return false;
        }
        try {
            direccion = Integer.parseInt(word[1]);
        } catch(NumberFormatException e) {
            System.out.println("Operacion invalida, no es un numero (direccion)");
            return false;
        }
        
        try {
            pId = Integer.parseInt(word[2]);
        } catch(NumberFormatException e) {
            System.out.println("Operacion invalida, no es un numero (direccion)");
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
        } catch(NumberFormatException e) {
            System.out.println("Operacion invalida, no es un numero (direccion)");
            return false;
        }
        return true;
    }
    
    boolean checaP() {
        String temp = line;
        if (temp.trim().split("\\s+").length != 3) {
            System.out.println("Operacion invalida, faltan datos");
            return false;
        }
        try {
            pTam = Integer.parseInt(word[1]);
        } catch(NumberFormatException e) {
            System.out.println("Operacion invalida, no es un numero (tamaño)");
            return false;
        } catch (NullPointerException e) {
            System.out.println("Operacion invalida, falta un dato (tamaño)");
            return false;
        }
        try {
            pId = Integer.parseInt(word[2]);
        } catch(NumberFormatException e) {
            System.out.println("Operacion invalida, no es un numero (id)");
            return false;
        } catch (NullPointerException e) {
            System.out.println("Operacion invalida, falta un dato (id)");
            return false;
        }
        return true;
    }
}
