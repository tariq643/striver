package dsa.striver.stack_queue.monotonicstack;

import java.util.Stack;

public class AsteriodCollision {

    public int[] asteroidCollision(int[] asteroids) {

        Stack<Integer> stack = new Stack<>();
        for (int asteroid : asteroids) {

            if (asteroid > 0) {
                stack.push(asteroid);
            }
            else {
                while (!stack.isEmpty() && stack.peek() > 0 && Math.abs(asteroid) > stack.peek()) {
                    stack.pop();
                }
                if (stack.isEmpty() || stack.peek() < 0) {
                    stack.push(asteroid);
                }
                else if (stack.peek() + asteroid == 0) {
                    stack.pop();
                }
            }
        }
        int output[] = new int[stack.size()], index = 0;
        for (int asteriod : stack) {
            output[index++] = asteriod;
        }
        return output;
    }
}
