package dsa.striver.array;

public class KadaneAlgorithm {

    public int maxSubArray(int[] nums) {

        int currSum = 0, maxSum =  Integer.MIN_VALUE;
        for (int num : nums) {
            currSum+= num;
            maxSum = currSum > maxSum ? currSum : maxSum;
            currSum = currSum > 0 ? currSum : 0;
        }
        return maxSum;
    }
}
