package dsa.striver.heap;

import java.util.PriorityQueue;

public class KthLargestElementInArrayBetter {

    public int kthLargestElement(int[] nums, int k) {

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();

        int n = nums.length;

        for (int i = 0; i < k; i++) {
            priorityQueue.add(nums[i]);
        }

        for (int i = k; i < n; i++) {
            if (nums[i] > priorityQueue.peek()) {
                priorityQueue.poll();
                priorityQueue.add(nums[i]);
            }
        }
        return priorityQueue.peek();
    }
}
