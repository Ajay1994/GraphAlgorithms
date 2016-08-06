import java.util.*;

public class BellmanFord {
	class Edge{
		int src;
		int dest;
		int weight;
	}
	
	int V;
	int E;
	Edge[] edges;
	
	public BellmanFord(int V, int E){
		this.V = V;
		this.E = E;
		edges = new Edge[E];
		for(int i = 0; i < E; i++){
			edges[i] = new Edge();
		}
	}
	
	private Map<Integer, Integer> findSingleSourcePath(int sourceVertex) {
		// TODO Auto-generated method stub
		Map<Integer, Integer> cost = new HashMap<Integer, Integer>();
		for(int i = 0 ; i < this.V; i++){
			if(i == sourceVertex) cost.put(i, 0);
			else cost.put(i, Integer.MAX_VALUE);
		}
		for(int i = 0; i < (V - 1); i++){
			for(Edge edge : edges){
				if(cost.get(edge.dest) > (cost.get(edge.src) + edge.weight)){
					cost.put(edge.dest, (cost.get(edge.src) + edge.weight));
				}
			}
		}
		
		for(Edge edge : edges){
			if(cost.get(edge.dest) > (cost.get(edge.src) + edge.weight)){
				System.out.println("Graph Contains the Negative Cycle.");
			}
		}
		return cost;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BellmanFord graph = new BellmanFord(5, 8);
		graph.edges[0].src = 0;
	    graph.edges[0].dest = 1;
	    graph.edges[0].weight = -1;
	 
	    // add edges 0-2 (or A-C in above figure)
	    graph.edges[1].src = 0;
	    graph.edges[1].dest = 2;
	    graph.edges[1].weight = 4;
	 
	    // add edges 1-2 (or B-C in above figure)
	    graph.edges[2].src = 1;
	    graph.edges[2].dest = 2;
	    graph.edges[2].weight = 3;
	 
	    // add edges 1-3 (or B-D in above figure)
	    graph.edges[3].src = 1;
	    graph.edges[3].dest = 3;
	    graph.edges[3].weight = 2;
	 
	    // add edges 1-4 (or A-E in above figure)
	    graph.edges[4].src = 1;
	    graph.edges[4].dest = 4;
	    graph.edges[4].weight = 2;
	 
	    // add edges 3-2 (or D-C in above figure)
	    graph.edges[5].src = 3;
	    graph.edges[5].dest = 2;
	    graph.edges[5].weight = 5;
	 
	    // add edges 3-1 (or D-B in above figure)
	    graph.edges[6].src = 3;
	    graph.edges[6].dest = 1;
	    graph.edges[6].weight = 1;
	 
	    // add edges 4-3 (or E-D in above figure)
	    graph.edges[7].src = 4;
	    graph.edges[7].dest = 3;
	    graph.edges[7].weight = -3;
	    
	    int sourceVertex = 0;
	    
	    Map<Integer, Integer> cost = graph.findSingleSourcePath(sourceVertex);
	    for(int i = 0 ; i < graph.V; i++){
	    	System.out.println("Vertex : "+ i + " Cost : "+ cost.get(i));
	    }
	}

	

}
