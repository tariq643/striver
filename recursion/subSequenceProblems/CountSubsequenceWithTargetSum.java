package dsa.striver.recursion.subSequenceProblems;

public class CountSubsequenceWithTargetSum {

    private int countRecursion (int index, int[] nums, int sum) {

        if (sum == 0) {
            return 1;
        }
        if (sum < 0 || index == nums.length) {
            return 0;
        }
        return countRecursion(index + 1, nums, sum - nums[index]) + countRecursion(index + 1, nums, sum);
    }

    public int countSubsequenceWithTargetSum(int[] nums, int k) {
        //your code goes here
        return countRecursion(0, nums, k);
    }
}
