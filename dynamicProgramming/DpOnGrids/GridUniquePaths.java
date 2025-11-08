package dsa.striver.dynamicProgramming.DpOnGrids;

import java.util.Arrays;

public class GridUniquePaths {

    public int uniquePaths(int m, int n) {

        int dp[][] = new int[m + 1][n + 1];
        for (int i = 0; i < m+1; i++) {
            Arrays.fill(dp[i], -1);
        }
        return recur(m, n, dp);
    }

    private int recur (int m, int n, int[][] dp) {

        if (m == 1 || n == 1) {
            dp[m][n] = 1;
            return 1;
        }
        if (m == 0 || n == 0) {
            dp[m][n] = 0;
            return 0;
        }

        if (dp[m][n] != -1) {
            return dp[m][n];
        }

        return dp[m][n] = recur(m - 1,n,dp) + recur(m,n-1,dp);
    }
}
