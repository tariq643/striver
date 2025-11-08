package dsa.striver.heap;

public class ConvertMinHeapToMaxHeap {

    private void heapifyDown (int[] nums, int index) {

        int n = nums.length;

        int leftIndex = 2 * index + 1;
        int rightIndex = 2 * index + 2;

        int largestIndex = index;

        if (leftIndex < n && nums[leftIndex] > nums[largestIndex]) {
            largestIndex = leftIndex;
        }

        if (rightIndex < n && nums[rightIndex] > nums[largestIndex]) {
            largestIndex = rightIndex;
        }

        if (largestIndex != index) {

            int temp = nums[largestIndex];
            nums[largestIndex] = nums[index];
            nums[index] = temp;

            heapifyDown(nums, largestIndex);
        }
        return;
    }

    public int[] minToMaxHeap(int[] nums) {

        int n = nums.length;

        for (int i = n / 2 - 1; i >= 0; i--) {
            heapifyDown(nums, i);
        }
        return nums;
    }
}
