/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package finaloperativos;

<<<<<<< HEAD
import java.text.SimpleDateFormat;
import java.util.Calendar;
=======
import java.lang.reflect.Array;
import java.util.LinkedList;
>>>>>>> b0c3a08214ba5a3f7e81612d5c546266d0fa8b3d

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
    
<<<<<<< HEAD
    public void liberar(int id){
        
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
=======
    public void accesar(int direccion, int id, boolean mod, LinkedList<proceso> listaProcesos){
        int numeroPagina;
        
        numeroPagina=(direccion/8);
    }
    
    public static void liberar(int id){
        for(int i = 0; i < 2048;i += 8 ){
            if (id == memprincipal() ){
                
>>>>>>> b0c3a08214ba5a3f7e81612d5c546266d0fa8b3d
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
    
}
