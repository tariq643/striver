package dsa.striver.dynamicProgramming.OneDimensionalDP;

import java.util.Arrays;

public class MaximumSumOfNonAdjacentElements {

    private int recursiveFunc(int index, int[] nums, int dp[]) {

        if (index == 0) {
            return nums[index];
        }
        if (index < 0) {
            return 0;
        }
        if (dp[index] != -1) {
            return dp[index];
        }

        int pick = nums[index] + recursiveFunc(index - 2, nums, dp);
        int nonPick = 0 + recursiveFunc(index - 1, nums, dp);

        return dp[index] = Math.max(pick, nonPick);
    }

    public int nonAdjacent(int[] nums) {

        int n = nums.length - 1;
        int dp[] = new int[n+1];
        Arrays.fill(dp ,-1);

        return recursiveFunc(n, nums, dp);
    }
}
