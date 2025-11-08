package dsa.striver.heap;

public class HeapifyAlgorithmPractise {

    private void heapifyDown (int[] arr, int index) {

        int n = arr.length;

        int leftIndex = index * 2 + 1;
        int rightIndex = index * 2 + 2;

        int smallestIndex = index;

        if (leftIndex < n && arr[leftIndex] < arr[smallestIndex]) {
            smallestIndex = leftIndex;
        }

        if (rightIndex < n && arr[rightIndex] < arr[smallestIndex]) {
            smallestIndex = rightIndex;
        }

        if (smallestIndex != index) {
            int temp = arr[index];
            arr[smallestIndex] = arr[index];
            arr[index] = temp;
            heapifyDown(arr, smallestIndex);
        }
    }

    private void heapifyUp (int[] arr, int index) {

        int parentIndex = (index / 2) -1;

        if (index > 0 && arr[parentIndex] > arr[index]) {
            int temp = arr[index];
            arr[parentIndex] = arr[index];
            arr[index] = temp;
            heapifyUp(arr, parentIndex);
        }
    }

    // Function to implement the heapify algorithm for a min-heap
    public void heapify(int[] nums, int ind, int val) {

        if (nums[ind] > val) {
            nums[ind] = val;
            heapifyUp(nums, ind);
        }
        else {
            nums[ind] = val;
            heapifyDown(nums, ind);
        }
    }

    public static void main(String[] args) {

        HeapifyAlgorithmPractise heapifyAlgorithmPractise = new HeapifyAlgorithmPractise();
        int[] nums = {1,2,5,5,7,2};
        heapifyAlgorithmPractise.heapify(nums, 5 ,2);
    }
}
