package dsa.striver.heap;

public class CheckArrayIsMinHeapPractise {

    private boolean helper(int[] nums, int index, int n) {

        if (index >= n) {
            return true;
        }
        int leftIndex = 2 * index + 1;
        int rightIndex = 2 * index + 2;
        if (leftIndex < n && nums[leftIndex] > nums[index]) {
            return false;
        }
        if (rightIndex < n && nums[rightIndex] > nums[index]) {
            return false;
        }
        return helper(nums, leftIndex, n) && helper(nums, rightIndex, n);
    }

    public boolean isHeap(int[] nums) {

        int n = nums.length;
        return helper(nums, 0, n);
    }
}
