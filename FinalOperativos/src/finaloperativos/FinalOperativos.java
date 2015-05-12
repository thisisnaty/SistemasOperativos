/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package finaloperativos;

import java.io.IOException;
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
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
// TODO code application logic here
        
        new LeeArchivo("Pruebas.txt");
        
        Calendar cal = Calendar.getInstance();
        cal.getTime();
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        System.out.println( sdf.format(cal.getTime()) );
    }
    
}
