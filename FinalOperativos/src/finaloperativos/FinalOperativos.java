/*
    Sumulador de Manejador de Memoria Virtual que utiliza como metodo de 
    remplazo bit de modificacion y bit de referencia.
    Lee un archivo con instrucciones para el manejador.
    La memoria principal es de 2048 bytes con tamano de pagina 8 (256 paginas)
    La memoria secundaria es de 4096 bytes.
    Al solicitar cargar un proceso, se tiene que cargar completo a memoria.
    Natalia Garcia A01191853
    Enrique Marroquin A01191578
    Edgar Manuel Rodriguez A00813416
    Alejandro de la Rosa A01381412
*/
package finaloperativos;

import java.io.IOException;

public class FinalOperativos {
    
    // Metodo principal del programa, aqui comienza la ejecucion
    public static void main(String[] args) throws IOException {
        
        // Crea un objeto encargado de leer el archivo de texto
        LeeArchivo x = new LeeArchivo("Pruebas2.txt");
        x.leer();
    }
}