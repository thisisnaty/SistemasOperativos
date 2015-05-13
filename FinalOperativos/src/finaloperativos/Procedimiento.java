/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package finaloperativos;


import finaloperativos.Proceso;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


/**
 *
 * @author Enrique
 */
public class Procedimiento extends FinalOperativos{
     
    int[] memPrincipal = new int[2048];
    int[] memSecundaria = new int[4096];
    
    public Procedimiento() {
        
    }
    
    public void procP(Proceso p){
        //p.setTiempoLlegada(cal.getTime());
        boolean cabeEnMemPrinc = false;
        List<Integer> marcosLibres = new ArrayList<Integer>();
        
        if(p.getTamano()%8!=0){
            p.setNumPaginas((p.getTamano()/8)+1 );
        }
        else{
            p.setNumPaginas((p.getTamano()/8));
        }
        
        int contMarcos = 0;
        for(int i = 0; i < 2048; i+=8){
            if(memPrincipal[i]==-1){
                contMarcos++;
                marcosLibres.add(i);
            }
        }
        
        cabeEnMemPrinc = (contMarcos>=p.getNumPaginas()) ? true : false;
        
        if(cabeEnMemPrinc){
            int cont = 0; 
            while(cont<p.getNumPaginas()){
                for(int i = marcosLibres.get(cont); i < 8; i++){
                    memPrincipal[i] = p.getId();
                }
                cont++;
            }
        }else{
            
        }
        

    }
    
    public void liberar(int id, Conjunto con, LinkedList <Proceso> lklProcesos){
        
        // Variable que guarda el tiempo de llegada del proceso
        Calendar llegada = null;
        
        // Variable que guarda el tiempo actual
        Calendar actual = Calendar.getInstance();
        actual.getTime();
        int contador = 0;
        // Obtiene el tiempo de llegada del proceso
        for(Object objProceso: lklProcesos) {
            Proceso p = (Proceso) objProceso;
            if (p.getId() == id) {
                llegada = p.getTiempoLlegada();
            }
        }
        
        // Calcula el turnarround
        long turnarround = (llegada.getTimeInMillis() - actual.getTimeInMillis());
        
        // Checa las primeras 2048 localidades de memoria
        // Principal y secundaria y borra el ID si es del
        // Proceso
        for (int i = 0; i < 2048; i += 8){
            if (memPrincipal[i] == id){
                memPrincipal[i] = -1;
            }
            
            if (memSecundaria[i] == id){
                memSecundaria[i] = -1;
            }
        }
        
        // Checa las 2048 localidades faltantes de memoria
        // Secundaria
        for (int i = 2048; i < 4096; i += 8){
            if (memSecundaria[i] == id){
                memSecundaria[i] = -1;
            }    
        }  
    }
    
    public void accesar(int direccion, int id, boolean mod, LinkedList<Proceso> listaProcesos){
        int numeroPagina;
        
        numeroPagina=(direccion/8);
    }
    
}
