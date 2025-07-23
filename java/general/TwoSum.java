import java.util.Arrays;
import java.util.Map;
import java.util.HashMap;

public class TwoSum {
	public static void main(String[] args) {
		int[] nums = {3,2,4};
		int target = 6;
		System.out.println(Arrays.toString(twoSum(nums).get(target)));
	}

	public static Map<Integer, Integer[]> twoSum(int[] nums) {
		Map<Integer, Integer[]> m = new HashMap<>();

		for (int i = 0; i < nums.length; i++) {
		 for (int j = i + 1; j < nums.length; j++) {
		 	m.put(nums[i] + nums[j], new Integer[]{i,j});
		 }
		}

		return m;
	}
}