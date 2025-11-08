package dsa.striver.stack_queue.monotonicstack;

public class NextGreaterElementBruteForce {

    public int[] nextLargerElement(int[] arr) {

        int n = arr.length, nextLargerElement[] = new int[n];

        for (int i = 0; i < n; i++) {
            nextLargerElement[i] = -1;
        }

        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                if (arr[j] > arr[i]) {
                    nextLargerElement[i] = arr[j];
                    break;
                }
            }
        }
        return nextLargerElement;
    }
}
