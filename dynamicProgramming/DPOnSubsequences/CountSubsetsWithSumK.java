package dsa.striver.dynamicProgramming.DPOnSubsequences;

import java.util.Arrays;

public class CountSubsetsWithSumK {

    private static final int MODULO = 1000000007;

    /* Function to count the number of
   subsets with sum k using memoization */
    private int findWaysUtil(int ind, int target, int[] arr, int[][] dp) {

        if (target == 0) {
            return 1;
        }
        if (ind == 0) {
            return target == arr[0] ? 1 : 0;
        }
        /* If the result for this state
        is already calculated, return it */
        if (dp[ind][target] != -1)
            return dp[ind][target];

        // Exclude the current element
        int notTaken = findWaysUtil(ind - 1, target, arr, dp);

        /* Include the current element if
        it doesn't exceed the target */
        int taken = 0;
        if (arr[ind] <= target)
            taken = findWaysUtil(ind - 1, target - arr[ind], arr, dp);

        /* Store the result in DP table and return
        Also, take modulo for the code to be accepted*/
        return dp[ind][target] = (notTaken + taken) % MODULO;
    }

    public int perfectSum(int[] arr, int k) {

        int n = arr.length;

        int[][] dp = new int[n][k + 1];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return this.findWaysUtil(n - 1, k, arr, dp);
    }
}
