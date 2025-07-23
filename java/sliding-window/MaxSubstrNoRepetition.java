import java.util.Set;
import java.util.HashSet;
import java.lang.Math;

public class MaxSubstrNoRepetition {
	public static void main(String[] args) {
		String str = "abcabcbb";
		int n = str.length();
		int res = Integer.MIN_VALUE;

		for (int i = 0; i < n; i++) {
			for (int j = i; j < n; j++) {
				if (isRepeated(s, i, j)) {
					res = Math.max(res, j - i + 1);
				}
			}
		}

	}

	private static boolean isRepeated(String str, int start, int end) {
		Set<Character> chars = new HashSet<>();
		for (int i = start; i <= end; i++) {
			char c = s.charAt(i);
			if (chars.contains(c)) {
				return false;
			}
			chars.add(c);
		}

		return true;
	}


}