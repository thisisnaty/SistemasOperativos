/*
    Sumulador de Manejador de Memoria Virtual que utiliza como metodo de 
    remplazo bit de modificacion y bit de referencia.
    Lee un archivo con instrucciones para el manejador.
    La memoria principal es de 2048 bytes con tamano de pagina 8 (256 paginas)
    La memoria secundaria es de 4096 bytes.
    Al solicitar cargar un proceso, se tiene que cargar completo a memoria.
*/
package finaloperativos;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;


public class FinalOperativos {
    static Calendar cal;
    
    public static void proceso(String line) {
        
    }
    
    public static void acceso(String line) {
        
    }
    
    public static void liberar(String line) {
        
    }
    
    public static  void fin() {
        
    }
    
    // Metodo principal del programa, aqui comienza la ejecucion
    public static void main(String[] args) throws IOException {
        
        // Crea un objeto encargado de leer el archivo de texto
        new LeeArchivo("Pruebas.txt");
        
        cal = Calendar.getInstance();
        cal.getTime();
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        System.out.println( sdf.format(cal.getTime()) );
    }
}
