/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabfinal;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author luck_
 * 
 *Codigo baseado em
https://www.geeksforgeeks.org/greedy-algorithms-set-2-kruskals-minimum-spanning-tree-mst/
 */
public class TrabFinal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        int V = 13; // 
        int E = 21; //

        Grafo g = new Grafo(V, E);

        BufferedReader br = new BufferedReader(new FileReader("C:\\ESD\\grafo.txt"));

        int c = 0;

        
        
        for (String line = br.readLine(); line != null; line = br.readLine()) {
            String[] fields = line.split(" ");
            g.aresta[c] = new Aresta(Integer.parseInt(fields[0]), Integer.parseInt(fields[1]), Integer.parseInt(fields[2]));
            System.out.println(fields[0]);
            c++;

        }

        ArrayList<Aresta> algoritimo = Kmst.mst(g);

        System.out.println("Algoritimo de Kruskal MST:\n");

    
       int pesoTotal = 0;
       for (int i = 0; i < algoritimo.size(); ++i) {
            Aresta r = algoritimo.get(i);
            pesoTotal += r.peso;
            //Mostrar resultados
            System.out.println("De:   " + r.src + " para " + r.dest + "   -->   Peso: " + r.peso);
        }
        System.out.println();
        System.out.println("\tNumero de vertices: " + algoritimo.size());
        System.out.println("\tPeso total: " + pesoTotal);
        System.out.println("----------------");
        System.out.println();

    }


}
