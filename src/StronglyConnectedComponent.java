import java.util.*;
public class StronglyConnectedComponent {
	Graph graph;
	Graph reversedGraph;
	List<Set<Integer>> scc = new ArrayList<Set<Integer>>();
	Set<Integer> visited = new HashSet<Integer>();
	Stack<Integer> stack = new Stack<Integer>();
	public StronglyConnectedComponent(int v){
		graph = new Graph(v, true);
		reversedGraph = new Graph(v, true);
	}
	public void addEdgeGraph(int start, int end){
		this.graph.addEdge(start, end);
		this.reversedGraph.addEdge(end, start);
	}
	private void getSCCUtils() {
		for(int i = 0 ; i < graph.V; i++){
			if(!visited.contains(i)) DFSUtil(i);
		}
		
		visited.clear();
		while(!stack.isEmpty()){
			int vertex = stack.pop();
			if(!visited.contains(vertex)){
				Set<Integer> component = new HashSet<Integer>();
				DFSUtilReverse(vertex, component);
				scc.add(component);
			}
		}
	}
	private void DFSUtilReverse(int vertex, Set<Integer> component) {
		// TODO Auto-generated method stub
		visited.add(vertex);
		for(Integer adj : reversedGraph.adjacencyList[vertex]){
			if(!visited.contains(adj)){
				component.add(adj);
				DFSUtilReverse(adj, component);
			}
		}
		component.add(vertex);
	}
	private void DFSUtil(int startVertex) {
		// TODO Auto-generated method stub
		visited.add(startVertex);
		for(Integer adj : graph.adjacencyList[startVertex]){
			if(!visited.contains(adj)) DFSUtil(adj);
		}
		stack.push(startVertex);
	}
	public static void main(String[] args) {
		StronglyConnectedComponent scc = new StronglyConnectedComponent(5);
		scc.addEdgeGraph(1, 0);
		scc.addEdgeGraph(0, 2);
		scc.addEdgeGraph(2, 1);
		scc.addEdgeGraph(0, 3);
		scc.addEdgeGraph(3, 4);
		scc.getSCCUtils();
		
		for(Set<Integer> comp : scc.scc){
			for(Integer i : comp){
				System.out.print(i + " -> ");
			}
			System.out.println();
		}
	}
	
}
