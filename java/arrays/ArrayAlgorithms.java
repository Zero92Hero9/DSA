public class ArrayAlgorithms {
    
    public static void main(String[] args) {
        int[] arr = {1, 3, 4, 6, 8, 10}; 
        int target = 13;

        System.out.println(hasTargetSumBf(arr, target));
    }

    public static boolean hasTargetSum(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;

        while (left < right) {
            int sum = arr[left] + arr[right];

            if (sum == target) {
                return true;
            }
            if (sum > target) {
                right--;
            } else if (sum < target) {
                left++;
            }
        }

        return false;
    }

    public static boolean hasTargetSumBf(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i+1; j < arr.length; j++) {
                int sum = arr[i] + arr[j];

                if (sum == target) {
                    return true;
                }
            }
        }

        return false;
    }
    
}
