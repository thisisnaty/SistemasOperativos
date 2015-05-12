/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
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
    Procedimiento p;
    String nombreArchivo;
    Scanner scan;
    Scanner scan2;
    LinkedList<Proceso> lklProcesos;
    int pId;
    int pTam;
    String line;
    String[] word;
    
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
                            Proceso proceso = new Proceso(pId, pTam);
                            p.procP(proceso);
                        }
                        else {
                            //ALGO
                        }
                        break;
                    case "A":
                        //A direccion id bitMod
                        break;
                    case "L":
                        //L id
                        break;
                    case "F":
                        //reporte
                        //TU de cada proceso, TU promedio, page fault x proceso, swaps in, swaps out
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
    
    boolean checaP() {
        boolean tamano = false;
        try {
            pTam = Integer.parseInt(word[1]);
            tamano = true;
        } catch(NumberFormatException e) {
            System.out.println("Operacion invalida, no es un numero (tamaño)");
            tamano = false;
        }
        if (tamano) {
            boolean numId = false;
            try {
                pId = Integer.parseInt(word[2]);
                numId = true;
            } catch(NumberFormatException e) {
                System.out.println("Operacion invalida, no es un numero (id)");
                numId = false;
            }
            if (numId) {
                return true;
            }
        }
        return false;
    }
}
