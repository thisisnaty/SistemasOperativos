/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finaloperativos;

/**
 *
 * @author nataliagarcia
 */
public class Proceso {
    private int id;
    private int numPaginas;
    private int tamano;
    private Pagina[] arrPaginas;
    double tiempoLlegada;
    
    public Proceso(int id, int tamano) {
        this.id = id;
        this.tamano = tamano;
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

    public double getTiempoLlegada() {
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

    public void setTiempoLlegada(double tiempoLlegada) {
        this.tiempoLlegada = tiempoLlegada;
    }
    
    
}
