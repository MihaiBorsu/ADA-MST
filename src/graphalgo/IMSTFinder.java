package graphalgo;

import graphs.Edge;
import graphs.UndirectedGraph;

import java.util.Set;

public interface IMSTFinder {
	Set<Edge> FindMST(UndirectedGraph g);	
}
