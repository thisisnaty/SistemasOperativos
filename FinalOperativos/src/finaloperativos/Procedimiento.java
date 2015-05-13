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
import java.util.Iterator;
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
        //p.setTiempoLlegada(cal.getTime());
        boolean cabeEnMemPrinc = false;
        List<Integer> marcosLibres = new ArrayList<Integer>();
        List<Integer> marcosLibresMemSec = new ArrayList<Integer>();
        
        if(p.getTamano()%8!=0){
            p.setNumPaginas((p.getTamano()/8)+1 );
        }
        else{ 
            p.setNumPaginas((p.getTamano()/8));
        }
        
        int cantMarcosLibres = 0;
        for(int i = 0; (i < 256) && (cantMarcosLibres<p.getNumPaginas()); i++){
            if(memPrincipal[i].getID()==-1){
                cantMarcosLibres++;
                marcosLibres.add(i);
            }
        }
        
        cabeEnMemPrinc = (cantMarcosLibres>=p.getNumPaginas()) ? true : false;
        
        if(cabeEnMemPrinc){
            int cont; 
            int pCont = 0;
            while(marcosLibres.iterator().hasNext()){
                //TODO
                //CHECAR QUE EL ITERADOR SI ESTE SACANDO EN ORDEN ASCENDENTE
                
                cont = marcosLibres.iterator().next();
                memPrincipal[cont].setID(p.getId());
                memPrincipal[cont].setnPag(pCont);
                pCont++;
            }
        }else{
            //liberar espacios de memoria en mem principal hasta que haya
            //espacio suficiente
            
            boolean prioridad1= true, prioridad2=false, prioridad3 = false, prioridad4 = false;
            int liberados = 0;
            int totalLibres = liberados + cantMarcosLibres;
            
            //sacar procesos mientras totalLibres sea menor a num de pag del proc
            for(int i = 0; (i<256) &&(totalLibres<p.getNumPaginas()); i++){
                
                //opcion1, dos bits de ref y mod son 0
                if(prioridad1 && !memPrincipal[i].getRef() && !memPrincipal[i].getMod()){
                    int j = 0;
                    //acomodar en el primer lugar que se encuentre en mem sec
                    while(memSecundaria[j].getID()!=-1){
                        j++;
                    }
                    memSecundaria[j].setID(memPrincipal[i].getID());
                    memSecundaria[j].setnPag(memPrincipal[i].getnPag());
                    marcosLibres.add(i);
                    memPrincipal[i].setID(-1);
                    memPrincipal[i].setRef(false);
                    memPrincipal[i].setMod(false);
                    liberados++;
                }//opcion2, bit de ref es 1 y bit de mod es 0
                else if (prioridad2 && memPrincipal[i].getRef() && !memPrincipal[i].getMod()){
                    int j = 0;
                    //acomodar en el primer lugar que se encuentre en mem sec
                    while(memSecundaria[j].getID()!= -1){
                        j++;
                    }
                    memSecundaria[j].setID(memPrincipal[i].getID());
                    memSecundaria[j].setnPag(memPrincipal[i].getnPag());
                    marcosLibres.add(i);
                    memPrincipal[i].setID(-1);
                    memPrincipal[i].setRef(false);
                    memPrincipal[i].setMod(false);
                    liberados++;                    
                }//opcion3, bit de ref es 0 y bit de mod es 1
                else if (prioridad3 && !memPrincipal[i].getRef() && memPrincipal[i].getMod()){
                    int j = 0;
                    //acomodar en el primer lugar que se encuentre en mem sec
                    while(memSecundaria[j].getID()!= -1){
                        j++;
                    }
                    memSecundaria[j].setID(memPrincipal[i].getID());
                    memSecundaria[j].setnPag(memPrincipal[i].getnPag());
                    marcosLibres.add(i);
                    memPrincipal[i].setID(-1);
                    memPrincipal[i].setRef(false);
                    memPrincipal[i].setMod(false);
                    liberados++;
                }//opcion4, bit de ref es 1 y bit de mod es 1
                else if (prioridad4 && !memPrincipal[i].getRef() && memPrincipal[i].getMod()){
                    int j = 0;
                    //acomodar en el primer lugar que se encuentre en mem sec
                    while(memSecundaria[j].getID()!= -1){
                        j++;
                    }
                    memSecundaria[j].setID(memPrincipal[i].getID());
                    memSecundaria[j].setnPag(memPrincipal[i].getnPag());
                    marcosLibres.add(i);
                    memPrincipal[i].setID(-1);
                    memPrincipal[i].setRef(false);
                    memPrincipal[i].setMod(false);
                    liberados++;
                }
                totalLibres = liberados + cantMarcosLibres;
                
                //si no encontro procesos con la mayor prioridad, ir a la sig.
                //prioridad
                if(i == 255 && (totalLibres < p.getNumPaginas())){
                    if(prioridad1){
                        i=0;
                        prioridad1 = false;
                        prioridad2 = true;
                    }else if (prioridad2){
                        i=0;
                        prioridad2 = false;
                        prioridad3 = true;
                    }else if (prioridad3) {
                        i=0;
                        prioridad3 = false;
                        prioridad4 = true;
                    }else{
                        System.out.println("error, no hay memoria suficiente");
                        break;
                    }
                }
            }
             while(marcosLibres.iterator().hasNext()){
                 
                int cont; 
                int pCont = 0;
                cont = marcosLibres.iterator().next();
                memPrincipal[cont].setID(p.getId());
                memPrincipal[cont].setnPag(pCont);
                pCont++;
            }
            
            //mandar swaps, page fault
            
        }
        

    }
    
    // Metodo que libera la memoria asignada a un proceso:
    // Entra el id del proceso, el conjunto que guarda los datos,
    // Una lista encadenada con los procesos
    // El metodo libera la memoria, calcula el turnarround y lo guarda
    // en el proceso y en el conjunto y muestra que marcos fueron liberados.
    public void liberar(int id, Conjunto con, LinkedList <Proceso> lklProcesos){
        
        // Variable que guarda si esta el proceso o no
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
        int numeroPagina;
        
        numeroPagina=(direccion/8);
    }  
}
