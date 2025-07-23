import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class PairSum {
	public static void main(String[] args) {
		int[] nums = {8, 7, 2, 5, 3, 1};
		int target = 10;	
		List<Integer[]> pairs = bruteForce(nums, target);

		if (pairs.isEmpty()) {
			System.out.println("Pair not found");
		} else {
			pairs.forEach(i -> System.out.println(Arrays.toString(i)));
		}

	}

	private static List<Integer[]> bruteForce(int[] nums, int target) {
		List<Integer[]> pairList = new ArrayList<>();
		for (int i = 0; i < nums.length; i++) {
			for (int j = i + 1; j < nums.length; j++) {
				int sum = nums[i] + nums[j];
				if (sum == target) {
					pairList.add(new Integer[] {i,j});
				}
			}
		}
		return pairList;
	}

	private static Integer[] pairSum(int[] nums, int target) {
		Map<Integer, Integer[]> pairMap = new HashMap<>();
		for (int i : nums) {
			int complement = target - nums[i];

			if (pairMap.containsKey(complement)) {
				return pairMap.get(complement);
			}

			pairMap.put()


		}
	}
}