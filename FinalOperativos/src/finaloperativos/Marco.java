/*
    Clase de un marco de pagina de la memoria. 
    Contiene el tamano del marco, bit de modificacion, bit de referencia
    id del proceso al que pertenece y numero de pagina virtual 
    al que corresponde.
 */
package finaloperativos;

/**
 *
 * @author Aletsdelarosa
 */
public class Marco {
    private int tam;
    private boolean mod;
    private boolean ref;
    private int idProceso;
    private int nPagina;
    
    public Marco(){
        this.tam = 8;
        this.mod = false;
        this.ref = false;
        this.idProceso = -1;
        this.nPagina = 0;
    }
    
    // Funciones para leer los atributos del objeto
    public int getTam(){
        return this.tam;
    }
    public boolean getMod(){
        return this.mod;
    }
    public boolean getRef(){
        return this.ref;
    }
    public int getID(){
        return this.idProceso;
    }
    public int getnPag(){
        return this.nPagina;
    }
    
    // Funciones para modificar los atributos del objeto
    public void setMod(boolean mod){
        this.mod = mod;
    }
    public void setRef(boolean ref){
        this.ref = ref;
    }
    public void setId(int id){
        this.idProceso = id;
    }
    public void setnPag(int pag){
        this.nPagina = pag;
    }
}
