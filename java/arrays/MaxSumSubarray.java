public class MaxSumSubarray {
    public static void main(String[] args) {
        int[] arr = {2, 1, 5, 1, 3, 2};
        int k = 3;

        System.out.println(maxSumSubarray(arr, k));

    }

    private static int maxSumSubarray(int[] arr, int k){
        if (arr.length < k) {
            return 0;
        }

       int currentSum = 0;

       for (int i = 0; i < k ; i++) {
        currentSum += arr[i];
       }

       int maxSum = currentSum;

       for (int i = k; i < arr.length; i++) {
        currentSum += arr[i] - arr[i-k];
        maxSum = Math.max(maxSum, currentSum); 
       }

       return maxSum;
    }
}
