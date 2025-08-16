import java.util.Deque;
import java.util.ArrayDeque;

public class ParanthesesCheck {
	public static void main(String[] args) {
		String expression = "[{})";
		System.out.println(isValid(expression));
	}

	private static boolean isValid(String expression) {
		Deque<Character> stack = new ArrayDeque<>();
		for (char ch : expression.toCharArray()) {
			switch(ch)  {
			case '(':
				stack.push(')');				
				break;
			case '[':
				stack.push(']');
				break;
			case '{':
				stack.push('}');
				break;
			default:
				if (!stack.isEmpty() && stack.peek() == ch) {
					stack.pop();
				} else {
					stack.push(ch);
				}
				break;
			}
		}

		return stack.isEmpty();
	}

}