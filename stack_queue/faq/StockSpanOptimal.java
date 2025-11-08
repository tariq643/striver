package dsa.striver.stack_queue.faq;

import java.util.Stack;

public class StockSpanOptimal {

    public int[] stockSpan(int[] prices, int n) {

        int[] stockSpan = new int[n];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {

            while (!stack.isEmpty() && prices[stack.peek()] <= prices[i]) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                stockSpan[i] = i + 1;
            }
            else {
                stockSpan[i] = i - stack.peek();
            }
            stack.push(i);
        }
        return stockSpan;
    }

    public static void main(String[] args) {
        int n = 7;
        int[] arr = {120, 100, 60, 80, 90, 110, 115};

        /* Creating an instance of
        Solution class */
        StockSpanOptimal sol = new StockSpanOptimal();

        /* Function call to find the span
        of stock prices for each day */
        int[] ans = sol.stockSpan(arr, n);

        System.out.print("The span of stock prices is: ");
        for(int i = 0; i < n; i++) {
            System.out.print(ans[i] + " ");
        }
    }
}
