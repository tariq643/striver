package dsa.striver.array;

public class LeftRotateArrayByOne {

    public void rotateArrayByOne(int[] nums) {

        int n = nums.length;
        reverse(nums, 0 ,n-1);
        reverse(nums,0, n - 2);
    }

    private void reverse(int[] nums, int start, int end) {

        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}
