package dsa.striver.heap;

public class BuildMinHeapFromArray {

    private void heapifyDown (int[] nums, int index) {

        int n = nums.length;

        int leftIndex = 2 * index + 1;
        int rightIndex = 2 * index + 2;

        int smallestIndex = index;

        if (leftIndex < n && nums[leftIndex] < nums[index]) {
            smallestIndex = leftIndex;
        }

        if (rightIndex < n && nums[rightIndex] < nums[index]) {
            smallestIndex = rightIndex;
        }

        if (smallestIndex != index) {
            int temp = nums[index];
            nums[index] = nums[smallestIndex];
            nums[smallestIndex] = temp;

            heapifyDown(nums, smallestIndex);
        }
    }

    public void buildMinHeap(int[] nums) {

        int n = nums.length;

        for (int i = n / 2; i >= 0; i--) {
            heapifyDown(nums, i);
        }

    }
}
