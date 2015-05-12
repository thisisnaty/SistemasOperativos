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
public class Pagina {
    private boolean bitRef;
    private boolean bitMod;
    private boolean bitResidencia;
    private int marco;
    
    public Pagina() {
        bitRef = false;
        bitMod = false;
        bitResidencia = false;
    }

    public void setBitRef(boolean bitRef) {
        this.bitRef = bitRef;
    }

    public void setBitMod(boolean bitMod) {
        this.bitMod = bitMod;
    }

    public void setBitResidencia(boolean bitResidencia) {
        this.bitResidencia = bitResidencia;
    }

    public void setMarco(int marco) {
        this.marco = marco;
    }

    public boolean getBitRef() {
        return bitRef;
    }

    public boolean getBitMod() {
        return bitMod;
    }

    public boolean getBitResidencia() {
        return bitResidencia;
    }

    public int getMarco() {
        return marco;
    }
    
    
}
