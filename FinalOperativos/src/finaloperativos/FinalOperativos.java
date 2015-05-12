/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package finaloperativos;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Calendar;



/**
 *
 * @author Equipo 6
 */
public class FinalOperativos {
    public static void proceso(String line) {
        
    }
    
    public static void acceso(String line) {
        
    }
    
    public static void liberar(String line) {
        
    }
    
    public static  void fin() {
        
    }
    
    public static void leeArchivo() throws IOException {
        BufferedReader fileIn;
        try {
            fileIn = new BufferedReader(new FileReader("Pruebas.txt"));
            
        } catch (FileNotFoundException e){
            File prueba = new File("Pruebas.txt");
            try (PrintWriter fileOut = new PrintWriter(prueba)) {
                fileOut.println("demo");
                fileOut.close();
            }
            fileIn = new BufferedReader(new FileReader("Pruebas.txt"));
        }
        
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
            
            else if (line.charAt(0) == 'E')
                break;
            
            else
                System.out.println("Error en la instruccion");
            
            line = fileIn.readLine();
        }
        
        fileIn.close();
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
// TODO code application logic here
        
        leeArchivo();
        
        Calendar cal = Calendar.getInstance();
        cal.getTime();
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        System.out.println( sdf.format(cal.getTime()) );
    }
    
}
