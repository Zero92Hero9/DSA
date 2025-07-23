import java.lang.Math;
import java.util.List;
import java.util.Arrays;
import java.util.TreeSet;
import java.util.Set;

public class Duplicates {
	public static void main(String[] args) {
		int[] arr = {3,2,1,3,2,1};
		int k = 2;

		System.out.println(containsNearbyDups(arr, k));
	}

	private static boolean containsNearbyDups(int[] arr, int k) {
		Set<Integer> numbers = new TreeSet<>();

		for (int i = 0 ; i < arr.length; i++) {
			numbers.forEach(System.out::print);
			if (numbers.contains(arr[i])) {
				return true;
			}
			numbers.add(arr[i]);
			/*if (numbers.size() > k) {
				numbers.remove(arr[i - k]);
			}*/
			System.out.println();
		}

		return false;
	}
}