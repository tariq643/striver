package dsa.striver.dynamicProgramming.OneDimensionalDP;

import java.util.Arrays;

public class FrogJumpWithKSteps {

    public int frogJump(int[] heights, int k) {

        int length = heights.length;
        int[] dp = new int[length + 1];
        Arrays.fill(dp, -1);
        dp[0] = 0;
        for (int i = 1; i < length; i++) {
            int mmSteps = Integer.MAX_VALUE;
            for (int j = 1; j <= k; j++) {
                if (i - j >= 0) {
                    int jump = dp[i - j] + Math.abs(heights[i] - heights[i - j]);
                    mmSteps = Math.min(mmSteps, jump);
                }
            }
            dp[i] = mmSteps;
        }
        return dp[length - 1];
    }
}
