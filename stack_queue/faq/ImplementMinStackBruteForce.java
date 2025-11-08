package dsa.striver.stack_queue.faq;

import java.util.Stack;

public class ImplementMinStackBruteForce {

    private Stack<int[]> stack;

    public ImplementMinStackBruteForce() {
        stack = new Stack<>();
    }

    public void push(int val) {

        if (stack.isEmpty()) {
            stack.push(new int[]{val, val});
        }
        else {
            int min = Math.min(getMin(), val);
            stack.push(new int[]{val, min});
        }
    }

    public void pop() {
        stack.pop();
    }

    public int top() {
        return stack.peek()[0];
    }

    public int getMin() {
        return stack.peek()[1];
    }
}
