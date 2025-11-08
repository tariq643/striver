package dsa.striver.heap;

import java.util.ArrayList;
import java.util.List;

public class ImplementMaxHeap {

    private List<Integer> arr; // list to store the max-heap
    private int count; // to store the count of elements in max-heap

    // Constructor
    public ImplementMaxHeap() {
        arr = new ArrayList<>();
        count = 0;
    }

    // Function to recursively heapify the array upwards
    private void heapifyUp(int ind) {
        int parentInd = (ind - 1) / 2;

        // If current index holds larger value than the parent
        if(ind > 0 && arr.get(ind) > arr.get(parentInd)) {
            // Swap the values at the two indices
            int temp = arr.get(ind);
            arr.set(ind, arr.get(parentInd));
            arr.set(parentInd, temp);

            // Recursively heapify the upper nodes
            heapifyUp(parentInd);
        }

        return;
    }

    // Function to recursively heapify the array downwards
    private void heapifyDown(int ind) {
        int n = arr.size(); // Size of the array

        // To store the index of largest element
        int largestInd = ind;

        // Indices of the left and right children
        int leftChildInd = 2*ind + 1;
        int rightChildInd = 2*ind + 2;

        // If the left child holds larger value, update the largest index
        if(leftChildInd < n && arr.get(leftChildInd) > arr.get(largestInd))
            largestInd = leftChildInd;

        // If the right child holds larger value, update the largest index
        if(rightChildInd < n && arr.get(rightChildInd) > arr.get(largestInd))
            largestInd = rightChildInd;

        // If the largest element index is updated
        if(largestInd != ind) {
            // Swap the largest element with the current index
            int temp = arr.get(largestInd);
            arr.set(largestInd, arr.get(ind));
            arr.set(ind, temp);

            // Recursively heapify the lower subtree
            heapifyDown(largestInd);
        }

        return;
    }

    // Method to intialize the max-heap data structure
    public void initializeHeap(){
        arr.clear();
        count = 0;
    }

    // Method to insert a given value in the max-heap
    public void insert(int key){
        // Insert the value at the back of the list
        arr.add(key);

        // Heapify upwards
        heapifyUp(count);
        count = count + 1; // Increment the counter;

        return;
    }

    // Method to change the value at a given index in max-heap
    public void changeKey(int index, int new_val){
        // If the current value is replaced with a larger value
        if(arr.get(index) < new_val) {
            arr.set(index, new_val);
            heapifyUp(index);
        }
        // Otherwise (if the current value is replaced with smaller value)
        else {
            arr.set(index, new_val);
            heapifyDown(index);
        }

        return;
    }

    // Method to extract the maximum value from the max-heap
    public void extractMax(){
        int ele = arr.get(0); // maximum value in the heap

        // Swap the top value with the value at last index
        int temp = arr.get(count - 1);
        arr.set(count - 1, arr.get(0));
        arr.set(0, temp);

        arr.remove(count - 1); // Pop the maximum value from the list
        count = count - 1; // Decrement the counter

        // Heapify the root value downwards
        if(count > 0) {
            heapifyDown(0);
        }
    }

    // Method to return if the max-heap is empty
    public boolean isEmpty(){
        return (count == 0);
    }

    // Method to return the maximum value in the max-heap
    public int getMax(){
        // Return the value stored at the root
        return arr.get(0);
    }

    // Method to return the size of max-heap
    public int heapSize(){
        return count;
    }
}
