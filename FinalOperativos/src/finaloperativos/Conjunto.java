/*
    Guarda toda la informacion generada por un conjunto de instrucciones
    Guarda el turnarround acumulado de los procesos, el num de procesos
    terminados, cantidad de page faults, swaps in y out y calcula el 
    turnarround promedio.
 */

package finaloperativos;

/**
 *
 * @author Enrique
 */
public class Conjunto {
    int cantProcesosTerminados;
    int cantPageFaults;
    int cantSwapsIn;
    int cantSwapsOut;
    long turnAroundAcum;
    long turnAroundPromedio;
    
    public Conjunto(){
        this.cantProcesosTerminados = 0;
        this.cantPageFaults = 0;
        this.cantSwapsIn = 0;
        this.cantSwapsOut = 0;
        this.turnAroundAcum = 0;
        this.turnAroundPromedio = 0;
    }
    
    // Regresa los atributos
    public int getCantProcesosTerminados() {
        return cantProcesosTerminados;
    }
    public int getCantPageFaults(){
        return cantPageFaults;
    }
    public int getCantSwapsIn() {
        return cantSwapsIn;
    }
    public int getCantSwapsOut() {
        return cantSwapsOut;
    }
    public long getTurnAroundPromedio() {
        return this.turnAroundAcum/this.cantProcesosTerminados;
    }
    // Agrega 1 a los procesos terminados
    public void ActualCantProcesosTerminados() {
        this.cantProcesosTerminados += 1;
    }
    // Agrega 1 a los page faults
    public void setCantPageFaults() {
        this.cantPageFaults += 1;
    }
    // Aumenta los swaps in en 1
    public void setCantSwapsIn() {
        this.cantSwapsIn += 1;
    }
    // Aumenta en 1 los swap Out
    public void setCantSwapsOut() {
        this.cantSwapsOut += 1;
    }
    // Muestra el turnarround acumulado de los procesos terminados
    public long getTurnAroundAcum() {
        return turnAroundAcum;
    }
    // Le suma el turnarround de un proceso
    public void setTurnAroundAcum(long turnAroundAcum) {
        this.turnAroundAcum += turnAroundAcum;
    } 
}
