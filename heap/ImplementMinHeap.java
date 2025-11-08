package dsa.striver.heap;

import java.util.ArrayList;
import java.util.List;

public class ImplementMinHeap {

    private List<Integer> arrayList;
    private int count;

    public ImplementMinHeap() {
        arrayList = new ArrayList<>();
        count = 0;
    }

    public void initializeHeap() {
        arrayList.clear();
        count = 0;
    }

    private void heapifyDown (int index) {

        int leftIndex = 2 * index + 1;
        int rightIndex = 2 * index + 2;

        int smallestIndex = index;
        int n = arrayList.size();

        if (index < n && arrayList.get(leftIndex) < arrayList.get(index)) {
            smallestIndex = leftIndex;
        }
        if (index < n && arrayList.get(rightIndex) < arrayList.get(index)) {
            smallestIndex = rightIndex;
        }

        if (smallestIndex != index) {
            int temp = arrayList.get(index);
            arrayList.set(index, arrayList.get(smallestIndex));
            arrayList.set(smallestIndex, temp);
            heapifyDown(smallestIndex);
        }
        return;
    }

    private void heapifyUp (int index) {

        int parentIndex = (index / 2) - 1;
        if (parentIndex > 0 && arrayList.get(parentIndex) > arrayList.get(index)) {
            int temp = arrayList.get(index);
            arrayList.set(index, arrayList.get(parentIndex));
            arrayList.set(parentIndex, temp);
            heapifyUp(parentIndex);
        }
        return;
    }

    public void insert(int key) {

        arrayList.add(key);
        heapifyUp(count);
        count = count + 1; // Increment the counter;

        return;
    }

    public void changeKey(int index, int newVal) {
        // If the current value is replaced with a smaller value
        if(arrayList.get(index) < newVal) {
            arrayList.set(index, newVal);
            heapifyUp(index);
        }
        // Otherwise (if the current value is replaced with larger value)
        else {
            arrayList.set(index, newVal);
            heapifyDown(index);
        }

        return;
    }

    public void extractMin() {
        int ele = arrayList.get(0); // maximum value in the heap

        // Swap the top value with the value at last index
        int temp = arrayList.get(count - 1);
        arrayList.set(count - 1, arrayList.get(0));
        arrayList.set(0, temp);

        arrayList.remove(count - 1); // Pop the maximum value from the list
        count = count - 1; // Decrement the counter

        // Heapify the root value downwards
        if(count > 0) {
            heapifyDown(0);
        }
    }

    public boolean isEmpty() {
        return (count == 0);
    }

    public int getMin() {
        return arrayList.get(0);
    }

    public int heapSize() {
        return count;
    }
}
