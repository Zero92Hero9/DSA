import java.util.List;
import java.util.LinkedList;
import java.util.Map;
import java.util.HashMap;
import java.util.Set;
import java.util.HashSet;
import java.util.Deque;
import java.util.ArrayDeque;

public class AdjacencyListParsingTechniques {
	public static void main(String[] args) {
		int[][] prereqs = {{1,0}};
		Map<Integer, List<Integer>> adjacentMap = buildAdjacencyMap(prereqs);
		parseAjacencyMap(adjacentMap);
	}

	private static Map<Integer, List<Integer>> buildAdjacencyMap(int[][] prereqs) {
		Map<Integer, List<Integer>> map = new HashMap<>();

		for (int i = 0; i < prereqs.length; i++) {
			int key = prereqs[i][0];
			int value = prereqs[i][1];

			if (!map.containsKey(key)) {
				List<Integer> list = new LinkedList<>();
				list.add(value);
				map.put(key, list);				
			} else {
				map.get(key).add(value);
			}
		}

		return map;

	}

	private static void parseAjacencyMap(Map<Integer, List<Integer>> map) {
		Set<Integer> visited = new HashSet<>();
		Deque<Integer> q = new ArrayDeque<>();

		for (Integer i : map.keySet()) {
			q.addLast(i);

			while (!q.isEmpty()) {
				int value = q.poll();
				visited.add(value);
				List<Integer> dependencies = map.get(value);
				for (int d : dependencies) {
					if (map.containsKey(d)) {
						q.addLast(d);												
					}
					if (!visited.contains(d)) {
					 	visited.add(d);
					}
				}

			}
		}

		System.out.println(visited);
	}
}