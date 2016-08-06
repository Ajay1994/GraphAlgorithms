import java.util.*;
public class BreadthFirstSearch extends Graph{
	public BreadthFirstSearch(int v, boolean isDirected) {
		// TODO Auto-generated constructor stub
		super(v, isDirected);
	}
	public void printBFSTraversal(int startVertex){
		boolean[] visited = new boolean[this.V];
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(startVertex);
		visited[startVertex] = true;
		while(!queue.isEmpty()){
			Integer node = queue.remove();
			System.out.print(node + " | ");
			Iterator<Integer> iter = adjacencyList[node].iterator();
			while(iter.hasNext()){
				Integer adjacent = iter.next();
				if(!visited[adjacent]){
					queue.add(adjacent);
					visited[adjacent] = true;
				}
			}
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BreadthFirstSearch g = new BreadthFirstSearch(4, false);
		g.addEdge(0, 2);
	    g.addEdge(1, 2);
	    g.addEdge(2, 0);
	    g.addEdge(2, 3);
	    g.addEdge(3, 3);
	    g.printBFSTraversal(2);
	}

}
