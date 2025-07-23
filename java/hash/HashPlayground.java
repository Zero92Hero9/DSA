import java.util.Set;
import java.util.HashSet;

public class HashPlayground {
	public static void main(String[] args) {
		Set<Integer> numbers = new HashSet<>();
		int[] arr = {2,3,4,5,2};

		for (int i : arr) {
			if (!numbers.add(i)) {
				System.out.println("false");
			}
		}

		System.out.println("True");

	}
}