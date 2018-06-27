/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabfinal;

import java.util.PriorityQueue;

/**
 *
 * @author luck_
 * 
 * Adaptação
 * 
 * http://www.codebytes.in/2015/06/prims-algorithm-java-implementation.html
 */
public class OrderArestas {
	private PriorityQueue<Aresta> fila;
	
	public OrderArestas() {
		fila = new PriorityQueue<Aresta>((Aresta o1, Aresta o2) -> {
			return o1.compareTo(o2);
		});
	}

	public void add(Aresta e) {
		fila.add(e);
	}

	public boolean isEmpty() {
		return fila.isEmpty();
	}


	public Aresta poll() {
		return fila.poll();
	}
}

