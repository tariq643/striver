package dsa.striver.stack_queue.faq;

import java.util.Stack;

public class CelebrityProblem {

    public int celebrity(int[][] M) {

        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < M.length; i++) {
            stack.push(i);
        }
        while (stack.size() > 1) {

            int i = stack.peek();
            stack.pop();
            int j = stack.peek();
            stack.pop();

            // i does not know j so i could not be the celebrity
            if (M[i][j] == 0) {
                stack.push(i);
            }
            else {
                stack.push(j);
            }
        }

        // check for the remaining element in the stack to be the celebrity
        int celebrity = stack.peek();
        for (int i = 0; i < M.length; i++) {

            // i does not celebrity or celebrity knows o
            if (i != celebrity && (M[i][celebrity] == 0 || M[celebrity][i] == 1)) {
                return -1;
            }
        }
        return celebrity;
    }
}
