import java.util.Map;
import java.util.HashMap;
import java.util.Deque;
import java.util.ArrayDeque;


public class ValidParentheses {
	public static void main(String[] args) {
		String expression = "([a+b]{c+d})";
		System.out.println(isValidExpression(expression));
	}

	private static boolean isValidExpression(String expression) {
		Deque<Character> stack = new ArrayDeque<>();
		Map<Character,Character> parenMap = Map.of(')','(','}','{',']','[');
		
		for (char c : expression.toCharArray()) {
			if (parenMap.containsValue(c)) {
				stack.push(c);
			} else if (parenMap.containsKey(c)) {
				if (!stack.isEmpty() && parenMap.get(c) == stack.peek()) {
					stack.pop();
				} else {
					stack.push(c);
				}			
			}
			System.out.println(stack);
		}

		if (stack.isEmpty()) {
			return true;
		} 		

		return false;
	}
}