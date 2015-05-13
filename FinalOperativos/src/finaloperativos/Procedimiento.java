/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finaloperativos;

import java.util.Calendar;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Enrique
 */
public class Procedimiento extends FinalOperativos {

    private Marco[] memPrincipal;
    private Marco[] memSecundaria;

    // Crea los arreglos de la memoria
    public Procedimiento() {
        memPrincipal = new Marco[256];
        memSecundaria = new Marco[512];
        for (int i = 0; i < 256; i++) {
            memPrincipal[i] = new Marco();
            memSecundaria[i] = new Marco();
        }
        
        for (int i = 256; i <512; i++){
            memSecundaria[i] = new Marco();
        }
    }

    // Metodo que mete un proceso a memoria principal, entra el proceso,
    // y el conjunto para actualizar estadisticas.
    // El metodo hace swap out si no hay memoria principal disponible utilizando
    // bit de referencia y bit de modificacion.
    public void procP(Proceso p, Conjunto con) {
        //p.setTiempoLlegada(cal.getTime());
        boolean cabeEnMemPrinc = false;
        List<Integer> marcosLibres = new ArrayList<Integer>();
        List<Integer> marcosLibresMemSec = new ArrayList<Integer>();

        if (p.getTamano() % 8 != 0) {
            p.setNumPaginas((p.getTamano() / 8) + 1);
        } else {
            p.setNumPaginas((p.getTamano() / 8));
        }

        int cantMarcosLibres = 0;

        for (int i = 0; (i < 256) && (cantMarcosLibres < p.getNumPaginas()); i++) {
            if (memPrincipal[i].getID() == -1) {
                cantMarcosLibres++;
                marcosLibres.add(i);
            }
        }
        
        memPrincipal[255].getID();
        p.getId();
        System.out.println("Se utilizaron los siguientes marcos de pagina: ");
        cabeEnMemPrinc = (cantMarcosLibres >= p.getNumPaginas());
        int tm = cantMarcosLibres;

        if (cabeEnMemPrinc) {
            int cont = 0;
            int pCont = 0;
            
            for(int i = 0; i < cantMarcosLibres; i++) {
                //TODO
                //CHECAR QUE EL ITERADOR SI ESTE SACANDO EN ORDEN ASCENDENTE
                cont = marcosLibres.get(i);
                memPrincipal[cont].setID(p.getId());
                memPrincipal[cont].setnPag(pCont);
                System.out.print("" + cont + " ");
                pCont++;
            }
            marcosLibres.clear();
            System.out.println("");
        } else {
            //SWAPS
            //liberar espacios de memoria en mem principal hasta que haya
            //espacio suficiente

            boolean prioridad1 = true, prioridad2 = false, prioridad3 = false, prioridad4 = false;
            int totalLibres = cantMarcosLibres;

            //sacar procesos mientras totalLibres sea menor a num de pag del proc
            for (int i = 0; (i < 256) && (totalLibres < p.getNumPaginas()); i++) {
                //opcion1, dos bits de ref y mod son 0
                if (prioridad1 && !memPrincipal[i].getRef() && !memPrincipal[i].getMod()) {
                    int j = 0;
                    //acomodar en el primer lugar que se encuentre en mem sec
                    while (memSecundaria[j].getID() != -1) {
                        j++;
                    }
                    memSecundaria[j].setID(memPrincipal[i].getID());
                    memSecundaria[j].setnPag(memPrincipal[i].getnPag());
                    marcosLibres.add(i);
                    memPrincipal[i].setID(-1);
                    memPrincipal[i].setRef(false);
                    memPrincipal[i].setMod(false);
                    totalLibres++;
                    con.setCantSwapsOut();
                }//opcion2, bit de ref es 1 y bit de mod es 0
                else if (prioridad2 && memPrincipal[i].getRef() && !memPrincipal[i].getMod()) {
                    int j = 0;
                    //acomodar en el primer lugar que se encuentre en mem sec
                    while (memSecundaria[j].getID() != -1) {
                        j++;
                    }
                    memSecundaria[j].setID(memPrincipal[i].getID());
                    memSecundaria[j].setnPag(memPrincipal[i].getnPag());
                    marcosLibres.add(i);
                    memPrincipal[i].setID(-1);
                    memPrincipal[i].setRef(false);
                    memPrincipal[i].setMod(false);
                    totalLibres++;
                    con.setCantSwapsOut();
                }//opcion3, bit de ref es 0 y bit de mod es 1
                else if (prioridad3 && !memPrincipal[i].getRef() && memPrincipal[i].getMod()) {
                    int j = 0;
                    //acomodar en el primer lugar que se encuentre en mem sec
                    while (memSecundaria[j].getID() != -1) {
                        j++;
                    }
                    memSecundaria[j].setID(memPrincipal[i].getID());
                    memSecundaria[j].setnPag(memPrincipal[i].getnPag());
                    marcosLibres.add(i);
                    memPrincipal[i].setID(-1);
                    memPrincipal[i].setRef(false);
                    memPrincipal[i].setMod(false);
                    totalLibres++;
                    con.setCantSwapsOut();
                }//opcion4, bit de ref es 1 y bit de mod es 1
                else if (prioridad4 && !memPrincipal[i].getRef() && memPrincipal[i].getMod()) {
                    int j = 0;
                    //acomodar en el primer lugar que se encuentre en mem sec
                    while (memSecundaria[j].getID() != -1) {
                        j++;
                    }
                    memSecundaria[j].setID(memPrincipal[i].getID());
                    memSecundaria[j].setnPag(memPrincipal[i].getnPag());
                    marcosLibres.add(i);
                    memPrincipal[i].setID(-1);
                    memPrincipal[i].setRef(false);
                    memPrincipal[i].setMod(false);
                    totalLibres++;
                    con.setCantSwapsOut();
                }

                //si no encontro procesos con la mayor prioridad, ir a la sig.
                //prioridad
                if (i == 255 && (totalLibres < p.getNumPaginas())) {
                    if (prioridad1) {
                        i = 0;
                        prioridad1 = false;
                        prioridad2 = true;
                    } else if (prioridad2) {
                        i = 0;
                        prioridad2 = false;
                        prioridad3 = true;
                    } else if (prioridad3) {
                        i = 0;
                        prioridad3 = false;
                        prioridad4 = true;
                    } else {
                        System.out.println("error, no hay memoria suficiente");
                        break;
                    }
                }
            }
            // Mete las paginas a memoria
            
            for(int i = 0; i< marcosLibres.size(); i++){
                int cont = 0;
                int pCont = 0;
                cont = marcosLibres.get(i);
                memPrincipal[cont].setID(p.getId());
                memPrincipal[cont].setID(p.getId());
                pCont++;
                System.out.print("" + cont + " ");
            }
            System.out.print("\n");
            memPrincipal[0].getID();
            marcosLibres.clear();
        }
    }

