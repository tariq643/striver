package dsa.striver.stack_queue.faq;

import java.util.Stack;

public class LargestAreaUnderHistogram {

    public int largestRectangleArea(int[] heights) {

        int maxArea = Integer.MIN_VALUE, currArea = 0;

        int n = heights.length;
        int leftSmallestNearest[] = new int[n];
        int rightSmallestNearest[] = new int[n];

        Stack<Integer> stack = new Stack<>();

        // right smallest nearest
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && heights[i] <= heights[stack.peek()]) {
                stack.pop();
            }
            rightSmallestNearest[i] = stack.isEmpty() ? n : stack.peek();
            stack.push(i);
        }

        // empty the stack
        while (!stack.isEmpty()) {
            stack.pop();
        }

        // left smallest nearest
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
                stack.pop();
            }
            leftSmallestNearest[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }

        for (int i = 0; i < n; i++) {
            currArea = heights[i] * (rightSmallestNearest[i] - leftSmallestNearest[i] - 1);
            maxArea = Math.max(currArea, maxArea);
        }

        return maxArea;
    }
}
