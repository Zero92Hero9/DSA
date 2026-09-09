public class MinAvgSubarr {
    public static void main(String[] args) {
        int[] arr = {4, 2, 1, 7, 8, 1};
        int k = 3;

        System.out.println(minAvg(arr, k));
    }

    private static float minAvg(int[] arr, int k) {
        int runningState = 0;

        for (int i = 0; i < k; i++) {
            runningState += arr[i];
        }

        float result = (float) runningState/k;

        for (int i = k; i < arr.length; i++) {
            int entering = arr[i];
            int leaving = arr[i-k];

            runningState += entering - leaving;
            result = Math.min(result, (float)runningState/k);
        }

        return result;
    }
}