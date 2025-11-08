package dsa.striver.binarysearch.onanswers;

import dsa.kumarK.binarySearch.session1.FindNthRootOfM;

public class FindNthrootOfM {

    private int powFunc (int a, int n) {
        if (n < 0) {
            n = -1 * n;
            a = 1 / a;
        }
        int ans = 1;
        while (n > 0) {
            if (n % 2 == 1) {
                ans = ans * a;
            }
            a = a * a;
            n = n / 2;
        }
        return ans;
    }

    public int NthRoot(int N, int M) {

        int low = 1, high = M;
        while (low < high) {
            int mid = low + (high - low) / 2;
            int result = powFunc(mid, N);
            if (result == M) {
                return mid;
            }
            else if (result < M) {
                low = mid + 1;
            }
            else {
                high = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        FindNthRootOfM findNthRootOfM = new FindNthRootOfM();
        int ans = findNthRootOfM.NthRoot(4, 18);
        System.out.println(ans);
    }
}
