import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;


public class ShiftStrings {
	public static void main(String[] args) {
		String[] strs = {"abc","bcd","acef","xyz","az","ba","a","z"};
		System.out.println(shiftedStrings(strs));	
	}

	private static String hashKey(String str) {
		char[] chars = str.toCharArray();
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i < chars.length; i++) {
			sb.append((char)((chars[i] - chars[i-1] + 26) % 26 + 'a'));
		}

		return sb.toString();
	}

	private static List<List<String>> shiftedStrings(String[] strs) {
		Map<String, List<String>> shiftedMap = new HashMap<>();
		List<List<String>> group = new ArrayList<>();
		for (String str : strs) {
			String key = hashKey(str);
			List<String> shiftedStrings = shiftedMap.get(key);
			if (shiftedStrings == null) {
				shiftedMap.put(key, new ArrayList<>());
			}
			shiftedMap.get(key).add(str);
		}

		for (Map.Entry<String, List<String>> entry : shiftedMap.entrySet()) {
			group.add(entry.getValue());
		}

		return group;

	}
}