package dsa.striver.slidingwindowtwopointer.longestandsmallestwindowproblem;

public class MaxConsecutiveOnesIIIOptimal {

    public int longestOnes(int[] nums, int k) {
        // your code goes here
        // sliding window algorithm
        int n = nums.length, maxLen = 0, zeroes = 0;
        int l = 0, r = 0;

        while (r < n) {
            if (nums[r] == 0) {
                zeroes++;
            }
            if (zeroes > k) {
                if (nums[l++] == 0) {
                    zeroes--;
                }
            }
            else {
                maxLen = Math.max(r - l + 1, maxLen);
            }
            r++;
        }
        return maxLen;
    }
}
