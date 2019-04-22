package sets;

import java.util.*;

import graphs.*;

public class DisjointSet {
	// map between each node and it's parent. Initially nodes do not have parents
	protected Map<Integer, Integer> disjSet = new HashMap<Integer, Integer>();  // Map<node, parent>

	public DisjointSet(UndirectedGraph g) {
		for(int i=0; i< g.getNrNodes(); i++)
			disjSet.put(i, null);  // initially set parent to null for every node
	}
	
	public int getParent(int node) {
		if(disjSet.get(node) == null)
			return node;
		else 
			return getParent(disjSet.get(node));
	}
	
	public void setParent(int node, int value) {
		disjSet.replace(node, value);
	}
	
	public boolean createsLoop(int node1, int node2) {
		if (getParent(node1) == getParent(node2))
			return true; // loop will be created created
		return false; //loop won't be created
	}
}
