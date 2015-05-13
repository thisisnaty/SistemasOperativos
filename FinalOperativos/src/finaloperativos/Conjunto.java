/*
    Guarda toda la informacion generada por un conjunto de instrucciones
    Guarda el turnarround acumulado de los procesos, el num de procesos
    terminados, cantidad de page faults, swaps in y out y calcula el 
    turnarround promedio.
 */

package finaloperativos;

/**
 *Conjunto
 * La clase <code>Conjunto</code> almacena los datos que se imprimen en el reporte
 * cuando se hace la instruccion F 
 * @author Enrique
 */
public class Conjunto {
    int cantProcesosTerminados;     //cuantos procesos fueron terminados en este conjunto de instrucciones
    int cantPageFaults;     //cuandos fallos de página hubieron en este conjunto de instrucciones
    int cantSwapsIn;        //cuantos swaps in hubieron en este conjunto de instrucciones  
    int cantSwapsOut;       //cuantos swaps out hubieron en este conjunto de instrucciones
    long turnAroundAcum;    //cual fue el turnaround de cada proceso en este conjunto de instrucciones
    long turnAroundPromedio;    //cual fue el turnaround promedio en este conjunto de instrucciones
    
    public Conjunto(){
        //se inicializan todas las variables en 0 para que se vayan incrementando conforme se hacen
        //las instrucciones del conjunto
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
        if(cantProcesosTerminados > 0){
        return this.turnAroundAcum/this.cantProcesosTerminados;
        }
        return 0;
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
