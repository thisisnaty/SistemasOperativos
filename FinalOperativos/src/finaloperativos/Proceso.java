/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finaloperativos;

import java.util.Calendar;

/**
 *
 * @author nataliagarcia
 */
public class Proceso {
    private int id;
    private int numPaginas;
    private int tamano;
    private Pagina[] arrPaginas;
    private Calendar tiempoLlegada;
    private long turnaround;
    private Calendar terminacion;
    
    public Proceso(int id, int tamano) {
        this.id = id;
        this.tamano = tamano;
        if(this.tamano%8 != 0){
            this.numPaginas = tamano/8 + 1;
        }
        else{
            this.numPaginas = tamano/8;
        }
        this.arrPaginas = new Pagina[numPaginas];
        this.tiempoLlegada = Calendar.getInstance();
        this.tiempoLlegada.getTime();
        this.turnaround = 0;
        this.terminacion = null;
    }
    
    // Metodos para obtener los datos del proceso
    public long getTurnaround() {
        return (tiempoLlegada.getTimeInMillis() - terminacion.getTimeInMillis());
    }
    public Calendar getTerminacion() {
        return terminacion;
    }
    public int getId() {
        return id;
    }
    public int getNumPaginas() {
        return numPaginas;
    }
    public int getTamano() {
        return tamano;
    }
    public Pagina[] getArrPaginas() {
        return arrPaginas;
    }
    public Calendar getTiempoLlegada() {
        return tiempoLlegada;
    }
    
    // Metodos para modificar los datos del proceso
    public void setNumPaginas(int numPaginas) {
        this.numPaginas = numPaginas;
    }
    public void setTerminacion(Calendar terminacion) {
        this.terminacion = terminacion;
    }
}