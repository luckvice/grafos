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
public class Grafo {
	public int V;
	public int A;
	public Aresta[] aresta;
	
	public Grafo(int v, int a) {
		V = v;
		A = a;
		aresta = new Aresta[A];
	}
	
	/**
	 * Retorna true se o grafo não estiver completo.
	 * @return
	 */
	public boolean isEmpty() {
		for (int i = 0; i < A; i++) {
			if ( aresta[i] == null )
				return true;
		}
		return false;
	}
}

