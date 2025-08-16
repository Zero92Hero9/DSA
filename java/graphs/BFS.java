import java.util.List;
import java.util.LinkedList;
import java.util.Map;
import java.util.HashMap;
import java.util.stream.IntStream;
import java.util.Deque;
import java.util.ArrayDeque;

class Edge {
	private int source, destination;

	public Edge(int source, int destination) {
		this.source = source;
		this.destination = destination;
	}	

	public int getSource() {
		return source;
	}

	public int getDestination() {
		return destination;
	}

	public String toString() {
		return source+","+destination;
	}
}

class Graph {
	private Map<Integer, LinkedList<Integer>> edgeList;
	private Map<Integer, Boolean> visited;

	public Graph(int vertices) {
		edgeList = new HashMap<>();		
		visited = new HashMap<>();
	}

	public void addEdge(Edge edge) {
		int v1 = edge.getSource();
		int v2 = edge.getDestination();

		LinkedList listV1 = edgeList.getOrDefault(v1, new LinkedList());
		LinkedList listV2 = edgeList.getOrDefault(v2, new LinkedList());
		listV1.add(v2);
		listV2.add(v1);		
		edgeList.put(v1, listV1);
		edgeList.put(v2, listV2);		
	}

	public void traverse(int vertex) {		
		Deque<Integer> vertices = new ArrayDeque<>();		
		vertices.add(vertex);

		while(!vertices.isEmpty()) {
			int vertexInQ = vertices.poll();
			System.out.print(vertexInQ + "->");
			visited.put(vertexInQ,true);

			List<Integer> l = edgeList.get(vertexInQ);

			if (!l.isEmpty()) {
				for (Integer i : l) {
					if (!visited.getOrDefault(i, false)) {						
						vertices.add(i);
						visited.put(i,true);
					}
				}
			}
		}
		System.out.println();
	}

	public void printGraph() {
		
		edgeList.entrySet().stream().forEach(e -> {
			System.out.print(e.getKey() + "->");
			for (int i : e.getValue()) {
				System.out.print(i+",");
			}
			System.out.println();	
		});
	}
}

public class BFS {
	public static void main(String[] args) {
		Graph g = new Graph(2);
		g.addEdge(new Edge(1,2));
		g.addEdge(new Edge(2,3));
		g.addEdge(new Edge(1,3));

		g.printGraph();
		g.traverse(2);
	}
}