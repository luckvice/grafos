/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabfinal;

/**
 *
 * @author luck_
 */
public class Aresta implements Comparable<Aresta> {
	public int src;
	public int dest;
	public int peso;
	
	public Aresta( int source, int dest, int weight ) {
		this.src = source;
		this.dest = dest;
		this.peso = weight;
	}
	
	public int compareTo(Aresta comparaAresta) {
		return this.peso-comparaAresta.peso;
	}

};
