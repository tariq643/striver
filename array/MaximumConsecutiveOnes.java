package dsa.striver.array;

public class MaximumConsecutiveOnes {

    public int findMaxConsecutiveOnes(int[] nums) {

        int count = 0, maxLength = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                count++;
            }
            else {
                count = 0;
            }
            maxLength = Math.max(maxLength, count);
        }
        return maxLength;
    }
}
