package dsa.striver.dynamicProgramming.OneDimensionalDP;

import java.util.Arrays;

public class HouseRobberII {

    public int rob(int[] money) {

        int n = money.length;
        int dp[] = new int[n];
        Arrays.fill(dp, -1);
        return Math.max(recur1(money, n - 1, dp), recur2(money, n, dp));
    }

    private int recur1(int[] nums, int index, int[] dp) {

        if (index == 1) {
            dp[index] = nums[0];
            return dp[index];
        }
        if (index == 0) {
            dp[index] = 0;
            return 0;
        }

        if (dp[index] != -1) {
            return dp[index];
        }

        int pick = nums[index-1] + recur1(nums, index - 2, dp);
        int nonPick = 0 + recur1(nums, index - 1, dp);
        return dp[index] = Math.max(pick, nonPick);
    }

    private int recur2(int[] nums, int index, int[] dp) {

        if (index == 2) {
            dp[index] = nums[0];
            return dp[index];
        }
        if (index == 1) {
            dp[index] = 0;
            return 0;
        }

        if (dp[index] != -1) {
            return dp[index];
        }

        int pick = nums[index-1] + recur2(nums, index - 2, dp);
        int nonPick = 0 + recur2(nums, index - 1, dp);
        return dp[index] = Math.max(pick, nonPick);
    }
}
