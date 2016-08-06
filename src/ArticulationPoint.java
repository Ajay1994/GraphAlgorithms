import java.util.*;
public class ArticulationPoint {
	private Graph graph;
	
	private int time = 0;
	private Set<Integer> visited = new HashSet<Integer>();
	private Set<Integer> articulationPoints = new HashSet<Integer>();
	
	private Map<Integer, Integer> visitedTime = new HashMap<Integer, Integer>();
	private Map<Integer, Integer> lowTime = new HashMap<Integer, Integer>();
	private Map<Integer, Integer> parent = new HashMap<Integer, Integer>();
	
	public ArticulationPoint(Graph graph){
		this.graph = graph;
	}
	private void getArticulationPoints(int vertex) {
		// TODO Auto-generated method stub
		int childCount = 0;
		
		visited.add(vertex);
		visitedTime.put(vertex, time);
		lowTime.put(vertex, time);
		time += 1;
		boolean isArticulation = false;
		for(Integer adj : graph.adjacencyList[vertex]){
			
			//if adj is same as parent then just ignore this vertex.
			if(adj == parent.get(vertex)) continue;
			
			if(!visited.contains(adj)){
				parent.put(adj, vertex);
				childCount += 1;
				getArticulationPoints(adj);
				
				if(visitedTime.get(vertex) <= lowTime.get(adj)){
					isArticulation = true;
				}else{
					lowTime.put(vertex, Math.min(lowTime.get(vertex), lowTime.get(adj)));
				}
			}else{
				lowTime.put(vertex, Math.min(lowTime.get(vertex), visitedTime.get(adj)));
			}
		}
		
		if((parent.get(vertex) == null && childCount >= 2) ||
				(parent.get(vertex) != null && isArticulation == true)){
			articulationPoints.add(vertex);
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Graph graph = new Graph(5, false);
		graph.addEdge(1, 0);
		graph.addEdge(0, 2);
		graph.addEdge(2, 1);
		graph.addEdge(0, 3);
		graph.addEdge(3, 4);
		
		int startVertex = 0;
		
		ArticulationPoint findAP = new ArticulationPoint(graph);
		findAP.getArticulationPoints(startVertex);
		
		for(Integer ap : findAP.articulationPoints){
			System.out.println("Points : "+ ap);
		}
	}




	

}
