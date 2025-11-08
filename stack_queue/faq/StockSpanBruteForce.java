package dsa.striver.stack_queue.faq;

public class StockSpanBruteForce {

    public int[] stockSpan(int[] arr, int n) {

        int[] output = new int[n];
        int count = 0;

        for (int i = 0; i < n; i++) {

            count = 1;

            for (int j = 0; j < i; j++) {
                if(arr[j] < arr[i]) {
                    count++;
                }
            }

            output[i] = count;
        }
        return output;
    }
}
