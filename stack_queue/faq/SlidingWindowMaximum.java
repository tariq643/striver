package dsa.striver.stack_queue.faq;

import java.util.ArrayList;
import java.util.List;

public class SlidingWindowMaximum {

    public int[] maxSlidingWindow(int[] arr, int k) {

        List<Integer> output = new ArrayList<>();
        int n = arr.length;
        for (int i = 0; i <= n - k; i++) {

            int maxi = arr[i];
            for (int j = i; j < i + k; j++) {

                maxi = Math.max(maxi, arr[j]);
            }
            output.add(maxi);
        }
        int out[] = new int[output.size()];
        for (int i = 0; i < output.size(); i++) {
            out[i] = output.get(i);
        }
        return out;
    }
}
