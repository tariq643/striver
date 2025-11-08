package dsa.striver.hashing;

public class LongestSubArrayWithSumK {

    public int longestSubarray(int[] nums, int k) {

        int maxLengthSubArray = 0, left = 0, sum = 0;
        for (int right = 0; right < nums.length; right++) {

            sum += nums[right];
            while (sum > k && left <= right) {
                sum = sum - nums[left++];
            }
            maxLengthSubArray = Math.max(maxLengthSubArray, right - left + 1);
        }
        return maxLengthSubArray;
    }
}
