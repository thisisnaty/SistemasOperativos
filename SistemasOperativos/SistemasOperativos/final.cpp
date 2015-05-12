//
//  final.cpp
//  SistemasOperativos
//
//  Created by Equipo 6 on 5/11/15.
//  Copyright (c) 2015 Equipo6. All rights reserved.
//

#include <iostream>
#include <vector>
#include <fstream>
#include <string>

using namespace std;

void instruccionProceso(string instruccion, int &ID, int &Tam)
{
    int posicion;
    // Borra la P y el primer espacio
    instruccion.erase(0,2);
    
    posicion = instruccion.find(" ");
    
    int exponente = 0;
    for (int i = posicion - 1; i >= 0; i--)
    {
        ID += (instruccion[i] - '0') * pow(10, exponente);
        exponente++;
    }
    
    instruccion.erase(0, posicion + 1);
    
    exponente = 0;
    for (int i = instruccion.length() - 1; i >= 0; i--)
    {
        Tam += (instruccion[i] - '0') * pow(10, exponente);
        exponente++;
    }
}

void instruccionAcceso(string instruccion, int &ID, int &Dir, int &Mod)
{
    int posicion;
    // Borra la P y el primer espacio
    instruccion.erase(0,2);
    
    posicion = instruccion.find(" ");
    
    int exponente = 0;
    for (int i = posicion - 1; i >= 0; i--)
    {
        Dir += (instruccion[i] - '0') * pow(10, exponente);
        exponente++;
    }
    
    instruccion.erase(0, posicion + 1);
    
    posicion = instruccion.find(" ");
    
    exponente = 0;
    for (int i = posicion - 1; i >= 0; i--)
    {
        ID += (instruccion[i] - '0') * pow(10, exponente);
        exponente++;
    }
    
    instruccion.erase(0, posicion + 1);
    
    exponente = 0;
    for (int i = instruccion.length() - 1; i >= 0; i--)
    {
        Mod += (instruccion[i] - '0') * pow(10, exponente);
        exponente++;
    }
}

void instruccionLiberar(string instruccion, int &ID)
{
    int posicion;
    // Borra la L y el primer espacio
    instruccion.erase(0,2);

    int exponente = 0;
    for (int i = instruccion.length() - 1; i >= 0; i--)
    {
        ID += (instruccion[i] - '0') * pow(10, exponente);
        exponente++;
    }
}

void proceso(string instruccion)
{
    int ID = 0;
    int Tam = 0;
    int paginas;
    instruccionProceso(instruccion, ID, Tam);
    
    if (Tam <= 2048)
    {
        paginas = Tam/8;
        if (Tam%8 != 0)
            paginas++;
        
        
    }
}

void acceso(string instruccion)
{
    int ID = 0;
    int Dir = 0;
    int Mod = 0;
    instruccionAcceso(instruccion, ID, Dir, Mod);
}

void liberar(string instruccion)
{
    int ID = 0;
    instruccionLiberar(instruccion, ID);
}

void fin()
{
    
}

int main() {
	ifstream archEntrada ("Pruebas.txt");
    int vecM = 2048, vecS = 4096;
    string line;
    vector<int> M, S;

	if (archEntrada.is_open())
	{
	    while ( getline (archEntrada,line))
	    {
	      if (line[0] == 'P')
	      {
	      	proceso(line);
	      }	

	      else if (line[0] == 'A')
	      {
	      	acceso(line);
	      }

	      else if (line[0] == 'L')
	      {
	      	liberar(line);
	      }

	      else if (line[0] == 'F')
	      {
	      	fin();
	      }

	      else if (line[0] == 'E')
	      	break;

	      else cout << "Error en la instruccion" << endl;
	  	}
	    archEntrada.close();
	 }
	 else cout << "Unable to open file"; 		

        
    return 0;
}
