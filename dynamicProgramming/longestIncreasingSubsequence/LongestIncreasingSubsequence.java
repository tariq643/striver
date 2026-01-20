package dsa.striver.dynamicProgramming.longestIncreasingSubsequence;

public class LongestIncreasingSubsequence {

        /* Function to find the longest increasing
        subsequence in the given array */
        public int LIS(int[] nums) {
            int n = nums.length;

            // DP array
            int[][] dp = new int[n + 1][n + 1];

            // Fill the DP table
            for (int i = n - 1; i >= 0; i--) {
                for (int prevInd = i - 1; prevInd >= -1; prevInd--) {
                    // Not Take case
                    int notTake = dp[i + 1][prevInd + 1];

                    // Take case
                    int take = 0;

                    // Check for the Take case
                    if (prevInd == -1 || nums[i] > nums[prevInd]) {
                        take = dp[i + 1][i + 1] + 1;
                    }

                    // Store the maximum of the two cases
                    dp[i][prevInd + 1] = Math.max(take, notTake);
                }
            }

            // Return the stored result
            return dp[0][0];
        }

    public class Main {
        public static void main(String[] args) {
            int[] nums = {10, 9, 2, 5, 3, 7, 101, 18};

            // Creating an object of Solution class
            LongestIncreasingSubsequence sol = new LongestIncreasingSubsequence();
            int lengthOfLIS = sol.LIS(nums);

            System.out.println("The length of the LIS for the given array is: " + lengthOfLIS);
        }
    }
}
