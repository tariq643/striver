package dsa.striver.array.faqHard;

import java.util.Scanner;

public class LRSumQuery {

    static long mod = (long)1e9 + 7;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int q = scanner.nextInt();
        long arr[] = new long[n + 1];
        for (int i = 1; i <= n; i++) {
            arr[i] = scanner.nextLong();
        }
        long[] prefixSum = new long[n + 1];
        prefixSum[0] = 0;
        prefixSum[1] = arr[1];
        for (int i = 1; i <= n; i++) {
            prefixSum[i] = (prefixSum[i - 1] + arr[i] + mod) % mod;
        }
        while (q-- > 0) {
            int ind1 = scanner.nextInt();
            int ind2 = scanner.nextInt();
            System.out.println((prefixSum[ind2] - prefixSum[ind1 - 1] + mod) % mod);
        }
    }
}
