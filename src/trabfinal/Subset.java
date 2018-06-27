/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabfinal;

/**
 *
 * @author luck_
 * 
 Codigo baseado em 
 * https://www.geeksforgeeks.org/greedy-algorithms-set-2-kruskals-minimum-spanning-tree-mst/
 */
public class Subset {
	public int parent;
	public int rank;
	
	public Subset(int parent, int rank) {
		this.parent = parent;
		this.rank = rank;
	}
};