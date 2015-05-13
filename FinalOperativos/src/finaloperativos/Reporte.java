/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finaloperativos;

import java.util.LinkedList;

/**
 *
 * @author Aletsdelarosa
 */
public class Reporte {
    //TU de cada proceso, TU promedio, page fault x proceso, swaps in, swaps out
    double[] turnaround;
    double tuPromedio;
    int[] pagefault;
    int swapsIn;
    int swapsOut;
    int cantProcesos;
    LinkedList<Proceso> procesos;
    
    public Reporte() {
        
    }

    public double[] getTurnaround() {
        return turnaround;
    }

    public double getTuPromedio() {
        return tuPromedio;
    }

    public int[] getPagefault() {
        return pagefault;
    }

    public double getSwapsIn() {
        return swapsIn;
    }

    public double getSwapsOut() {
        return swapsOut;
    }

    public void setTurnaround(double[] turnaround) {
        this.turnaround = turnaround;
    }

    public void setTuPromedio(double tuPromedio) {
        this.tuPromedio = tuPromedio;
    }

    public void setPagefault(int[] pagefault) {
        this.pagefault = pagefault;
    }

    public void setSwapsIn(int swapsIn) {
        this.swapsIn = swapsIn;
    }

    public void setSwapsOut(int swapsOut) {
        this.swapsOut = swapsOut;
    }
    
    @Override
    public String toString() {
        //TU de cada proceso, TU promedio, page fault x proceso, swaps in, swaps out
        for(Object proceso: LinkedList<Proceso> lklProcesos) {
            
        }
        return "";
    }
    
}
