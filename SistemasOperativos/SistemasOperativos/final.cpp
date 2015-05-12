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

int main() {
	ifstream archEntrada ("Pruebas.txt");
    int vecM = 2048, vecS = 4096;
    string line;
    vector<int> M, S;

	if (archEntrada.is_open())
	{
	    while ( getline (archEntrada,line) )
	    {
	      cout << line << '\n';
	    }
	    archEntrada.close();
	 }
	 else cout << "Unable to open file"; 		

        
    return 0;
}
