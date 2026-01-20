package dsa.striver.dynamicProgramming.DPOnSubsequences;

import java.util.Arrays;

public class KnapSack01 {

    // Function to solve the 0/1 Knapsack problem with arrays
    private int func(int[] wt, int[] val, int ind, int W, int[][] dp) {
        /* Base case: If there are no items left
        or the knapsack has no capacity, return 0 */
        if (ind < 0 || W == 0) {
            return 0;
        }

        /* If the result for this state is
        already calculated, return it */
        if (dp[ind][W] != -1) {
            return dp[ind][W];
        }

        /* Calculate the maximum value by either
        excluding the current item or including it */
        int notTaken = func(wt, val, ind - 1, W, dp);
        int taken = 0;

        /* Check if the current item can be included
        without exceeding the knapsack's capacity */
        if (wt[ind] <= W) {
            taken = val[ind] + func(wt, val, ind - 1, W - wt[ind], dp);
        }

        // Store the result in the DP table and return
        dp[ind][W] = Math.max(notTaken, taken);
        return dp[ind][W];
    }

    public int knapsack01(int[] wt, int[] val, int n, int W) {
        // Initialize DP table with -1
        int[][] dp = new int[n][W + 1];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return func(wt, val, n - 1, W, dp);
    }
}
