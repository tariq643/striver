package dsa.striver.array.faqHard;

import java.util.Scanner;

public class GoodNumbers {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int q = sc.nextInt();
        int arr[] = new int[n + 1];
        int temp = n;
        while (temp-- > 0) {
            int l = sc.nextInt();
            int r = sc.nextInt();
            arr[l] = arr[l] + 1;
            if (r + 1 <= n) {
                arr[r + 1] = arr[r + 1] - 1;
            }
        }
        for (int i = 1; i <= n; i++) {
            arr[i] = arr[i] + arr[i - 1];
        }
        for (int i = 1; i <= n; i++) {
            if (arr[i] >= k) {
                arr[i] = 1;
            }
            else {
                arr[i] = 0;
            }
        }
        int[] prefixSum = new  int[n + 1];
        for (int i = 1; i <= n; i++) {
            prefixSum[i] = prefixSum[i - 1] + arr[i];
        }
        while (q-- > 0) {
            int l = sc.nextInt();
            int r = sc.nextInt();
            System.out.println(prefixSum[r] + prefixSum[l - 1]);
        }
    }
}
