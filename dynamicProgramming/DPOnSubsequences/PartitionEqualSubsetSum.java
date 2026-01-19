package dsa.striver.dynamicProgramming.DPOnSubsequences;

import java.util.Arrays;

public class PartitionEqualSubsetSum {

    private boolean funcRecursion (int index, int[] arr, int target) {

        if (target == 0) {
            return true;
        }
        if (index == 0) {
            return target == arr[index];
        }
        // exclude the given element
        boolean notTaken = funcRecursion(index - 1, arr, target);
        // include the given element
        boolean taken = false;
        if (target <= arr[index]) {
            taken = funcRecursion(index - 1, arr, target - arr[index]);
        }
        return notTaken || taken;
    }

    public boolean equalPartitionRecursion(int n, int[] arr) {

        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        if (sum % 2 == 1) {
            return false;
        }
        else {
            return funcRecursion(n, arr, sum / 2);
        }
    }



    public boolean equalPartitionMemoization(int n, int[] arr) {

        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        if (sum % 2 == 1) {
            return false;
        }
        else {
            // create a 2d DP array to store the state
            int k = sum / 2;
            int[][] dp = new int[n][k + 1];
            for (int[] row : dp) {
                Arrays.fill(row, -1);
            }
            return funcMemoization(n, arr, k, dp);
        }
    }

    private boolean funcMemoization(int ind, int[] arr, int target, int[][] dp) {
         /* Base case: If the target sum
        is 0, we found a valid partition*/
        if (target == 0)
            return true;

        /* Base case: If we have considered all elements
        and the target is still not 0, return false*/
        if (ind == 0)
            return arr[0] == target;

        /* If the result for this state is
        already calculated, return it*/
        if (dp[ind][target] != -1)
            return dp[ind][target] == 1;

        // Exclude the current element
        boolean notTaken = funcMemoization(ind - 1,arr, target,  dp);

        /* Include the current element if
        it doesn't exceed the target*/
        boolean taken = false;
        if (arr[ind] <= target)
            taken = funcMemoization(ind - 1, arr,target - arr[ind], dp);

        // Store the result and return it
        dp[ind][target] = (notTaken || taken) ? 1 : 0;
        return dp[ind][target] == 1;
    }
}
