import java.util.Deque;
import java.util.ArrayDeque;


public class ReverseString {
	public static void main(String[] args) {
		String name = "raghu";
		Deque<Character> stack = new ArrayDeque<>();

		for (char c : name.toCharArray()) {
			stack.push(c);
		}

		while (!stack.isEmpty()) {
			System.out.print(stack.pop());
		}
	}
}