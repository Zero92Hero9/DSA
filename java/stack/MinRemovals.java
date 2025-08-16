import java.util.Deque;
import java.util.ArrayDeque;
import java.util.Map;
import java.util.HashMap;

public class MinRemovals {
	public static void main(String[] args) {
		String brackets = "()))(()";
		System.out.println(minRemovalsToBalance(brackets));
	}

	private static int minRemovalsToBalance(String brackets) {
		Deque<Character> stack = new ArrayDeque<>();
		Map<Character, Character> matchingParen = Map.of(')','(');

		for (char ch : brackets.toCharArray()) {
			if (matchingParen.containsValue(ch)) {
				stack.push(ch);
			} else if (matchingParen.containsKey(ch)) {
				if (!stack.isEmpty() && matchingParen.get(ch) == stack.peek()) {
					stack.pop();
				} else {
					stack.push(ch);
				}
			}
		}

		return stack.size();
	}
}