package dsa.striver.stack_queue.monotonicstack;

public class SumOfSubArrayMinimumBruteForce {

    public int sumSubarrayMins(int[] arr) {

        int minSum = 0, min = Integer.MAX_VALUE, n = arr.length;

        // generate all the subarrays
        for (int i = 0; i < n; i++) {
            min = Integer.MAX_VALUE;
            for (int j = i; j < n; j++) {
                min = Math.min(arr[j], min);
            }
            minSum = minSum + min;
        }
        return minSum;
    }
}
