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
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;

/**
 *
 * @author nataliagarcia
 */
public class LeeArchivo {
    public LeeArchivo (String nombeArchivo) throws FileNotFoundException, IOException {
        BufferedReader fileIn = null;
        boolean leido = false;
        try {
            fileIn = new BufferedReader(new FileReader(nombeArchivo));
            leido = true;
        } catch (FileNotFoundException e){
            System.out.println("No existe el archivo de nombre " + nombeArchivo);
            leido = false;
        }
        if (leido) {
            //dato will be used to read each line of the file
            String line = fileIn.readLine();
            while (line != null) {
                
                if (line.charAt(0)== 'P') {
                    proceso(line);
                }
                
                else if (line.charAt(0)== 'A') {
                    acceso(line);
                }
                
                else if (line.charAt(0) == 'L') {
                    liberar(line);
                }
                
                else if (line.charAt(0) == 'F') {
                    fin();
                }
                
                else if (line.charAt(0) == 'E') {
                    break;
                }
                
                else {
                    System.out.println("Error en la instruccion");
                }
                
                line = fileIn.readLine();
            }
            
            fileIn.close();
        }
    }
}
