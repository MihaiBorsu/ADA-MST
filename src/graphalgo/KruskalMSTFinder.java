package graphalgo;

import graphs.Edge;
import graphs.UndirectedGraph;
import sets.DisjointSet;

import java.util.*;


public class KruskalMSTFinder implements IMSTFinder{

	public Set<Edge> mst=new HashSet<Edge>();
	
	@Override
	public Set<Edge> FindMST(UndirectedGraph g) {
		/*
		 * 
			1) Put all edges in a data structure and sort according to the weight
			   and create a disjoint set
			2) Pick the edge with the smallest weight. If including it in mst forms a cycle drop the edge, else include it.
			3) Repeat step 2 'till mst is size of g.getNrNodes()-1
		 */
		
		// 1)
		PriorityQueue<Edge> pq = new PriorityQueue<>(g.getNrEdges(), Comparator.comparingDouble(o -> o.weight()));
		DisjointSet djs = new DisjointSet(g);
		
		for(Edge e: g.allEdges()) {
			pq.add(e);
		}
		
		// 2) 3)
		while(mst.size() != g.getNrNodes()-1)
		{
			Edge e = pq.peek();
			pq.poll();
			
			if(djs.createsLoop(e.source(), e.other(e.source())))  // if it creates loop we drop the edge
				continue;
			
			djs.setParent(e.other(e.source()), e.source());  // if not loop we set the destination node parent to the source node
			mst.add(e);
		}
		return null;
			
	}

}
