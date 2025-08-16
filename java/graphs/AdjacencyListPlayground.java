import java.util.List;
import java.util.LinkedList;
import java.util.Map;
import java.util.HashMap;

class CGraph {
	private Map<String, Integer> vertexMap;
	private LinkedList<Integer>[] edgeList;
	private int vertexIndex = 0;

	public CGraph(int vertices) {
		this.vertexMap = new HashMap<>(vertices);
		this.edgeList = new LinkedList[vertices];
	}

	public void addEdge(String vertex1, String vertex2) {
		if (!vertexMap.containsKey(vertex1)) {
			vertexMap.put(vertex1, vertexIndex++);
		}

		if (!vertexMap.containsKey(vertex2)) {
			vertexMap.put(vertex2, vertexIndex++);
		}

		int vertexIndex1 = vertexMap.get(vertex1);
		int vertexIndex2 = vertexMap.get(vertex2);

		if (edgeList[vertexIndex1] == null) {
			edgeList[vertexIndex1] = new LinkedList<>();			
		}
		if (edgeList[vertexIndex2] == null) {
			edgeList[vertexIndex2] = new LinkedList<>();			
		}

		edgeList[vertexIndex1].addLast(vertexIndex2);
		edgeList[vertexIndex2].addLast(vertexIndex1);		
	}

	public boolean isConnected(String vertex1, String vertex2) {
		int vertexIndex1 = vertexMap.get(vertex1);
		int vertexIndex2 = vertexMap.get(vertex2);

		return edgeList[vertexIndex1].contains(vertexIndex2);
	}

	public int shortestPath(String start, String end) {
		int vertexIndex1 = vertexMap.get(start);
		int vertexIndex2 = vertexMap.get(end);
		int distance = 0;

		if (isConnected(start, end)) {
			return 1;
		} else {

		}


		return distance;
	}

	public void printGraph() {
		for(int i = 0; i < edgeList.length; i++) {
			System.out.print(i + "->");
			for (Integer j : edgeList[i]) {				
				System.out.print(j + ",");				
			}
			System.out.println();
		}
	}
}

public class AdjacencyListPlayground {
	public static void main(String[] args) {
		CGraph cg = new CGraph(4);
		cg.addEdge("a", "b");
		cg.addEdge("a", "c");
		cg.addEdge("b", "d");
		cg.addEdge("c", "d");

		cg.printGraph();
		System.out.println(cg.isConnected("a", "c"));
		System.out.println(cg.isConnected("a", "d"));

	}
}