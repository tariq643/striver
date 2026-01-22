package dsa.striver.array.faqHard;

import java.util.Scanner;

public class MultipleSumQuery {

    private static long mod = 1_000_000_0007L;

    public static void main() {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int q = sc.nextInt();
        long[] arr = new  long[n + 1];
        for (int i = 1; i <= n; i++) {
            arr[i] = sc.nextLong();
        }
        long[] prefixSum = new long[n + 1];
        long[] prefixSumMultiply = new long[n + 1];
        prefixSumMultiply[0] = 1;
        for (int i = 1; i <= n; i++) {
            prefixSumMultiply[i] = (prefixSumMultiply[i - 1] * arr[i]) % mod;
        }
        for (int i = 1; i <= n; i++) {
            prefixSum[i] = (prefixSum[i - 1] + arr[i]) % mod;
            prefixSumMultiply[i] = (prefixSumMultiply[i] + prefixSumMultiply[i - 1]) % mod;
        }
        for (int i = 1; i <= q; i++) {
            int l = sc.nextInt();
            int r = sc.nextInt();
            long ans = prefixSumMultiply[r] - prefixSumMultiply[l - 1];
            ans = ans - (l - 1) * (prefixSumMultiply[r] - prefixSumMultiply[l - 1]);
            ans = (ans % mod + mod) % mod;
            System.out.println(ans);
        }
    }
}
