package dsa.striver.dynamicProgramming.OneDimensionalDP;

import java.util.Arrays;

public class FrogJump {

    private int solve (int index, int[] heights, int[] dp) {

        if (index == 0) {
            return 0;
        }

        if (dp[index] != -1) {
            return dp[index];
        }

        int jumpOne = solve(index - 1, heights, dp) + Math.abs(heights[index] - heights[index - 1]);
        int jumpTwo = Integer.MAX_VALUE;
        if (index > 1) {
            jumpTwo = solve(index - 2, heights, dp) + Math.abs(heights[index] - heights[index - 2]);
        }
        return dp[index] = Math.min(jumpOne, jumpTwo);
    }

    public int frogJump(int[] heights) {

        int n = heights.length;
        int dp[] = new int[n+1];
        Arrays.fill(dp, -1);

        return solve(n -1,heights,dp);
    }
}
