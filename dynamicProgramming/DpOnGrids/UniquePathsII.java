package dsa.striver.dynamicProgramming.DpOnGrids;

import java.util.Arrays;

public class UniquePathsII {

    public int uniquePathsWithObstacles(int[][] matrix) {

        int m = matrix.length;
        int n = matrix[0].length;
        int dp[][] = new int[m + 1][n + 1];
        for (int i = 0; i < m+1; i++) {
            Arrays.fill(dp[i], -1);
        }
        return recur(m, n, matrix, dp);
    }

    private int recur (int m, int n, int[][] matrix, int[][] dp) {

        if (m == 1 || n == 1) {
            dp[m][n] = 1;
            return 1;
        }
        if (m == 0 || n == 0 || matrix[m][n] == 1) {
            dp[m][n] = 0;
            return 0;
        }

        if (dp[m][n] != -1) {
            return dp[m][n];
        }

        return dp[m][n] = recur(m - 1,n,matrix, dp) + recur(m,n-1,matrix, dp);
    }
}
