import java.lang.Math;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

public class MaxSumSubarray {
	public static void main(String[] args) {
		int[] arr = {2,1,5,1,3,2};
		int k = 3;
		int windowStart = 0;
		int max = Integer.MIN_VALUE;
		Map<Integer, List<Integer>> map = new HashMap<>();

		for (int windowEnd = 0; windowEnd < arr.length; windowEnd++) {
			int sum = 0;
			int runner = windowEnd;

			while (runner < k) {
				sum += arr[runner];
				System.out.println("sum" + sum);
				runner++;
			}
			max = Math.max(max, sum);
		}
		System.out.println(max);

	}
}