package dsa.striver.stack_queue.monotonicstack;

import java.util.Stack;

public class NextGreaterElement2Optimal {

    public int[] nextLargerElement(int[] arr) {

        int n = arr.length; // size of array

        // To store the next greater elements
        int[] ans = new int[n];

        // Stack to get elements in LIFO fashion
        Stack<Integer> st = new Stack<>();

        // Start traversing from the back
        for (int i = 2 * n - 1; i >= 0; i--) {

            // Get the actual index
            int ind = i % n;

            // Get the current element
            int currEle = arr[ind];

            /* Pop the elements in the stack until
            the stack is not empty and the top
            element is not the greater element */
            while (!st.isEmpty() && currEle >= st.peek()) {
                st.pop();
            }

            // Store the answer for the second half
            if (i < n) {

                /* If the greater element is not
                found, stack will be empty */
                if (st.isEmpty())
                    ans[i] = -1;

                    // Else store the answer
                else
                    ans[i] = st.peek();
            }

            /* Push the current element in the stack
            maintaining the decreasing order */
            st.push(currEle);
        }
        // Return the result
        return ans;
    }
}
