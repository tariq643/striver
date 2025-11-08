package dsa.striver.array;

public class FindRepeatingAndMIssingNumber {

    public int[] findMissingRepeatingNumbers(int[] nums) {

        int output[] = new int[2];

        for (int i = 0; i < nums.length; i++) {
            int index = Math.abs(nums[i]) - 1;
            if (nums[index] > 0) {
                nums[index] = -1 * nums[index];
            }
            else {
                output[0] = Math.abs(nums[i]);
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                output[1] = i+1;
            }
        }
        return output;
    }
}
