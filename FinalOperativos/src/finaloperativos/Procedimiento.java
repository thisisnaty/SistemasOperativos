/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package finaloperativos;

import java.lang.reflect.Array;

/**
 *
 * @author Enrique
 */
public class Procedimiento extends FinalOperativos{
     
    int[] memPrincipal = new int[2048];
    int[] memSecundaria = new int[4096];
    
    public void procP(Proceso p){
        p.setTiempoLlegada(cal.getTime());
        
    }
    
}
