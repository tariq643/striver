package dsa.striver.dynamicProgramming.OneDimensionalDP;

import java.util.Arrays;

public class HouseRobber {

    public int rob(int[] money) {

        int n = money.length;
        int dp[] = new int[n + 1];
        Arrays.fill(dp, -1);
        return recur(money, n, dp);
    }

    private int recur(int[] nums, int index, int[] dp) {

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

        int pick = nums[index-1] + recur(nums, index - 2, dp);
        int nonPick = 0 + recur(nums, index - 1, dp);
        return dp[index] = Math.max(pick, nonPick);
    }
}
