package graphalgo;

import graphs.Edge;
import graphs.UndirectedGraph;

import java.util.HashSet;
import java.util.Set;


public class KruskalMSTFinder implements IMSTFinder{

	public Set<Edge> mst=new HashSet<Edge>();
	
	@Override
	public Set<Edge> FindMST(UndirectedGraph g) {
		/*
		 * Algorithm Kruskal(G)
				sort E by the edge weights // Note this is a Priority Queue
				make disjoint sets of vertices, d(v)
				while ecounter < |V|-1 and E is not empty do
				(u, v) ← remove minimum from E
				if find(u) ≠ find(v) then
				T ← union(u, v)
				ecounter++
				return T
		 */
		
		//PriorityQueue<Edge> pq = new PriorityQueue<Edge>(g);
		return null;
			
	}

}
