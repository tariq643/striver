package dsa.striver.heap;

public class HeapSort {

    private void heapifyDown (int[] nums, int last, int index) {

        int leftIndex = 2 * index + 1;
        int rightIndex = 2 * index + 2;

        int largestIndex = index;

        if (leftIndex <= last && nums[leftIndex] > nums[largestIndex]) {
            largestIndex = leftIndex;
        }

        if (rightIndex <= last && nums[rightIndex] > nums[largestIndex]) {
            largestIndex = rightIndex;
        }

        if (largestIndex != index) {
            int temp = nums[index];
            nums[index] = nums[largestIndex];
            nums[largestIndex] = temp;
            heapifyDown(nums, last, largestIndex);
        }
    }

    private void buildMaxHeap(int[] nums) {

        int n = nums.length;
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapifyDown(nums, n - 1, i);
        }
        return;
    }

    public void heapSort(int[] nums) {

        buildMaxHeap(nums);

        int last = nums.length - 1;
        while (last > 0) {

            int temp = nums[0];
            nums[0] = nums[last];
            nums[last] = temp;

            last--;

            if (last > 0) {
                heapifyDown(nums, last, 0);
            }
        }
    }
}
