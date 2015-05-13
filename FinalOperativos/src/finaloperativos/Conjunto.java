/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package finaloperativos;

/**
 *
 * @author Enrique
 */
public class Conjunto {
    int cantProcesos;
    int cantPageFaults;
    int cantSwapsIn;
    int cantSwapsOut;
    long turnAroundAcum;
    long turnAroundPromedio;
    
    public Conjunto()
    {
        this.cantProcesos = 0;
        this.cantPageFaults = 0;
        this.cantSwapsIn = 0;
        this.cantSwapsOut = 0;
        this.turnAroundAcum = 0;
        this.turnAroundPromedio = 0;
    }

    public int getCantProcesos() {
        return cantProcesos;
    }

    public void ActualCantProcesos() {
        this.cantProcesos += 1;
    }

    public int getCantPageFaults() {
        return cantPageFaults;
    }

    public void setCantPageFaults(int cantPageFaults) {
        this.cantPageFaults = cantPageFaults;
    }

    public int getCantSwapsIn() {
        return cantSwapsIn;
    }

    public void setCantSwapsIn(int cantSwapsIn) {
        this.cantSwapsIn = cantSwapsIn;
    }

    public int getCantSwapsOut() {
        return cantSwapsOut;
    }

    public void setCantSwapsOut(int cantSwapsOut) {
        this.cantSwapsOut = cantSwapsOut;
    }

    public long getTurnAroundAcum() {
        return turnAroundAcum;
    }

    public void setTurnAroundAcum(long turnAroundAcum) {
        this.turnAroundAcum += turnAroundAcum;
    }

    public long getTurnAroundPromedio() {
        return turnAroundPromedio;
    }

    public void setTurnAroundPromedio(long turnAroundPromedio) {
        this.turnAroundPromedio = turnAroundPromedio;
    }  
}
