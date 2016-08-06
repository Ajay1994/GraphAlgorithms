import java.util.*;
public class TopologicalSort extends Graph {
	
	private Set<Integer> visited = new HashSet<Integer>();
	private Stack<Integer> stack = new Stack<Integer>();
	TopologicalSort(int v, boolean isDirected) {
		super(v, isDirected);
	}
	public static void main(String[] args) {
		TopologicalSort g = new TopologicalSort(6, true);
		g.addEdge(5, 2);
        g.addEdge(5, 0);
        g.addEdge(4, 0);
        g.addEdge(4, 1);
        g.addEdge(2, 3);
        g.addEdge(3, 1);
        for(int i = 0; i < g.V; i++){
        	if(!g.visited.contains(i)){
        		g.topologicalSortUtil(i, g);
        	}
        }
        while(!g.stack.isEmpty()){
        	System.out.print(g.stack.pop()+" -> ");
        }
	}
	private void topologicalSortUtil(int i, TopologicalSort graph) {
		visited.add(i);
		for(Integer adj : graph.adjacencyList[i]){
			if(!visited.contains(adj)) topologicalSortUtil(adj, graph);
		}
		stack.push(i);
	}
}
