/*
    Clase memoria que contiene un arreglo de marcos de 8 bytes cada marco
 */
package finaloperativos;

/**
 *
 * @author Aletsdelarosa
 */
public class Memoria {
    
    private int tam;
    private Marco[] arrMarcos;
    
    // Construye un objeto dado el tamano de la memoria
    public Memoria(int tam){
        this.tam = tam;
        this.arrMarcos = new Marco[tam/8];
    } 
}
