import java.util.*;
public class DepthFirstSearch extends Graph{
	public DepthFirstSearch(int v, boolean isDirected){
		super(v, isDirected);
	}
	public void printDFSTraversal(boolean[] visited, Integer startNode){
		System.out.println(startNode + " | ");
		visited[startNode] = true;
		
		Iterator<Integer> iter = adjacencyList[startNode].iterator();
		while(iter.hasNext()){
			Integer node = iter.next();
			if(visited[node] == false){
				printDFSTraversal(visited, node);
			}
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DepthFirstSearch g = new DepthFirstSearch(4, false);
		 
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);
        boolean visited[] = new boolean[4];
        g.printDFSTraversal(visited, 2);
	}

}