    // Metodo que libera la memoria asignada a un proceso:
    // Entra el id del proceso, el conjunto que guarda los datos,
    // Una lista encadenada con los procesos
    // El metodo libera la memoria, calcula el turnarround y lo guarda
    // en el proceso y en el conjunto y muestra que marcos fueron liberados.
    public void liberar(int id, Conjunto con, LinkedList<Proceso> lklProcesos) {
        System.out.println("Liberar");
        // Variable que guarda si esta el proceso o no
        boolean proceso = false;

        // Checa si el proceso existe y si sigue vivo
        // Obtiene el tiempo de llegada del proceso
        for (Object objProceso : lklProcesos) {
            Proceso p = (Proceso) objProceso;
            if (p.getId() == id && p.getTurnaround() == 0) {
                proceso = true;
            }
        }
        // Si existe el proceso lo libera
        if (proceso) {
            // Variable que guarda el tiempo de llegada del proceso
            Calendar llegada = null;
            // Variable que guarda el proceso con ese id
            Proceso p = null;
            // indice del proceso dentro de la lista
            int index = 0;

            // Obtiene el tiempo de llegada y el index del proceso
            for (Object objProceso : lklProcesos) {
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
            long turnarround = (actual.getTimeInMillis() - llegada.getTimeInMillis());
            lklProcesos.get(index).setTerminacion(actual);
            con.ActualCantProcesosTerminados();
            con.setTurnAroundAcum(turnarround);

            // Checa las primeras 2048 localidades de memoria
            // Principal y secundaria y borra el ID si es del
            // Proceso
            System.out.print("Se liberaron los marcos: ");
            for (int i = 0; i < 256; i ++) {
                if (memPrincipal[i].getID() == id) {
                    memPrincipal[i].setID(-1);
                    System.out.print("" + i + " ");
                }

                if (memSecundaria[i].getID() == id) {
                    memSecundaria[i].setID(-1);
                }
            }

            System.out.println("que ocupaba el proceso " + id);

            // Checa las 2048 localidades faltantes de memoria
            // Secundaria
            for (int i = 256; i < 512; i++) {
                if (memSecundaria[i].getID() == id) {
                    memSecundaria[i].setID(-1);
                }
            }
        }
    }

    // Muestra los datos de termino de un conjunto de instrucciones
    // Recibe la lista de procesos del conjunto y el conjunto que guarda la
    // informacion
    public void fin(LinkedList<Proceso> lklProcesos, Conjunto con) {

        // Recorre la lista para obtener procesos sin terminar
        for (Object objProceso : lklProcesos) {
            Proceso p = (Proceso) objProceso;
            if (p.getTerminacion() == null) {
                System.out.println("ERROR - Se quedo cargando el proceso " + p.getId());
            }
        }

        // Muestra los datos del conjunto de instrucciones
        System.out.println("Fin. REPORTE DE SALIDA");
        for (Object objProceso : lklProcesos) {
            Proceso p = (Proceso) objProceso;
            if (p.getTerminacion() != null) {
                System.out.println("Turnarround del proceso " + p.getId()
                        + " = " + p.getTurnaround() + "ms");
            }
        }
        System.out.println("Procesos terminados: " + con.getCantProcesosTerminados());
        System.out.println("Page faults: " + con.getCantPageFaults());
        System.out.println("Swap ins: " + con.getCantSwapsIn());
        System.out.println("Swap out: " + con.getCantSwapsOut());
        System.out.println("Turnarround promedio: " + con.getTurnAroundPromedio() + "ms");
    }

    public void accesar(int direccion, int id, boolean modificacion, LinkedList<Proceso> listaProcesos, Conjunto con) {
       int numeroPagina;//dice el numero de paginas
        int marco = 0;
        boolean estaPrincipal;//dice si la pagina esta en memoria principal o no
        boolean estaVacio;//dice si hay un espacio vacio en la memoria principal
        boolean es00;//dice si en memoria principal los bits son 00
        boolean es01;//dice si en memoria principal los bits son 01
        boolean es10;//dice si en memoria principal los bits son 10
        boolean es11;//dice si en memoria principal los bits son 11
        es00 = false;//incializacion
        es01 = false;//incializacion
        es10 = false;//incializacion
        es11 = false;//incializacion
        estaPrincipal = false;//incializacion
        estaVacio = false;//incializacion
        numeroPagina = (direccion / 8);//incializacion
        
        for (Object objProceso : listaProcesos) {
            Proceso p = (Proceso) objProceso;
            if(p.getId() == id){
            if (direccion >= p.getTamano()) {
                System.out.println("ERROR - Direccion invalida");
            }
           
        else{
        for (int i = 0; i < 256; i++) {//checo si la pagina esta en memoria principal
            if (memPrincipal[i].getnPag() == numeroPagina && id == memPrincipal[i].getID()) {

                if (modificacion) {
                    memPrincipal[i].setMod(true);
                } else {
                    memPrincipal[i].setRef(true);
                
                estaPrincipal = true;
                }
                
                System.out.println("Direccion virtual: " + direccion);
                int direccionReal = (direccion % 8) + (i * 8);
                System.out.println("Direccion real: " + direccionReal);
            }
        }

        if (!estaPrincipal) {//verifico que no esta en memoria principal si no en secundaria
            for (int i = 0; i < 512; i++) {
                if (id == memSecundaria[i].getID() && memSecundaria[i].getnPag() == numeroPagina) {//checa en que lugar de memoria secundaria se encuentra
                    for (int j = 0; j < 256; j++) {//busca un lugar vacio en memoria principal
                        if (memPrincipal[j].getID() == (-1)) {//si lo encuentra copia el ID y el Num de pagina de secundaria a principal
                            System.out.println("Direccion virtual: " + direccion);
                            int direccionReal = (direccion % 8) + j * 8;
                            System.out.println("Direccion real: " + direccionReal);
                            System.out.println("Pagina " + memSecundaria[i].getnPag()
                                    + " del proceso " + memSecundaria[i].getID()
                                    + " que estaba en el marco " + i
                                    + " de Swaping movida al marco " + j
                                    + " de memoria real");
                            memPrincipal[j].setID(memSecundaria[i].getID());
                            memSecundaria[i].setID(-1);
                            memPrincipal[j].setnPag(memSecundaria[i].getnPag());
                            estaVacio = true;
                            con.setCantSwapsIn();
                            j = 256;
                            i = 512;
                        }
                    }

                    if (!estaVacio) { //checa si no se encontro un lugar vacio
                        for (int j = 0; j < 256; j++) { //busca un marco con bitref y bitmod =0
                            if (!memPrincipal[j].getRef() && !memPrincipal[j].getMod()) {
                                for (int k = 0; k < 512; k++) {//busco un lugar libre en memoria secundaria para la info que sacare
                                    if (memSecundaria[k].getID() == (-1)) {//copio lo que saque de memoria principal a memoria secundaria
                                        memSecundaria[k].setID(memPrincipal[j].getID());
                                        memSecundaria[k].setnPag(memPrincipal[j].getnPag());
                                        System.out.println("Direccion virtual: " + direccion);
                                        int direccionReal = (direccion % 8) + j * 8;
                                        System.out.println("Direccion real: " + direccionReal);
                                        // imprime pagina de swaping a principal
                                        System.out.println("Pagina " + numeroPagina
                                                + " del proceso " + id
                                                + " que estaba en el marco " + i
                                                + " de Swaping movida al marco " + j
                                                + " de memoria real");
                                        // imprime pagina de principal a swaping
                                        System.out.println("Pagina " + memSecundaria[k].getnPag()
                                                + " del proceso " + memSecundaria[k].getID()
                                                + " que estaba en el marco " + j
                                                + " de principal movida al marco " + k
                                                + " de Swaping");

                                        con.setCantSwapsIn();
                                        con.setCantSwapsOut();
                                        k = 512;
                                    }
                                }

                                memPrincipal[j].setID(memSecundaria[i].getID());//copio lo de memoria secundaria a memoria principal
                                memSecundaria[i].setID(-1);
                                memPrincipal[j].setnPag(memSecundaria[i].getnPag());
                                es00 = true;
                                marco = j;
                                j = 256;
                            }
                        }

                        if (!es00) {
                            for (int j = 0; j < 256; j++) {
                                if (memPrincipal[j].getRef() && !memPrincipal[j].getMod()) {
                                    for (int k = 0; k < 512; k++) {
                                        if (memSecundaria[k].getID() == (-1)) {
                                            memSecundaria[k].setID(memPrincipal[j].getID());
                                            memSecundaria[k].setnPag(memPrincipal[j].getnPag());
                                            System.out.println("Direccion virtual: " + direccion);
                                            int direccionReal = (direccion % 8) + j * 8;
                                            System.out.println("Direccion real: " + direccionReal);
                                            // imprime pagina de swaping a principal
                                            System.out.println("Pagina " + numeroPagina
                                                    + " del proceso " + id
                                                    + " que estaba en el marco " + i
                                                    + " de Swaping movida al marco " + j
                                                    + " de memoria real");
                                            // imprime pagina de principal a swaping
                                            System.out.println("Pagina " + memSecundaria[k].getnPag()
                                                    + " del proceso " + memSecundaria[k].getID()
                                                    + " que estaba en el marco " + j
                                                    + " de principal movida al marco " + k
                                                    + " de Swaping");

                                            con.setCantSwapsIn();
                                            con.setCantSwapsOut();
                                            k = 512;
                                        }
                                    }
                                    memPrincipal[j].setID(memSecundaria[i].getID());
                                    memSecundaria[i].setID(-1);
                                    memPrincipal[j].setnPag(memSecundaria[i].getnPag());
                                    es01 = true;
                                    marco = j;
                                    j = 256;
                                }
                            }
                        } else {
                            if (!es01) {
                                for (int j = 0; j < 256; j++) {
                                    if (!memPrincipal[j].getRef() && memPrincipal[j].getMod()) {
                                        for (int k = 0; k < 512; k++) {
                                            if (memSecundaria[k].getID() == (-1)) {
                                                memSecundaria[k].setID(memPrincipal[j].getID());
                                                memSecundaria[k].setnPag(memPrincipal[j].getnPag());
                                                System.out.println("Direccion virtual: " + direccion);
                                                int direccionReal = (direccion % 8) + j * 8;
                                                System.out.println("Direccion real: " + direccionReal);
                                                // imprime pagina de swaping a principal
                                                System.out.println("Pagina " + numeroPagina
                                                        + " del proceso " + id
                                                        + " que estaba en el marco " + i
                                                        + " de Swaping movida al marco " + j
                                                        + " de memoria real");
                                                // imprime pagina de principal a swaping
                                                System.out.println("Pagina " + memSecundaria[k].getnPag()
                                                        + " del proceso " + memSecundaria[k].getID()
                                                        + " que estaba en el marco " + j
                                                        + " de principal movida al marco " + k
                                                        + " de Swaping");

                                                con.setCantSwapsIn();
                                                con.setCantSwapsOut();
                                                k = 512;
                                            }
                                        }
                                        memPrincipal[j].setID(memSecundaria[i].getID());
                                        memSecundaria[i].setID(-1);
                                        memPrincipal[j].setnPag(memSecundaria[i].getnPag());
                                        es10 = true;
                                        marco = j;
                                        j = 256;
                                    }
                                }
                            } 
                            else {
                                for (int j = 0; j < 256; j++) {
                                    if (memPrincipal[j].getRef() && memPrincipal[j].getMod()) {
                                        for (int k = 0; k < 512; k++) {
                                            if (memSecundaria[k].getID() == (-1)) {
                                                memSecundaria[k].setID(memPrincipal[j].getID());
                                                memSecundaria[k].setnPag(memPrincipal[j].getnPag());
                                                System.out.println("Direccion virtual: " + direccion);
                                                int direccionReal = (direccion % 8) + j * 8;
                                                System.out.println("Direccion real: " + direccionReal);
                                                // imprime pagina de swaping a principal
                                                System.out.println("Pagina " + numeroPagina
                                                        + " del proceso " + id
                                                        + " que estaba en el marco " + i
                                                        + " de Swaping movida al marco " + j
                                                        + " de memoria real");
                                                // imprime pagina de principal a swaping
                                                System.out.println("Pagina " + memSecundaria[k].getnPag()
                                                        + " del proceso " + memSecundaria[k].getID()
                                                        + " que estaba en el marco " + j
                                                        + " de principal movida al marco " + k
                                                        + " de Swaping");

                                                con.setCantSwapsIn();
                                                con.setCantSwapsOut();
                                                k = 512;
                                            }
                                        }
                                        memPrincipal[j].setID(memSecundaria[i].getID());
                                        memSecundaria[i].setID(-1);
                                        memPrincipal[j].setnPag(memSecundaria[i].getnPag());
                                        marco = j;
                                        j = 256;
                                    }
                                }
                            }
                        }
                    }
                }
            }
            if (modificacion) {
                    memPrincipal[marco].setMod(true);
                } else {
                    memPrincipal[marco].setRef(true);
                }
        }
    }
    }
    }
    }
}
