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
     
    Marco[] memPrincipal = new Marco[256];
    Marco[] memSecundaria = new Marco[512];
    
    public Procedimiento() {
        
    }
    
    public void procP(Proceso p){
        
        p.setTiempoLlegada(cal.getTime());
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
            if(memPrincipal[i].getID()==-1){
                contMarcos++;
                marcosLibres.add(i);
            }
        }
        
        cabeEnMemPrinc = (contMarcos>=p.getNumPaginas()) ? true : false;
        
        if(cabeEnMemPrinc){
            int cont = 0; 
            while(cont<p.getNumPaginas()){
                for(int i = marcosLibres.get(cont); i < 8; i++){
                    memPrincipal[i].setID(p.getId());
                }
                cont++;
            }
        }else{
            
        }
        

    }
    
    // Metodo que libera la memoria asignada a un proceso:
    // Entra el id del proceso, el conjunto que guarda los datos,
    // Una lista encadenada con los procesos
    // El metodo libera la memoria, calcula el turnarround y lo guarda
    // en el proceso y en el conjunto y muestra que marcos fueron liberados.
    public void liberar(int id, Conjunto con, LinkedList <Proceso> lklProcesos){
        System.out.println("Liberar");
        // Variable que guarda si esta el proceso o no
        boolean proceso = false;
        
        // Checa si el proceso existe y si sigue vivo
        // Obtiene el tiempo de llegada del proceso
        for(Object objProceso: lklProcesos) {
            Proceso p = (Proceso) objProceso;
            if (p.getId() == id && p.getTurnaround() == 0) {
                proceso = true;
            }
        }
        // Si existe el proceso lo libera
        if(proceso){
            // Variable que guarda el tiempo de llegada del proceso
            Calendar llegada = null;
            // Variable que guarda el proceso con ese id
            Proceso p = null;
            // indice del proceso dentro de la lista
            int index = 0;
        
            // Obtiene el tiempo de llegada y el index del proceso
            for(Object objProceso: lklProcesos) {
                p = (Proceso) objProceso;
                if (p.getId() == id) {
                    llegada = p.getTiempoLlegada();
                    index = lklProcesos.indexOf(p);
                }
            }
            
            // Variable que guarda el tiempo actual
            Calendar actual = Calendar.getInstance();
            actual.getTime();
        
            // Calcula el turnarround
            long turnarround = (llegada.getTimeInMillis() - actual.getTimeInMillis());
            lklProcesos.get(index).setTurnaround(turnarround);
            con.ActualCantProcesos();
            con.setTurnAroundAcum(turnarround);
        
            // Checa las primeras 2048 localidades de memoria
            // Principal y secundaria y borra el ID si es del
            // Proceso
            System.out.print("Se liberaron los marcos: ");
            for (int i = 0; i < 2048; i += 8){
                if (memPrincipal[i].getID() == id){
                 memPrincipal[i].setID(-1);
                 System.out.print("" + i + " ");
                }
            
                if (memSecundaria[i].getID() == id){
                  memSecundaria[i].setID(-1);
                }
            }
            
            System.out.println("que ocupaba el proceso " + id);
        
            // Checa las 2048 localidades faltantes de memoria
            // Secundaria
            for (int i = 2048; i < 4096; i += 8){
                if (memSecundaria[i].getID() == id){
                 memSecundaria[i].setID(-1);
                }    
            }  
        }
        boolean proceso = false;
        
        // Checa si el proceso existe y si sigue vivo
        // Obtiene el tiempo de llegada del proceso
        for(Object objProceso: lklProcesos) {
            Proceso p = (Proceso) objProceso;
            if (p.getId() == id && p.getTerminacion() == null) {
                proceso = true;
            }
        }
        // Si existe el proceso lo libera
        if(proceso){
            // Variable que guarda el tiempo de llegada del proceso
            Calendar llegada = null;
            // Variable que guarda el proceso con ese id
            Proceso p = null;
            // indice del proceso dentro de la lista
            int index = 0;
        
            // Obtiene el tiempo de llegada y el index del proceso
            for(Object objProceso: lklProcesos) {
                p = (Proceso) objProceso;
                if (p.getId() == id) {
                    llegada = p.getTiempoLlegada();
                    index = lklProcesos.indexOf(p);
                }
            }
            
            // Variable que guarda el tiempo actual
            Calendar actual = Calendar.getInstance();
            actual.getTime();
        
            // Calcula el turnarround
            long turnarround = (llegada.getTimeInMillis() - actual.getTimeInMillis());
            lklProcesos.get(index).setTurnaround(turnarround);
            con.ActualCantProcesosTerminados();
            con.setTurnAroundAcum(turnarround);
        
            // Checa las primeras 2048 localidades de memoria
            // Principal y secundaria y borra el ID si es del
            // Proceso
            System.out.print("Se liberaron los marcos: ");
            for (int i = 0; i < 2048; i += 8){
                if (memPrincipal[i].getID() == id){
                 memPrincipal[i].setID(-1);
                 System.out.print("" + i + " ");
                }
            
                if (memSecundaria[i].getID() == id){
                  memSecundaria[i].setID(-1);
                }
            }
            
            System.out.println("que ocupaba el proceso " + id);
        
            // Checa las 2048 localidades faltantes de memoria
            // Secundaria
            for (int i = 2048; i < 4096; i += 8){
                if (memSecundaria[i].getID() == id){
                 memSecundaria[i].setID(-1);
                }    
            }  
        }
    }
    
    public void fin(LinkedList <Proceso> lklProcesos, Conjunto con){
        
    }
    
    public void accesar(int direccion, int id, boolean mod, LinkedList<Proceso> listaProcesos){
        System.out.println("Accesar");
        int numeroPagina;
        
        numeroPagina=(direccion/8);
    }  
}
