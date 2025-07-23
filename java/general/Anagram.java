import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.util.Map;
import java.util.HashMap;
import java.util.stream.Collectors;

public class Anagram {
	public static void main(String[] args) {
		String[] strs = {"ate", "eat", "tan", "tea", "nat", "bar"};
		int[] count = new int[26];
		Map<String, List<String>> anagramMap = new HashMap<>();
		List<List<String>> anagrams = new ArrayList<>();

		for (String s : strs) {
			Arrays.fill(count, 0);
			for (char ch : s.toCharArray()) {
				count[ch - 'a']++;
			}
			if (anagramMap.get(Arrays.toString(count)) == null) {
				anagramMap.put(Arrays.toString(count), new ArrayList<>());				
			} 
			anagramMap.get(Arrays.toString(count)).add(s);
		}

		System.out.println(anagramMap.entrySet().stream().mapToObj(e -> e.getValue()).collect(Collectors.toList()));

	}	
}