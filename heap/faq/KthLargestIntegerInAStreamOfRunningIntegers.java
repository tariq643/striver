package dsa.striver.heap.faq;

import java.util.PriorityQueue;

public class KthLargestIntegerInAStreamOfRunningIntegers {

    private int k;
    private PriorityQueue<Integer> priorityQueue;

    public KthLargestIntegerInAStreamOfRunningIntegers(int k, int[] nums) {

        this.k = k;
        priorityQueue = new PriorityQueue<>();

        for (int i = 0; i < nums.length; i++) {
            if (priorityQueue.size() < k) {
                priorityQueue.offer(nums[i]);
            }
            else if (nums[i] > priorityQueue.peek()) {
                priorityQueue.poll();
                priorityQueue.offer(nums[i]);
            }
        }
    }

    public int add(int val) {

        if (priorityQueue.size() < k) {
            priorityQueue.offer(val);
            return priorityQueue.peek();
        }
        else if (val > priorityQueue.peek()) {
            priorityQueue.poll();
            priorityQueue.offer(val);
        }
        return priorityQueue.peek();
    }
}
