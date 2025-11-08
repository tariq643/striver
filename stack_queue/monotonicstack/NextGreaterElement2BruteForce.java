package dsa.striver.stack_queue.monotonicstack;

import java.util.Arrays;

public class NextGreaterElement2BruteForce {

    public int[] nextLargerElement(int[] arr) {

        int n = arr.length, nextLargerElement[] = new int[n];
        Arrays.fill(nextLargerElement, -1);
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n + i - 1; j++) {
                int index = j % n;
                if (arr[index] > arr[i]) {
                    nextLargerElement[i] = arr[index];
                    break;
                }
            }
        }
        return nextLargerElement;
    }
}
