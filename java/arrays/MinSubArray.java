public class MinSubArray {

    public static void main(String[] args) {
        int[] arr = {2, 3, 1, 2, 4, 3};
        int target = 7;

        System.out.println(minSubArrLen(arr, target));
    }

    private static int minSubArrLen(int[] arr, int target) {
        int left = 0;
        int right = 1;
        int subArrSum = arr[left] + arr[right];
        int minLength = Integer.MAX_VALUE;

        while (right < arr.length && left < right) {
            subArrSum += arr[right];

            if (subArrSum >= target) {
                subArrSum = subArrSum - arr[left];
                minLength = Math.min(minLength, right - left + 1);
                left++;
            } else {
                right++;
            }
        }

        return minLength;
    }
    
}
