package dsa.striver.heap;

public class HeapifyAlgorithm {

    // Function to recursively heapify the array downwards
    private void heapifyDown(int[] arr, int ind) {
        int n = arr.length; // Size of the array

        // Index of smallest element
        int smallest_Ind = ind;

        // Indices of the left and right children
        int leftChild_Ind = 2 * ind + 1;
        int rightChild_Ind = 2 * ind + 2;

        // If the left child holds a smaller value, update the smallest index
        if (leftChild_Ind < n && arr[leftChild_Ind] < arr[smallest_Ind]) {
            smallest_Ind = leftChild_Ind;
        }

        // If the right child holds a smaller value, update the smallest index
        if (rightChild_Ind < n && arr[rightChild_Ind] < arr[smallest_Ind]) {
            smallest_Ind = rightChild_Ind;
        }

        // If the smallest element index is updated
        if (smallest_Ind != ind) {
            // Swap the smallest element with the current index
            int temp = arr[smallest_Ind];
            arr[smallest_Ind] = arr[ind];
            arr[ind] = temp;

            // Recursively heapify the lower subtree
            heapifyDown(arr, smallest_Ind);
        }
    }

    // Function to recursively heapify the array upwards
    private void heapifyUp(int[] arr, int ind) {
        int parent_Ind = (ind - 1) / 2;

        // If current index holds a smaller value than its parent
        if (ind > 0 && arr[ind] < arr[parent_Ind]) {
            // Swap the values at the two indices
            int temp = arr[ind];
            arr[ind] = arr[parent_Ind];
            arr[parent_Ind] = temp;

            // Recursively heapify the upper nodes
            heapifyUp(arr, parent_Ind);
        }
    }

    // Function to implement the heapify algorithm for a min-heap
    public void heapify(int[] nums, int ind, int val) {
        // If the current value is replaced with a smaller value
        if (nums[ind] > val) {
            nums[ind] = val;
            heapifyUp(nums, ind);
        }
        // Else if the current value is replaced with a larger value
        else {
            nums[ind] = val;
            heapifyDown(nums, ind);
        }
    }
}
