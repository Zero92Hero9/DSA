import java.util.Arrays;
import java.util.Map;
import java.util.HashMap;

/*
	Graph implementation with adjacency matrix.

	1) Graph g = (V, E). Ordered pair of Vertices and edges.
	2) Create a hashtable for vertex name and index
	3) Created a 2D adjacency matrix to map vertex with edges
*/

class Edge {
	private String startVertex;
	private String endVertex;
	private int weight;

	public Edge(String startVertex, String endVertex, int weight) {
		this.startVertex = startVertex;
		this.endVertex = endVertex;
		this.weight = weight;
	}

	public String getStartVertex() {
		return startVertex;
	}

	public String endVertex() {
		return endVertex;
	}

	public int getWeight() {
		return weight;
	}

}
class MyGraph {
	Map<String, Integer> vertexMap;
	int[][] edgeMatrix;
	int vertexIndex;

	public MyGraph(int vertices) {
		this.vertexMap = new HashMap<>(vertices);
		this.edgeMatrix = new int[vertices][vertices];
		for (int i = 0; i < edgeMatrix.length; i++) {
			Arrays.fill(edgeMatrix[i], 0);
		}
		this.vertexIndex = 0;
	}

	public void addEdge(String vertex1, String vertex2) {
		if (!vertexMap.containsKey(vertex1)) {
			vertexMap.put(vertex1, vertexIndex++);
		}

		if (!vertexMap.containsKey(vertex2)) {
			vertexMap.put(vertex2, vertexIndex++);
		}

		int start = vertexMap.get(vertex1);
		int end = vertexMap.get(vertex2);

		edgeMatrix[start][end] = 1;
		edgeMatrix[end][start] = 1;
	}

	public void removeEdge(String vertex1, String vertex2) {
		int vertex1Idx = vertexMap.get(vertex1);
		int vertex2Idx = vertexMap.get(vertex2);

		edgeMatrix[vertex1Idx][vertex2Idx] = 0;
		edgeMatrix[vertex2Idx][vertex1Idx] = 0;
	}

	public boolean isConnected(String vertex1, String vertex2) {
		int vertex1Idx = vertexMap.getOrDefault(vertex1, 0);
		int vertex2Idx = vertexMap.getOrDefault(vertex2, 0);

		return edgeMatrix[vertex1Idx][vertex2Idx] == 1;
	}

	public void printGraph() {
		for (int i = 0; i < edgeMatrix.length; i++) {
			for (int j = 0; j < edgeMatrix[i].length; j++) {
				System.out.print(edgeMatrix[i][j] + " ");
			}
			System.out.println();
		}
	}
}

public class AdjacencyMatrixPlayground {
	public static void main(String[] args) {
		MyGraph graph = new MyGraph(4);
		graph.addEdge("a", "b");
		graph.addEdge("b", "c");
		graph.addEdge("c", "d");
		graph.addEdge("c", "a");

		System.out.println(graph.isConnected("b", "d"));
		System.out.println(graph.isConnected("a", "c"));
		graph.printGraph();
		graph.removeEdge("c", "d");
		System.out.println(graph.isConnected("c", "d"));
		graph.printGraph();
	}
}

