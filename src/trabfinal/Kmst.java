package trabfinal;

import java.util.ArrayList;

/**
 *
 * @author luck_
 */

/* Algoritimos de Kruskal 

Codigo baseado em
https://www.geeksforgeeks.org/greedy-algorithms-set-2-kruskals-minimum-spanning-tree-mst/
*/


public class Kmst {
    public static ArrayList<Aresta> mst(Grafo g) {
		
		// Initial check for graph. Must be filled!
		if ( g.isEmpty() ) {
			throw new NullPointerException("Grafo está vazio ou nulo na memoria.");
		}
		
		// Resultant MST
		ArrayList<Aresta> result = new ArrayList<Aresta>();

		// Ordena as arestas baseado no peso (ASC) usando algoritimo de prioridade.
		OrderArestas peq = new OrderArestas();
		for (int i = 0; i < g.A; i++) {
			peq.add(g.aresta[i]);
		}

		// Create subsets for all vertices
		Subset subsets[] = new Subset[g.V];
		for (int v = 0; v < g.V; ++v) {
			subsets[v] = new Subset(v, 0);
		}

		// Se não esfaziou a fina entao a arvore minima nao esta completa.
		while (!peq.isEmpty()) {
			if ( result.size() >= g.V - 1 )
				break;

			// Pega a aresta atual
			Aresta next_edge = peq.poll();

			// Find subsets based on source and dest of current edge.
			int x = find(subsets, next_edge.src);
			int y = find(subsets, next_edge.dest);

			// If subset y (dest) is not subset x (src), union them.
			if (x != y) {
				result.add(next_edge);
				Union(subsets, x, y);
			}
		}

		return result;
	}
	
	/**
	 * Returns the parent vertex of a subset. If the parent is not yet set
	 * then it will search for it using path compression.
	 * @param subsets
	 * @param i
	 * @return
	 */
	private static int find(Subset subsets[], int i) {
		if (subsets[i].parent != i) {
			subsets[i].parent = find(subsets, subsets[i].parent);
		}

		return subsets[i].parent;

	}

	/**
	 * Unions subset X and subset Y based on rank.
	 * @param subsets
	 * @param x
	 * @param y
	 */
	private static void Union(Subset subsets[], int x, int y) {
		int xroot = find(subsets, x);
		int yroot = find(subsets, y);

		if (subsets[xroot].rank < subsets[yroot].rank) {
			subsets[xroot].parent = yroot;
		} else if (subsets[xroot].rank > subsets[yroot].rank) {
			subsets[yroot].parent = xroot;
		} else {
			subsets[yroot].parent = xroot;
			subsets[xroot].rank++;
		}
	}
}
