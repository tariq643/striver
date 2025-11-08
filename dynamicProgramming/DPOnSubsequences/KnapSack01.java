package dsa.striver.dynamicProgramming.DPOnSubsequences;

public class KnapSack01 {

    public int knapsack01(int[] wt, int[] val, int n, int W) {

    return -1;
    }

    private int recur (int capacity, int[] val, int[] wt, int index) {

        if (capacity == 0) {
            return 0;
        }
        if (index == 0) {
            if (wt[index] <= capacity) {
                return val[index];
            }
            else {
                return 0;
            }
        }

        int pick = 0;
        return -1;
    }
}
