package dsa.striver.array;

public class LeftRotateArrayByKPlaces {

    public void rotateArray(int[] nums, int k) {

        int n = nums.length;
        k = k %  n;
        reverse(nums, 0 ,n- k - 1);
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
