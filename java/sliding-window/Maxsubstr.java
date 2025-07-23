import java.util.Set;
import java.util.HashSet;
import java.util.Map;
import java.util.HashMap;

public class Maxsubstr {
	public static void main(String[] args) {
		String str = "abcabcbb";
		System.out.println(maxSubstr1(str));
	}

	private static int maxSubstr(String str) {
		Map<Character, Integer> countMap = new HashMap<>();

		int left = 0;
		int right = 0;
		int res = 0;

		while (right < str.length()) {
			char ch = str.charAt(right);
			//expand right
			countMap.put(ch, countMap.getOrDefault(ch, 0) + 1);

			while (countMap.get(ch) > 1) {
				//shrink from left
				countMap.put(str.charAt(left), countMap.get(ch) - 1);
				left++;
			}

			res = Math.max(res, right - left + 1);
			right++;

		}

		return res;

	}

	private static int maxSubstr1(String str) {
		// map to track characters
		Map<Character, Integer> countMap = new HashMap<>();
		// window pointers
		int left;
		int right;
		//result
		int res = 0;

		for (left = 0, right = 0; right < str.length(); right++) {
			char rightChar = str.charAt(right);
			if (countMap.containsKey(rightChar)) {
				left = Math.max(countMap.get(rightChar), left);
			}
			countMap.put(rightChar, right + 1);
			res = Math.max(res, right - left + 1);
		}

		return res;
	}
}