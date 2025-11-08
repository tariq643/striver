package dsa.striver.dynamicProgramming.DPOnSubsequences;

public class SubsetSumEqualsTarget {

    public boolean isSubsetSum(int[] arr, int target) {

        return subsetSum(arr.length - 1, arr, target);
    }

    private boolean subsetSum (int index, int[] nums, int sum) {

        if (sum == 0) {
            return true;
        }

        if (index == 0) {
            return sum == 0;
        }

        return subsetSum(index - 1, nums, sum - nums[index]) || subsetSum(index - 1, nums, sum);
    }
}
