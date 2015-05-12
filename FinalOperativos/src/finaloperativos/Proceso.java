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
    private double turnaround;
    
    public Proceso(int id, int tamano) {
        this.id = id;
        this.tamano = tamano;
    }

    public double getTurnaround() {
        return turnaround;
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

    public void setId(int id) {
        this.id = id;
    }

    public void setNumPaginas(int numPaginas) {
        this.numPaginas = numPaginas;
    }

    public void setTamano(int tamano) {
        this.tamano = tamano;
    }

    public void setArrPaginas(Pagina[] arrPaginas) {
        this.arrPaginas = arrPaginas;
    }

    public void setTiempoLlegada(Calendar tiempoLlegada) {
        this.tiempoLlegada = tiempoLlegada;
    }

    public void setTurnaround(double turnaround) {
        this.turnaround = turnaround;
    }
    
}
