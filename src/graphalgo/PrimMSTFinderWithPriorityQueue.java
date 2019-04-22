package graphalgo;

import graphs.Edge;
import graphs.UndirectedGraph;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;
import priorityqueues.MyPriorityQueue;
import priorityqueues.PriorityQueueImpl;

public class PrimMSTFinderWithPriorityQueue implements IMSTFinder {
	
	
	public Set<Edge> FindMST(UndirectedGraph g) {
		/*
		 * 1) If graph is empty exit
		 * 2) Set of edges for the MST
		 * 	  New Priority Queue of size g.getNrNodes
		 * 	  Visited array 
		 * 3) Number of nodes visited
		 * 4) Mark starting node as visited
		 * 5) Add all edges of the starting node in Priority Queue
		 * 	  (How to add edges in the predifined pq? it is for integer type..)
		 * 6) Keep adding 'till all nodes are visited
		 */
		
		// 1)
		if(g.getNrNodes() == 0)
			throw new NullPointerException("The Graph is empty");
		
		// 2)
		int cost = 0;
		Set<Edge> result = new HashSet<Edge>(); 
		PriorityQueue<Edge> pq = new PriorityQueue<Edge>(g.getNrNodes());
		boolean visited[] = new boolean[g.getNrNodes()];
		for(int i=0; i< g.getNrNodes(); i++) {
			visited[i] = false;
		}
		
		// 3)
		int inTree = 1;
		
		// 4)
		visited[0] = true;
		
		// 5)
		for(Edge e: g.edgesOutgoingFrom(0))
			pq.add(e);
		
		// 6)
		while(!pq.isEmpty() && inTree < g.getNrNodes())
		{
			Edge cur = pq.peek(); // get the edge with minimum priority
			pq.poll();
			
			if(visited[cur.source()])
				continue;
			
			inTree++;
			visited[cur.source()] = true;
			cost += cur.weight();
			
			for(Edge e: g.edgesOutgoingFrom(cur.source())) {
				pq.add(e);
			}
			
			result.add(cur);			
		}
		
		return result;
		
	}

}
