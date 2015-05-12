/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package finaloperativos;

import static finaloperativos.FinalOperativos.acceso;
import static finaloperativos.FinalOperativos.fin;
import static finaloperativos.FinalOperativos.liberar;
import static finaloperativos.FinalOperativos.proceso;
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
    String nombreArchivo;
    Scanner scan;
    Scanner scan2;
    LinkedList<Proceso> lklProcesos;
    
    public LeeArchivo (String nombreArchivo) {
        this.nombreArchivo = nombreArchivo;
        scan = null;
        scan2 = null;
        lklProcesos = new LinkedList();
    }
    
    void leer() throws FileNotFoundException, IOException{
        
        boolean leido = false;
        try {
            scan = new Scanner(new File(nombreArchivo));
            scan2 = new Scanner(new File(nombreArchivo));
            leido = true;
        } catch (FileNotFoundException e){
            System.out.println("No existe el archivo de nombre " + nombreArchivo);
            leido = false;
        }
        if (leido) {
            //dato will be used to read each line of the file
            String line = scan.nextLine();
            String word;
            
            while (!line.equals("E")) {
                
                word = scan2.next();
                
                if (word.equals("P")) {
                    if (checaP(word, line))
                        //p tamaño id
                        proceso(line);
                }
                
                
                else if (line.charAt(0)== 'A') {
                    //A direccion id bitMod
                    acceso(line);
                }
                
                else if (line.charAt(0) == 'L') {
                    //L id
                    liberar(line);
                }
                
                else if (line.charAt(0) == 'F') {
                    //reporte
                    //TU de cada proceso, TU promedio, page fault x proceso, swaps in, swaps out
                    fin();
                }
                
                else if (line.charAt(0) != 'E') {
                    System.out.println("Error en la instruccion");
                }
                
                line = scan.nextLine();
            }
            
            scan.close();
        }
    }
    boolean checaP(String word, String line) {
        word = scan2.next();
        boolean tamano = false;
        int tam;
        try {
            tam = Integer.parseInt(word);
            tamano = true;
        } catch(NumberFormatException e) {
            System.out.println("Operacion invalida, no es un numero (tamaño)");
            tamano = false;
            word = scan.nextLine();
            line = scan.nextLine();
        }
        if (tamano) {
            word = scan2.next();
            int id;
            boolean numId = false;
            try {
                id = Integer.parseInt(word);
                numId = true;
            } catch(NumberFormatException e) {
                System.out.println("Operacion invalida, no es un numero (id)");
                numId = false;
                word = scan.nextLine();
                line = scan.nextLine();
            }
            if (numId) {
                return true;
            }
        }
        return false;
    }
}
