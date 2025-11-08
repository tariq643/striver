package dsa.striver.recursion.subSequenceProblems;

public class CheckIfThereExistsASubSequenceWithSumK {

    private boolean solve (int i, int n, int[] nums, int sum) {

        if (sum == 0) {
            return true;
        }
        if (sum < 0) {
            return false;
        }
        if (i == n) {
            return sum == 0;
        }
        return solve(i+1 , n , nums, sum - nums[i]) || solve(i+1 , n , nums, sum);
    }

    public boolean checkSubsequenceSum(int[] nums, int k) {
        //your code goes here
        int n = nums.length;
        return solve (0, n, nums, k);
    }
}
