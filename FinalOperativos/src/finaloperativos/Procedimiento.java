/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package finaloperativos;

import java.lang.reflect.Array;
import java.util.LinkedList;

/**
 *
 * @author Enrique
 */
public class Procedimiento {
     
    int[] memPrincipal = new int[2048];
    int[] memSecundaria = new int[4096];
    
    public void procP(Proceso p){
        
    }
    
    public void accesar(int direccion, int id, boolean mod, LinkedList<proceso> listaProcesos){
        int numeroPagina;
        
        numeroPagina=(direccion/8);
    }
    
    public static void liberar(int id){
        for(int i = 0; i < 2048;i += 8 ){
            if (id == memprincipal() ){
                
            }
                
        }
    }
    
}
