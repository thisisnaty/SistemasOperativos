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
import java.util.LinkedList;


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
        p.setTiempoLlegada(cal.getTime());
        
    }
    

    public void liberar(int id, Conjunto con, LinkedList <Proceso> lklProcesos){
        
        // para el reloj
        Calendar actual = Calendar.getInstance();
        actual.getTime();
        long turnarround = (future.getTimeInMillis() - actual.getTimeInMillis());
        
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
